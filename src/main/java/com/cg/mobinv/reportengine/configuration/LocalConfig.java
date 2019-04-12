package com.cg.mobinv.reportengine.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.cg.mobinv.reportengine.common.impl.QueryConstantHelperH2Impl;


@Configuration
@Conditional(ProfilesHanaExcludeCondition.class)
public class LocalConfig {

    @Bean
    public QueryConstantHelperH2Impl createQueryConstantHelper() {

        return new QueryConstantHelperH2Impl();
    }
}
