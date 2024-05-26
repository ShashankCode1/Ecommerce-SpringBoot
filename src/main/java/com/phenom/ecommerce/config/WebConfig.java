package com.phenom.ecommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Value("${images.path}")
    private String imageDirectoryPath;

    // ResourceHandler localhost:8080/images/** to serve images from directory location
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:" + imageDirectoryPath);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")      // apply to all end points
                .allowedOrigins("*")               // allow request from any origins
                .allowedMethods("*")               // allow HTTP methods (GET, POST, PUT, DELETE,...)
                .allowedHeaders("*");              // allow all headers
    }
}
