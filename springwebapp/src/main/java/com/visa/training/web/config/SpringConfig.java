package com.visa.training.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = "com.visa.training")
@Configuration
@Import(PersistenceJPAConfiguration.class) //<-- import another configuration class in configuration class
public class SpringConfig extends WebMvcConfigurerAdapter {
 
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver(); //translates to valid view name
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/"); //  prefix for mapping views
        viewResolver.setSuffix(".jsp"); // helloview.jsp
        return viewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
   

    }
}
