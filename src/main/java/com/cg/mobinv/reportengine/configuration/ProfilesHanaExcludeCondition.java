package com.cg.mobinv.reportengine.configuration;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.cg.mobinv.reportengine.common.constant.Profiles;





public class ProfilesHanaExcludeCondition implements Condition {


    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        return !environment.acceptsProfiles(Profiles.HANA,Profiles.HANA_lOCAL);
    }
}
