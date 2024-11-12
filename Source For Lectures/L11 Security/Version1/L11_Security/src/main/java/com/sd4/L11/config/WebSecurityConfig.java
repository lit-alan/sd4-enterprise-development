package com.sd4.L11.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
           .csrf(AbstractHttpConfigurer::disable) // Disable CSRF protection for simplicity, consider enabling in production
           .authorizeHttpRequests(authorize -> authorize
           .requestMatchers("/").permitAll() //permit everyone to access /
           .requestMatchers(HttpMethod.GET, "/reports/**")
           .hasRole("MANAGER")
           .requestMatchers(HttpMethod.POST, "/documents/**")
           .hasAnyRole("MANAGER")
           .requestMatchers(HttpMethod.GET, "/documents/**")
           .hasAnyRole("MANAGER", "USER")
           .requestMatchers(HttpMethod.GET, "/content/**")
           .hasAnyRole("MANAGER", "USER", "EMPLOYEE")
           .anyRequest()
           .authenticated())
           .formLogin(formLogin ->
                   formLogin
                           .defaultSuccessUrl("/content")
                           .permitAll()
           );
         return http.build();
    }
// .requestMatchers(request -> request.getMethod().equals("GET") && request.getServletPath().contains("t"))
// .hasAnyRole("EMPLOYEE")

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user =  User.withUsername("dave")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();
        UserDetails manager =  User.withUsername("emma")
                .password(passwordEncoder.encode("password"))
                .roles("MANAGER")
                .build();
        UserDetails employee =  User.withUsername("grace")
                .password(passwordEncoder.encode("password"))
                .roles("EMPLOYEE")
                .build();
        UserDetails nobody =  User.withUsername("tom")
                .password(passwordEncoder.encode("password"))
                .roles("NOBODY")
                .build();
        return new InMemoryUserDetailsManager(user, manager, employee, nobody);
    }

   @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}


//////////////////////////////////
//Simple Config from early example in notes
//@Bean
//public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http.csrf().disable()
//            .authorizeHttpRequests()
//            .requestMatchers("/").permitAll()
//            .requestMatchers(HttpMethod.GET, "/reports/**")
//            .hasRole("MANAGER")
//            .requestMatchers(HttpMethod.GET, "/documents/**")
//            .hasAnyRole("USER")
//            .anyRequest()
//            .authenticated()
//            .and()
//            .formLogin()
//            .defaultSuccessUrl("/content");
//    return http.build();
//}
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails user =  User.withUsername("dave")
//                .password(passwordEncoder.encode("password"))
//                .roles("USER")
//                .build();
//        UserDetails manager =  User.withUsername("emma")
//                .password(passwordEncoder.encode("password"))
//                .roles("MANAGER","USER")
//                .build();
//        return new InMemoryUserDetailsManager(user, manager);
//    }
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//}


