package com.andre.mvc.database;

import com.andre.mvc.manager.CustomUserDetailsService;
import com.andre.mvc.manager.SaltSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
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
//        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder);
        ReflectionSaltSource rss = new SaltSource();
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setSaltSource(rss);
        provider.setUserDetailsService(customUserDetailsService);
        provider.setPasswordEncoder(new Md5PasswordEncoder());
        auth.authenticationProvider(provider);
    }
}
