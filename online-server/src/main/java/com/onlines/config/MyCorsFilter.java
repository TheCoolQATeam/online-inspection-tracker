package com.onlines.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class MyCorsFilter {
    @Bean
    public CorsFilter corsFilter() {
        // 1.创建 CORS 配置对象
        CorsConfiguration config = new CorsConfiguration();
        // 支持域
        config.addAllowedOriginPattern("*");
        // 是否发送 Cookie
        config.setAllowCredentials(true);
        // 支持请求方式
        config.addAllowedMethod("*");
        // 允许的原始请求头部信息
        config.addAllowedHeader("*");
        // 暴露的头部信息
        config.addExposedHeader("*");
        // 2.添加地址映射
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", config);
        // 3.返回 CorsFilter 对象
        return new CorsFilter(corsConfigurationSource);
    }
}


