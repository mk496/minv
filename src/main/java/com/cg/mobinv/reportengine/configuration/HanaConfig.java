package com.cg.mobinv.reportengine.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cg.mobinv.reportengine.common.constant.Profiles;
import com.cg.mobinv.reportengine.common.impl.QueryConstantHelperHanaImpl;

@Configuration
@Profile({Profiles.HANA,Profiles.HANA_lOCAL})
public class HanaConfig {

    @Bean
    public QueryConstantHelperHanaImpl createQueryConstantHelper() {

        return new QueryConstantHelperHanaImpl();
    }
}
