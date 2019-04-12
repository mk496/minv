package com.cg.hkrbudgeting.budgetingmanagement.service.impl.odata;

import com.cg.hkrbudgeting.budgetingmanagement.service.impl.odata.util.AnnotationHelper;
import com.cg.hkrbudgeting.budgetingmanagement.service.impl.odata.util.ClassHelper;
import org.apache.olingo.odata2.api.annotation.edm.*;
import org.apache.olingo.odata2.api.edm.EdmConcurrencyMode;
import org.apache.olingo.odata2.api.edm.EdmMultiplicity;
import org.apache.olingo.odata2.api.edm.FullQualifiedName;
import org.apache.olingo.odata2.api.edm.provider.*;
import org.apache.olingo.odata2.api.exception.ODataException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Provider for the entity data model used in the reference scenario
 */
public class AnnotationEdmProviderExtension extends EdmProvider {

    private static final AnnotationHelper ANNOTATION_HELPER = new AnnotationHelper();

    private final List<Class<?>> annotatedClasses;

    private final Map<String, EntityContainer> name2Container = new HashMap<>();

    private final Map<String, ContainerBuilder> containerName2ContainerBuilder = new HashMap<>();

    private final Map<String, Schema> namespace2Schema = new HashMap<>();

    private EntityContainer defaultContainer;

    /**
     * Create an <code>AnnotationEdmProvider</code> based on given annotated classes.
     *
     * @param annotatedClasses all classes which are annotated and are used as Edm
     */
    public AnnotationEdmProviderExtension(final Collection<Class<?>> annotatedClasses) throws ODataException {

        this.annotatedClasses = new ArrayList<>(annotatedClasses.size());
        this.annotatedClasses
                .addAll(annotatedClasses.stream().filter(ANNOTATION_HELPER::isEdmAnnotated)
                        .collect(Collectors.toList()));

        init();
    }

    private void init() throws ODataException {

        for (Class<?> aClass : this.annotatedClasses) {
            updateSchema(aClass);
            handleEntityContainer(aClass);
        }

        finish();
    }

    @Override
    public Association getAssociation(final FullQualifiedName edmFQName) throws ODataException {

        Schema schema = this.namespace2Schema.get(edmFQName.getNamespace());
        if (schema != null) {
            List<Association> associations = schema.getAssociations();
            for (Association association : associations) {
                if (association.getName().equals(edmFQName.getName())) {
                    return association;
                }
            }
        }
        return null;
    }

