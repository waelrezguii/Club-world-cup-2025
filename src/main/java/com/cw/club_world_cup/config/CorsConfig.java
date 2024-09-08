package com.cw.club_world_cup.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Adjust the mapping as per your API endpoints
                .allowedOrigins("https://club-world-cup-2025.vercel.app") // Allow requests from Angular application
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specific HTTP methods
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
