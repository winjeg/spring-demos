package com.winjeg.demos.spring.filters.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 对于每个请求只过滤一次的filter， 同样需要启动类上启用： @ServletComponentScan
 * 另外，还需要自己手动注册filter,
 *
 * @author winjeg
 * @see com.winjeg.demos.spring.filters.config.OnceFilterConfig
 */
@Slf4j
@WebFilter
@Component
public class OnceFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        log.info("...Filter.........OnceFilter... 执行doFilter过滤逻辑");
        // 此处可以用request 和 response 做许多有意义的事情
        // 1. 根据 request 里的 url路径， 参数， header 来做过滤逻辑
        // 2. 打印所有请求的日志
        // 3. 做通用的权限校验
        if (request.getRequestURI().startsWith("/ping")) {
            response.getWriter().append("Hello...");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
