package com.cg.hkrbudgeting.general.service.impl.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

@Configuration
public class ODataConfiguration {

    public static final String SERVICE_URL = "/services/odata.svc/*";

    @Inject
    private ODataCutomServlet servletInitOdata;

    @Bean
    ServletRegistrationBean ODataServlet() {

        return new ServletRegistrationBean(servletInitOdata,SERVICE_URL);
   }
}