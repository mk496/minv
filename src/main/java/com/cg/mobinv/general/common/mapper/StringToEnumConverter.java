package com.cg.mobinv.general.common.mapper;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

import com.cg.mobinv.mobileinventory.dataaccess.api.enums.BusinessEnum;

import java.util.EnumSet;

public class StringToEnumConverter implements CustomConverter {

    /**
     * The constructor.
     */
    public StringToEnumConverter() {

        super();
    }

    @SuppressWarnings("boxing")
    @Override
    public Object convert(Object destination, Object source, @SuppressWarnings("rawtypes") Class destClass,
            @SuppressWarnings("rawtypes") Class sourceClass) {

        if (source == null) {
            return null;
        }

        if (source instanceof String) {
            BusinessEnum dest = null;

            if (destClass.isEnum()) {
                EnumSet enumByType = EnumSet.allOf(destClass);

                if (enumByType != null) {
                    Integer potentialId = parseStringToInt((String) source);
                    BusinessEnum businessEnum = (BusinessEnum) enumByType.iterator().next();
                    if (potentialId != null) {
                        dest = businessEnum.findById(potentialId);
                    } else {
                        dest = businessEnum.findByName((String) source);
                    }
                }
            }
            return dest;
        } else if (source instanceof BusinessEnum) {
            BusinessEnum businessEnum = (BusinessEnum) source;
            String dest = businessEnum.toString();
            return dest;
        } else if (source instanceof Integer) {
            return source;
        } else {
            throw new MappingException(
                    "Converter used incorrectly. Arguments passed in were:" + destination + " and " + source);
        }
    }

    private Integer parseStringToInt(String source) {

        try {
            return Integer.parseInt(source);
        } catch (NumberFormatException e) {
            //do nothing, we want only check if its number
        }
        return null;
    }

}