    @Override
    public AssociationSet getAssociationSet(final String entityContainer, final FullQualifiedName association,
            final String sourceEntitySetName, final String sourceEntitySetRole) throws ODataException {

        EntityContainer container = this.name2Container.get(entityContainer);
        if (container != null) {
            List<AssociationSet> associations = container.getAssociationSets();
            for (AssociationSet associationSet : associations) {
                if (associationSet.getAssociation().equals(association)) {
                    final AssociationSetEnd endOne = associationSet.getEnd1();
                    if (endOne.getRole().equals(sourceEntitySetRole) && endOne.getEntitySet()
                            .equals(sourceEntitySetName)) {
                        return associationSet;
                    }
                    final AssociationSetEnd endTwo = associationSet.getEnd2();
                    if (endTwo.getRole().equals(sourceEntitySetRole) && endTwo.getEntitySet()
                            .equals(sourceEntitySetName)) {
                        return associationSet;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public ComplexType getComplexType(final FullQualifiedName edmFQName) throws ODataException {

        Schema schema = this.namespace2Schema.get(edmFQName.getNamespace());
        if (schema != null) {
            List<ComplexType> complexTypes = schema.getComplexTypes();
            for (ComplexType complexType : complexTypes) {
                if (complexType.getName().equals(edmFQName.getName())) {
                    return complexType;
                }
            }
        }
        return null;
    }

    @Override
    public EntityContainerInfo getEntityContainerInfo(final String name) throws ODataException {

        EntityContainer container = this.name2Container.get(name);
        if (container == null) {
            // use default container (if set)
            container = this.defaultContainer;
        }
        if (container != null) {
            EntityContainerInfo info = new EntityContainerInfo();
            info.setName(container.getName());
            info.setDefaultEntityContainer(container.isDefaultEntityContainer());
            info.setExtendz(container.getExtendz());
            info.setAnnotationAttributes(container.getAnnotationAttributes());
            info.setAnnotationElements(container.getAnnotationElements());

            return info;
        }

        return null;
    }

    @Override
    public EntitySet getEntitySet(final String entityContainer, final String name) throws ODataException {

        EntityContainer container = this.name2Container.get(entityContainer);
        if (container != null) {
            List<EntitySet> entitySets = container.getEntitySets();
            for (EntitySet entitySet : entitySets) {
                if (entitySet.getName().equals(name)) {
                    return entitySet;
                }
            }
        }

        return null;
    }

    @Override
    public EntityType getEntityType(final FullQualifiedName edmFQName) throws ODataException {

        Schema schema = this.namespace2Schema.get(edmFQName.getNamespace());
        if (schema != null) {
            List<EntityType> complexTypes = schema.getEntityTypes();
            for (EntityType complexType : complexTypes) {
                if (complexType.getName().equals(edmFQName.getName())) {
                    return complexType;
                }
            }
        }
        return null;
    }

    @Override
    public FunctionImport getFunctionImport(final String entityContainer, final String name) throws ODataException {

        EntityContainer container = this.name2Container.get(entityContainer);
        if (container != null) {
            List<FunctionImport> functionImports = container.getFunctionImports();
            for (FunctionImport functionImport : functionImports) {
                if (functionImport.getName().equals(name)) {
                    return functionImport;
                }
            }
        }
        return null;
    }

    @Override
    public List<Schema> getSchemas() throws ODataException {

        return new ArrayList<>(this.namespace2Schema.values());
    }

    //
    //
    //
    private Map<String, SchemaBuilder> namespace2SchemaBuilder = new HashMap<>();

    private void updateSchema(final Class<?> aClass) {

        EdmEntityType et = aClass.getAnnotation(EdmEntityType.class);
        if (et != null) {
            updateSchema(aClass, et);
        }
        EdmComplexType ect = aClass.getAnnotation(EdmComplexType.class);
        if (ect != null) {
            updateSchema(aClass, ect);
        }
    }

    private void updateSchema(final Class<?> aClass, final EdmEntityType et) {

        SchemaBuilder b = getSchemaBuilder(et.namespace(), aClass);
        TypeBuilder typeBuilder = TypeBuilder.init(et, aClass);
        b.addEntityType(typeBuilder.buildEntityType());
        b.addAssociations(typeBuilder.buildAssociations());
    }

    private SchemaBuilder getSchemaBuilder(final String namespace, final Class<?> aClass) {

        String usedNamespace = namespace;
        if (usedNamespace.isEmpty()) {
            usedNamespace = ANNOTATION_HELPER.getCanonicalNamespace(aClass);
        }
        SchemaBuilder builder = this.namespace2SchemaBuilder.get(usedNamespace);
        if (builder == null) {
            builder = SchemaBuilder.init(usedNamespace);
            this.namespace2SchemaBuilder.put(usedNamespace, builder);
        }
        return builder;
    }

    private void updateSchema(final Class<?> aClass, final EdmComplexType et) {

        SchemaBuilder b = getSchemaBuilder(et.namespace(), aClass);
        TypeBuilder typeBuilder = TypeBuilder.init(et, aClass);
        b.addComplexType(typeBuilder.buildComplexType());
    }

    private void handleEntityContainer(final Class<?> aClass) {

        EdmEntityType entityType = aClass.getAnnotation(EdmEntityType.class);
        if (entityType != null) {
            FullQualifiedName typeName = createFqnForEntityType(aClass);
            String containerName = ANNOTATION_HELPER.extractContainerName(aClass);
            ContainerBuilder builder = this.containerName2ContainerBuilder.get(containerName);
            if (builder == null) {
                builder = ContainerBuilder.init(typeName.getNamespace(), containerName);
                this.containerName2ContainerBuilder.put(containerName, builder);
            }
            EdmEntitySet entitySet = aClass.getAnnotation(EdmEntitySet.class);
            if (entitySet != null) {
                builder.addEntitySet(createEntitySet(typeName, aClass));
            }
        }

        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            EdmFunctionImport functionImport = method.getAnnotation(EdmFunctionImport.class);
            if (functionImport != null) {
                String containerName = ANNOTATION_HELPER.extractContainerName(aClass);
                ContainerBuilder builder = this.containerName2ContainerBuilder.get(containerName);
                if (builder == null) {
                    String namespace = ANNOTATION_HELPER.generateNamespace(aClass);
                    builder = ContainerBuilder.init(namespace, containerName);
                    this.containerName2ContainerBuilder.put(containerName, builder);
                }
                builder.addFunctionImport(createFunctionImport(method));
            }
        }
    }

    private FunctionImport createFunctionImport(final Method method) {

        String entitySetName = ANNOTATION_HELPER.extractEntitySetName(method);
        String httpMethod = ANNOTATION_HELPER.extractHttpMethod(method);
        String functionImportName = ANNOTATION_HELPER.extractFunctionImportName(method);
        ArrayList<FunctionImportParameter> functionImportParameters =
                ANNOTATION_HELPER.extractFunctionImportParameters(method);
        ReturnType returnType = ANNOTATION_HELPER.extractReturnType(method);

        FunctionImport fi = new FunctionImport();
        // Data which is not available though it should be?
        // fi.setAnnotationAttributes(annotationAttributes);
        // fi.setAnnotationElements(annotationElements);
        // fi.setDocumentation(documentation);
        if (entitySetName != null && !entitySetName.isEmpty()) {
            fi.setEntitySet(entitySetName);
        }
        if (httpMethod != null && !httpMethod.isEmpty()) {
            fi.setHttpMethod(httpMethod);
        }
        // Data which is not available though it should be?
        // fi.setMapping(mapping);
        fi.setName(functionImportName);
        if (functionImportParameters != null && !functionImportParameters.isEmpty()) {
            fi.setParameters(functionImportParameters);
        }
        if (returnType != null) {
            fi.setReturnType(returnType);
        }

        return fi;
    }

    private EntitySet createEntitySet(final FullQualifiedName typeName, final Class<?> entitySetClass) {

        String entitySetName = ANNOTATION_HELPER.extractEntitySetName(entitySetClass);
        return new EntitySet().setName(entitySetName).setEntityType(typeName);
    }

    private FullQualifiedName createFqnForEntityType(final Class<?> annotatedClass) {

        return ANNOTATION_HELPER.extractEntityTypeFqn(annotatedClass);
    }

    private void finish() throws ODataException {

        //
        Collection<ContainerBuilder> containers = this.containerName2ContainerBuilder.values();
        for (ContainerBuilder containerBuilder : containers) {
            SchemaBuilder schemaBuilder = this.namespace2SchemaBuilder.get(containerBuilder.getNamespace());
            containerBuilder.addAssociationSets(schemaBuilder.name2Associations.values());
            final EntityContainer container = containerBuilder.build();
            schemaBuilder.addEntityContainer(container);
            this.name2Container.put(container.getName(), container);
            if (container.isDefaultEntityContainer()) {
                this.defaultContainer = container;
            }
        }
        //
        Collection<SchemaBuilder> schemaBuilders = this.namespace2SchemaBuilder.values();
        for (SchemaBuilder schemaBuilder : schemaBuilders) {
            final Schema schema = schemaBuilder.build();
            this.namespace2Schema.put(schema.getNamespace(), schema);
        }
    }

    //
    //
    //
    static class TypeBuilder {

        @EdmProperty
        final private String namespace;

        final private String name;

        private boolean isAbstract = false;

        private boolean isMediaResource = false;

        private FullQualifiedName baseEntityType = null;

        private final List<PropertyRef> keyProperties = new ArrayList<>();

        private final List<Property> properties = new ArrayList<>();

        private final List<NavigationProperty> navProperties = new ArrayList<>();

        private final List<Association> associations = new ArrayList<>();

        public TypeBuilder(final FullQualifiedName fqn) {

            this.namespace = fqn.getNamespace();
            this.name = fqn.getName();
        }

        public static TypeBuilder init(final EdmEntityType entity, final Class<?> aClass) {

            return new TypeBuilder(ANNOTATION_HELPER.extractEntityTypeFqn(entity, aClass)).withClass(aClass);
        }

        public static TypeBuilder init(final EdmComplexType entity, final Class<?> aClass) {

            return new TypeBuilder(ANNOTATION_HELPER.extractComplexTypeFqn(entity, aClass)).withClass(aClass);
        }

        private TypeBuilder withClass(final Class<?> aClass) {

            this.baseEntityType = createBaseEntityFqn(aClass);

            if (Modifier.isAbstract(aClass.getModifiers())) {
                this.isAbstract = true;
            }

            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                EdmNavigationProperty enp = field.getAnnotation(EdmNavigationProperty.class);
                if (enp != null) {
                    Class<?> fromClass = field.getDeclaringClass();
                    Class<?> toClass = ClassHelper.getFieldType(field);
                    AnnotationHelper.AnnotatedNavInfo info =
                            ANNOTATION_HELPER.getCommonNavigationInfo(fromClass, toClass);

                    final NavigationProperty navProperty = createNavigationProperty(this.namespace, field, info);
                    this.navProperties.add(navProperty);
                    Association association = createAssociation(info);
                    this.associations.add(association);
                    // continue after a navigation property is found
                    continue;
                }

                EdmMediaResourceContent emrc = field.getAnnotation(EdmMediaResourceContent.class);
                if (emrc != null) {
                    this.isMediaResource = true;
                }
                EdmProperty ep = field.getAnnotation(EdmProperty.class);
                EdmKey eti = field.getAnnotation(EdmKey.class);
                int annotationsCount = field.getAnnotations().length;
                if (ep == null && eti == null && annotationsCount > 0) {
                    // skip because this field is annotated but not as property (or key)
                    continue;
                } else if (ep == null) {
                    ep = getDefaultEdmProperty();
                }
                this.properties.add(createProperty(ep, field, this.namespace));
                if (eti != null) {
                    this.keyProperties.add(createKeyProperty(ep, field));
                }
            }

            return this;
        }

        private EdmProperty getDefaultEdmProperty() {

            try {
                return TypeBuilder.class.getDeclaredField("namespace").getAnnotation(EdmProperty.class);
            } catch (NoSuchFieldException e) {
                // can be ignored because we known that this field is there
                throw new RuntimeException(e);
            }
        }

        public TypeBuilder addProperty(final PropertyRef property) {

            this.keyProperties.add(property);
            return this;
        }

        public TypeBuilder addProperty(final Property property) {

            this.properties.add(property);
            return this;
        }

        public TypeBuilder addNavigationProperty(final NavigationProperty property) {

            this.navProperties.add(property);
            return this;
        }

        public TypeBuilder setAbstract(final boolean isAbstract) {

            this.isAbstract = isAbstract;
            return this;
        }

        public ComplexType buildComplexType() {

            ComplexType complexType = new ComplexType();
            if (this.baseEntityType != null) {
                complexType.setBaseType(this.baseEntityType);
            }
            return complexType.setName(this.name).setProperties(this.properties);
        }

        public EntityType buildEntityType() {

            EntityType entityType = new EntityType();
            if (this.baseEntityType != null) {
                entityType.setBaseType(this.baseEntityType);
            }
            if (!this.keyProperties.isEmpty()) {
                entityType.setKey(new Key().setKeys(this.keyProperties));
            }
            if (!this.navProperties.isEmpty()) {
                entityType.setNavigationProperties(this.navProperties);
            }
            return entityType.setName(this.name).setAbstract(this.isAbstract).setHasStream(this.isMediaResource)
                    .setProperties(this.properties);
        }

        public Collection<Association> buildAssociations() {

            return Collections.unmodifiableCollection(this.associations);
        }

        private PropertyRef createKeyProperty(final EdmProperty et, final Field field) {

            PropertyRef keyProperty = new PropertyRef();
            String entityName = et.name();
            if (entityName.isEmpty()) {
                entityName = getCanonicalName(field);
            }
            return keyProperty.setName(entityName);
        }

        private Property createProperty(final EdmProperty ep, final Field field, final String defaultNamespace) {

            if (isAnnotatedEntity(field.getType())) {
                return createComplexProperty(field, defaultNamespace);
            } else {
                return createSimpleProperty(ep, field);
            }
        }

        private Property createSimpleProperty(final EdmProperty ep, final Field field) {

            SimpleProperty sp = new SimpleProperty();
            String entityName = ANNOTATION_HELPER.getPropertyName(field);
            sp.setName(entityName);
            //
            EdmType type = ep.type();
            if (type == EdmType.NULL) {
                type = ANNOTATION_HELPER.mapType(field.getType());
            }
            sp.setType(ANNOTATION_HELPER.mapTypeKind(type));
            sp.setFacets(createFacets(ep.facets(), field.getAnnotation(EdmConcurrencyControl.class)));
            return sp;
        }

        private Facets createFacets(final EdmFacets facets, final EdmConcurrencyControl concurrencyControl) {

            Facets resultFacets = new Facets().setNullable(facets.nullable());
            if (facets.maxLength() > -1) {
                resultFacets.setMaxLength(facets.maxLength());
            }
            if (facets.precision() > -1) {
                resultFacets.setPrecision(facets.precision());
            }
            if (facets.scale() > -1) {
                resultFacets.setScale(facets.scale());
            }
            if (concurrencyControl != null) {
                resultFacets.setConcurrencyMode(EdmConcurrencyMode.Fixed);
            }
            return resultFacets;
        }

        private Property createComplexProperty(final Field field, final String defaultNamespace) {

            ComplexProperty cp = new ComplexProperty();
            // settings from property
            String entityName = ANNOTATION_HELPER.getPropertyName(field);
            cp.setName(entityName);

            // settings from related complex entity
            EdmComplexType ece = field.getType().getAnnotation(EdmComplexType.class);
            String complexEntityNamespace = ece.namespace();
            if (complexEntityNamespace.isEmpty()) {
                complexEntityNamespace = defaultNamespace;
            }
            cp.setType(
                    new FullQualifiedName(complexEntityNamespace,
                            ANNOTATION_HELPER.extractComplexTypeName(field.getType())));
            return cp;
        }

        private NavigationProperty createNavigationProperty(final String namespace, Field field,
                AnnotationHelper.AnnotatedNavInfo navInfo) {

            NavigationProperty navProp = new NavigationProperty();
            navProp.setName(ANNOTATION_HELPER.getPropertyName(field));
            String fromRole = navInfo.getFromRoleName();
            navProp.setFromRole(fromRole);
            navProp.setToRole(navInfo.getToRoleName());

            String relationshipName = navInfo.getRelationshipName();
            navProp.setRelationship(new FullQualifiedName(namespace, relationshipName));

            return navProp;
        }

        // private EdmType getEdmType(final Class<?> type) {
        // if (type == String.class) {
        // return EdmType.STRING;
        // } else if (type == boolean.class || type == Boolean.class) {
        // return EdmType.BOOLEAN;
        // } else if (type == byte.class || type == Byte.class) {
        // return EdmType.SBYTE;
        // } else if (type == short.class || type == Short.class) {
        // return EdmType.INT16;
        // } else if (type == int.class || type == Integer.class) {
        // return EdmType.INT32;
        // } else if (type == long.class || type == Long.class) {
        // return EdmType.INT64;
        // } else if (type == double.class || type == Double.class) {
        // return EdmType.DOUBLE;
        // } else if (type == float.class || type == Float.class) {
        // return EdmType.SINGLE;
        // } else if (type == BigInteger.class || type == BigDecimal.class) {
        // return EdmType.DECIMAL;
        // } else if (type == Byte[].class || type == byte[].class) {
        // return EdmType.BINARY;
        // } else if (type == Date.class) {
        // return EdmType.DATE_TIME;
        // } else if (type == Calendar.class) {
        // return EdmType.DATE_TIME_OFFSET;
        // } else if (type == UUID.class) {
        // return EdmType.GUID;
        // } else {
        // throw new UnsupportedOperationException("Not yet supported type '" + type + "'.");
        // }
        // }

        private Class<?> checkForBaseEntityClass(final Class<?> aClass) {

            Class<?> superClass = aClass.getSuperclass();
            if (superClass == Object.class) {
                return null;
            } else {
                EdmEntityType edmEntity = superClass.getAnnotation(EdmEntityType.class);
                if (edmEntity == null) {
                    return checkForBaseEntityClass(superClass);
                } else {
                    return superClass;
                }
            }
        }

        private FullQualifiedName createBaseEntityFqn(final Class<?> aClass) {

            Class<?> baseEntityClass = checkForBaseEntityClass(aClass);
            if (baseEntityClass == null) {
                return null;
            }
            return ANNOTATION_HELPER.extractEntityTypeFqn(baseEntityClass);
        }

        private Association createAssociation(final AnnotationHelper.AnnotatedNavInfo info) {

            Association association = new Association();

            AssociationEnd fromEnd = new AssociationEnd();
            fromEnd.setRole(info.getFromRoleName());
            fromEnd.setType(new FullQualifiedName(this.namespace, info.getFromTypeName()));
            fromEnd.setMultiplicity(info.getFromMultiplicity());
            association.setEnd1(fromEnd);

            AssociationEnd toEnd = new AssociationEnd();
            toEnd.setRole(info.getToRoleName());
            toEnd.setType(new FullQualifiedName(this.namespace, info.getToTypeName()));
            toEnd.setMultiplicity(info.getToMultiplicity());
            association.setEnd2(toEnd);

            String associationName = info.getRelationshipName();
            association.setName(associationName);
            return association;
        }

        private String getCanonicalName(final Field field) {

            return ANNOTATION_HELPER.getCanonicalName(field);
        }

        private boolean isAnnotatedEntity(final Class<?> clazz) {

            return ANNOTATION_HELPER.isEdmTypeAnnotated(clazz);
        }
    }

    static class SchemaBuilder {

        final private String namespace;

        // private String alias;
        private final List<Using> usings = new ArrayList<>();

        private final List<EntityType> entityTypes = new ArrayList<>();

        private final List<ComplexType> complexTypes = new ArrayList<>();

        private final Map<String, Association> name2Associations = new HashMap<>();

        private final List<EntityContainer> entityContainers = new ArrayList<>();

        private final List<AnnotationAttribute> annotationAttributes = new ArrayList<>();

        private final List<AnnotationElement> annotationElements = new ArrayList<>();

        private SchemaBuilder(final String namespace) {

            this.namespace = namespace;
        }

        public static SchemaBuilder init(final String namespace) {

            return new SchemaBuilder(namespace);
        }

        public SchemaBuilder addEntityType(final EntityType type) {

            this.entityTypes.add(type);
            return this;
        }

        public SchemaBuilder addEntityContainer(final EntityContainer container) {

            this.entityContainers.add(container);
            return this;
        }

        public SchemaBuilder addComplexType(final ComplexType createEntityType) {

            this.complexTypes.add(createEntityType);
            return this;
        }

        public void addAssociations(final Collection<Association> associations) {

            for (Association association : associations) {
                final String relationshipName = association.getName();
                if (this.name2Associations.containsKey(relationshipName)) {
                    association = mergeAssociations(this.name2Associations.get(relationshipName), association);
                }
                this.name2Associations.put(relationshipName, association);
            }
        }

        private Association mergeAssociations(final Association associationOne, final Association associationTwo) {

            AssociationEnd oneEnd1 = associationOne.getEnd1();
            AssociationEnd oneEnd2 = associationOne.getEnd2();
            AssociationEnd twoEnd1 = associationTwo.getEnd1();
            AssociationEnd twoEnd2 = associationTwo.getEnd2();
            AssociationEnd[] oneEnds = new AssociationEnd[] {oneEnd1, oneEnd2};

            for (AssociationEnd associationEnd : oneEnds) {
                if (associationEnd.getRole().equals(twoEnd1.getRole())) {
                    if (twoEnd1.getMultiplicity() == EdmMultiplicity.MANY) {
                        associationEnd.setMultiplicity(EdmMultiplicity.MANY);
                    }
                } else if (associationEnd.getRole().equals(twoEnd2.getRole())) {
                    if (twoEnd2.getMultiplicity() == EdmMultiplicity.MANY) {
                        associationEnd.setMultiplicity(EdmMultiplicity.MANY);
                    }
                }
            }

            return associationOne;
        }

        public Schema build() {

            Schema s = new Schema();
            s.setUsings(this.usings);
            s.setEntityTypes(this.entityTypes);
            s.setComplexTypes(this.complexTypes);
            s.setAssociations(new ArrayList<>(this.name2Associations.values()));
            s.setEntityContainers(this.entityContainers);
            s.setAnnotationAttributes(this.annotationAttributes);
            s.setAnnotationElements(this.annotationElements);
            s.setNamespace(this.namespace);
            return s;
        }
    }

    private static class ContainerBuilder {

        final private String name;

        final private String namespace;

        private boolean defaultContainer = true;

        private final List<EntitySet> entitySets = new ArrayList<>();

        private final List<AssociationSet> associationSets = new ArrayList<>();

        private final List<FunctionImport> functionImports = new ArrayList<>();

        // private Documentation documentation;

        private ContainerBuilder(final String namespace, final String containerName) {

            this.namespace = namespace;
            this.name = containerName;
        }

        public String getNamespace() {

            return this.namespace;
        }

        public static ContainerBuilder init(final String namespace, final String containerName) {

            return new ContainerBuilder(namespace, containerName);
        }

        public ContainerBuilder addEntitySet(final EntitySet entitySet) {

            this.entitySets.add(entitySet);
            return this;
        }

        public ContainerBuilder addFunctionImport(final FunctionImport functionImport) {

            this.functionImports.add(functionImport);
            return this;
        }

        public void addAssociationSets(final Collection<Association> associations) throws ODataException {

            for (Association association : associations) {
                AssociationSet as = new AssociationSet();
                as.setName(association.getName());
                FullQualifiedName asAssociationFqn = new FullQualifiedName(this.namespace, association.getName());
                as.setAssociation(asAssociationFqn);

                AssociationSetEnd asEnd1 = new AssociationSetEnd();
                asEnd1.setEntitySet(getEntitySetName(association.getEnd1()));
                asEnd1.setRole(association.getEnd1().getRole());
                as.setEnd1(asEnd1);

                AssociationSetEnd asEnd2 = new AssociationSetEnd();
                asEnd2.setEntitySet(getEntitySetName(association.getEnd2()));
                asEnd2.setRole(association.getEnd2().getRole());
                as.setEnd2(asEnd2);

                this.associationSets.add(as);
            }
        }

        public EntityContainer build() {

            EntityContainer ec = new EntityContainer();
            ec.setName(this.name);
            ec.setDefaultEntityContainer(this.defaultContainer);
            ec.setEntitySets(this.entitySets);
            ec.setAssociationSets(this.associationSets);
            ec.setFunctionImports(this.functionImports);
            return ec;
        }

        private String getEntitySetName(final AssociationEnd end) throws ODataException {

            for (EntitySet entitySet : this.entitySets) {
                if (entitySet.getEntityType().equals(end.getType())) {
                    return entitySet.getName();
                }
            }
            throw new ODataException("No entity set found for " + end.getType());
        }
    }
}
