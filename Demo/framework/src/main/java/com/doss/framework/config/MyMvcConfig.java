package com.doss.framework.config;

import com.doss.framework.component.LoginHandlerInterceptor;
import com.doss.framework.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        registry.addViewController("/doss").setViewName("success");
    }

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源
                //登陆拦截器
                //todo: 测试需要，暂时关闭
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/login", "/index.html", "/user/login", "/asserts/**", "/webjars/**");
//                super.addInterceptors(registry);
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                super.addViewControllers(registry);
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
//                registry.addViewController("/main.html").setViewName("success");

            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
