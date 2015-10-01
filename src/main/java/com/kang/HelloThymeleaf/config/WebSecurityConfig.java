package com.kang.HelloThymeleaf.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
/*       http
        .authorizeRequests()
        .antMatchers("/", "/home").permitAll()
        .anyRequest().authenticated()
        .and()
    .formLogin()
        .loginPage("/login.html")
        .permitAll()
        .and()
    .logout()
        .permitAll();
	*/
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth)
        throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("user").password("password");
    }
}