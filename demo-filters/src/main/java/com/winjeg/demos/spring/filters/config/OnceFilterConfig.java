package com.winjeg.demos.spring.filters.config;

import com.google.common.collect.Lists;
import com.winjeg.demos.spring.filters.filter.OnceFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author winjeg
 */
@Configuration
public class OnceFilterConfig {

    @Bean("once_filter_bean")
    public FilterRegistrationBean onceFilter(@Autowired  OnceFilter filter) {
        FilterRegistrationBean<Filter> filterRegister = new FilterRegistrationBean<>();
        // 注册filter
        filterRegister.setFilter(filter);
        // 设置拦截的uri
        filterRegister.setUrlPatterns(Lists.newArrayList("/*"));
        // 设置filter顺序
        filterRegister.setOrder(1);
        return filterRegister;
    }
}
