package com.example.curshibernate2xml.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SecurityConfiguration {
    @Autowired
    private AuthExceptionHandler authExceptionHandler;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public AccessDeniedHandlerImpl accessDeniedHandler() {
        return new AccessDeniedHandlerImpl();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests().antMatchers(HttpMethod.POST, "/api/teacher/**").hasAnyAuthority("ADMIN")
                .and()
                .authorizeHttpRequests().antMatchers(HttpMethod.GET, "/api/teacher/**").hasAnyAuthority("ADMIN", "USER")
                .and()
                .authorizeHttpRequests().antMatchers(HttpMethod.POST, "/api/courses/add/**").hasAnyAuthority("ADMIN", "STAFF")
                .and()
                .authorizeHttpRequests().antMatchers("/api/courses/**").hasAnyAuthority("ADMIN", "USER")
                .and()
                .authorizeHttpRequests().antMatchers("/user/**").permitAll()
                .and()
                .authorizeHttpRequests().antMatchers("/api/students/join").hasAnyAuthority("USER")
                .and()
                .authorizeHttpRequests().antMatchers("/api/students/courses/**").hasAnyAuthority("USER")
                .anyRequest().authenticated()
                .and().exceptionHandling().authenticationEntryPoint(authExceptionHandler).accessDeniedHandler(accessDeniedHandler);

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}