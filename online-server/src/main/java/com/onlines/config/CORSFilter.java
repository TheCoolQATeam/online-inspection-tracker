package com.onlines.config;

import com.onlines.controller.OnlinesSaleController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "corsFilter")
public class CORSFilter implements Filter{
    private static final Logger logger= LoggerFactory.getLogger(OnlinesSaleController.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("初始化filter==========================");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*"); //  这里最好明确的写允许的域名
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token,Authorization,ybg");
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("filter==========================");
    }
    @Override
    public void destroy() {
        logger.info("销毁filter==========================");
    }

}
