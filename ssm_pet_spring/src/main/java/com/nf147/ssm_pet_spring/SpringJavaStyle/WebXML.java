package com.nf147.ssm_pet_spring.SpringJavaStyle;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebXML extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

//  把所有请求都转 Spring 中
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
