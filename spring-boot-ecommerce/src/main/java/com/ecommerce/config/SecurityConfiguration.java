package com.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // protect endpoint api/orders
        http.authorizeRequests(configurer ->
                configurer.antMatchers("/api/orders/**")
                        .authenticated())
                .oauth2ResourceServer()
                .jwt();
        http.cors();
        return http.build();
    }
}
