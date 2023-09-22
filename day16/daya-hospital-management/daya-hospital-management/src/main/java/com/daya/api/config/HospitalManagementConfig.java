package com.daya.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class HospitalManagementConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/doctor/doctorappointment").hasAnyRole("DOCTOR")
                .antMatchers(HttpMethod.PUT, "/patient/myappointment").hasAnyRole("PATIENT")
                .antMatchers(HttpMethod.GET, "/doctor/save").hasAnyRole("DOCTOR")
                .antMatchers(HttpMethod.GET, "/patient/save").hasAnyRole("PATIENT")
                .antMatchers(HttpMethod.DELETE, "/viewprescrption").hasAnyRole("DOCTOR","PATIENT")
                .antMatchers(HttpMethod.DELETE, "/saveprescrption").hasAnyRole("DOCTOR","PATIENT").and().csrf().disable().headers()
                .frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("doctor01").password("{noop}password").roles("DOCTOR")
                .and().withUser("patient1").password("{noop}password").roles("PATIENT");
    }
}
