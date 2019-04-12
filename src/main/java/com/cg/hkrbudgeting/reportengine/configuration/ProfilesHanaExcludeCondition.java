package com.cg.hkrbudgeting.reportengine.configuration;

import com.cg.hkrbudgeting.reportengine.common.constant.Profiles;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;





public class ProfilesHanaExcludeCondition implements Condition {


    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        return !environment.acceptsProfiles(Profiles.HANA,Profiles.HANA_lOCAL);
    }
}
