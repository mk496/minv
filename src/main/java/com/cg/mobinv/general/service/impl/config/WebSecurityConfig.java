package com.cg.mobinv.general.service.impl.config;

import io.oasp.module.basic.common.api.config.SpringProfileConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
<<<<<<< master
 * Security configuration based on {@link WebSecurityConfigurerAdapter}. This configuration is by purpose designed most
 * simple for two channels of authentication: simple login form and rest-url. (Copied from
 * {@link AbstractWebSecurityConfig}
=======
 * Security configuration based on {@link WebSecurityConfigurerAdapter}. This configuration is by
 * purpose designed most simple for two channels of authentication: simple login form and rest-url.
 * (Copied from {@link AbstractWebSecurityConfig}
 *
>>>>>>> HEAD~0
 */
@Configuration
@EnableWebSecurity
@Profile(SpringProfileConstants.NOT_JUNIT)
public class WebSecurityConfig extends AbstractWebSecurityConfig {

}
