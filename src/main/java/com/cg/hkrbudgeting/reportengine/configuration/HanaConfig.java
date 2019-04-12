package com.cg.hkrbudgeting.reportengine.configuration;

import com.cg.hkrbudgeting.reportengine.common.constant.Profiles;
import com.cg.hkrbudgeting.reportengine.common.impl.QueryConstantHelperHanaImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({Profiles.HANA,Profiles.HANA_lOCAL})
public class HanaConfig {

    @Bean
    public QueryConstantHelperHanaImpl createQueryConstantHelper() {

        return new QueryConstantHelperHanaImpl();
    }
}
