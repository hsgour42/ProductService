package com.example.productservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/products").hasAuthority("admin")
//                        .anyRequest().authenticated()
//                                .requestMatchers("/products").permitAll()
//                                .requestMatchers("/products/*").permitAll()
//                                .requestMatchers("/search").permitAll()
//                                .requestMatchers("/search/*").permitAll()
                                .anyRequest().permitAll()
                        //.anyRequest().authenticated()


                )

                .cors().disable()
                .csrf().disable()
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

}