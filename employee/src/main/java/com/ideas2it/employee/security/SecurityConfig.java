/**
 * <p>
 * This is the package for security class
 * Copyright 2022 - Ideas2it.
 * </p>
 */
package com.ideas2it.employee.security;

import com.ideas2it.employee.filter.CustomAuthenticationFilter;
import com.ideas2it.employee.filter.CustomAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Autowired
    AuthenticationManager authenticationManager;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     *
     * @param http - Communication between client computers and web servers is done
     *                by sending HTTP Requests and receiving HTTP Responses
     * @return - http
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers("/login/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/trainer").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/trainee").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/addUser").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/saveRole").permitAll();
        http.authorizeRequests().antMatchers(GET,"/trainer/**").hasAuthority("admin");
        //http.authorizeRequests().antMatchers(HttpMethod.GET,"/trainer/**").hasAnyAuthority("admin","manager");
        http.authorizeRequests().antMatchers(GET,"/trainee/**").hasAnyAuthority("admin","manager");
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/trainer/**").hasAnyAuthority("admin");
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/trainee/**").hasAnyAuthority("admin");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/trainer/**").hasAnyAuthority("admin");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/trainer/**").hasAnyAuthority("admin");
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/associate").hasAnyAuthority("manager");
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/addRole").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/assignUser/**").hasAnyAuthority("admin");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new CustomAuthenticationFilter(authenticationManager));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
