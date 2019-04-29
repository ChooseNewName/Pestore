package com.nf147.ssm_pet_spring.SpringJavaStyle;

import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@Configuration  //这个注解的意思是：让 Spring 容器在初始化的时候可以知道这个类。
//@EnableWebMvc   // <!--启用 mvc 的常用注解-->，相当于配置文件的<mvc:annotation-driven />
//@ComponentScan("com.nf147.ssm_pet_spring.controller")
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = "com.nf147.ssm_pet_spring")
//这个注解的意思就是：<!--扫描包下面所有的 @Controller 注解的类，并将其实例化，放入容器-->
//相当于XML<contxt:component-scan base-package="com.nf147.ssm_pet_spring.controller" />
public class SpringWebXML extends WebMvcConfigurationSupport {

    //    配置视图view解析器
    @Bean
    public ViewResolver getView() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewNames("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

//    配置上传下载,用于处理文件上传，MultipartResolver 用于处理文件上传，
//    当收到请求时 DispatcherServlet 的 checkMultipart() 方法会调用 MultipartResolver 的 isMultipart() 方法判断请求中是否包含文件。
//    如果请求数据中包含文件，则调用 MultipartResolver 的 resolveMultipart() 方法对请求的数据进行解析，然后将文件数据解析成 MultipartFile 并封装在 MultipartHttpServletRequest (继承了 HttpServletRequest) 对象中，最后传递给 Controlle
    @Bean
    public MultipartResolver getMultipartResolver() {
        StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
        return multipartResolver;
    }

    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
        super.configureDefaultServletHandling(configurer);
    }
}
