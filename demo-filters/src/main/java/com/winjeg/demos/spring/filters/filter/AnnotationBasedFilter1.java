package com.winjeg.demos.spring.filters.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 需要启动类上启用： @ServletComponentScan 和 @Component
 * 对于 @Order注解 是为了标注过滤器执行的顺序
 *
 * @author winjeg
 */
@Slf4j
@Order(2)
@Component
@WebFilter(filterName = "annoFilter1", urlPatterns = "/*")
public class AnnotationBasedFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("...Filter.............AnnotationBasedFilter1 初始化成功!...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        log.info("...Filter.........AnnotationBasedFilter1... 执行doFilter过滤逻辑");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("...Filter.............AnnotationBasedFilter1 销毁成功...");
    }
}
