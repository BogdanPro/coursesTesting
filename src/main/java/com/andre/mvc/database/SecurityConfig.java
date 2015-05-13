package com.andre.mvc.database;

import com.andre.mvc.service.CustomUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import javax.annotation.Resource;

/**
 * Created by 1 on 12.05.2015.
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private CustomUserDetailsService customUserDetailsService;

    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder);
    }
}
