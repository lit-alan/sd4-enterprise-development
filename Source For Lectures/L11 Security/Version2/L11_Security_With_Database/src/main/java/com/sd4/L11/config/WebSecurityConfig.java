package com.sd4.L11.config;

import com.sd4.L11.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private CustomerService customerService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                //Disable CSRF protection for simplicity, consider enabling in production
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        //My publicly accessible endpoints
                        .requestMatchers("/").permitAll()
                        //Role-based access control for specific endpoints
                        .requestMatchers(HttpMethod.GET, "/reports/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/documents/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/documents/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/content/**").hasAnyRole("CUSTOMER", "ADMIN")
                        //All other requests require authentication
                        .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin
                        .defaultSuccessUrl("/content")
                        .permitAll()
                );
        //Return the configured HttpSecurity object
        return http.build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(customerService)
                .passwordEncoder(encoder())
                .and()
                .build();
    }
}
