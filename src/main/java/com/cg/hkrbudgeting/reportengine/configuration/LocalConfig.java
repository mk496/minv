package com.cg.hkrbudgeting.reportengine.configuration;

import com.cg.hkrbudgeting.reportengine.common.impl.QueryConstantHelperH2Impl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


@Configuration
@Conditional(ProfilesHanaExcludeCondition.class)
public class LocalConfig {

    @Bean
    public QueryConstantHelperH2Impl createQueryConstantHelper() {

        return new QueryConstantHelperH2Impl();
    }
}
