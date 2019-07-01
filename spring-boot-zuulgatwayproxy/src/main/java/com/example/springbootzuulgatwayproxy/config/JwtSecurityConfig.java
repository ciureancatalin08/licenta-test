package com.example.springbootzuulgatwayproxy.config;

//import com.example.springbootzuulgatwayproxy.SimpleCorsFilter;
import com.example.springbootzuulgatwayproxy.security.JwtAuthenticationEntryPoint;
import com.example.springbootzuulgatwayproxy.security.JwtAuthenticationProvider;
import com.example.springbootzuulgatwayproxy.security.JwtAuthenticationTokenFilter;
//import com.example.springbootzuulgatwayproxy.security.JwtSuccessHandler;
import com.example.springbootzuulgatwayproxy.security.JwtSuccessHandler;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;

import java.util.Collections;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private JwtAuthenticationProvider authenticationProvider;
    @Autowired
    private JwtAuthenticationEntryPoint entryPoint;

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Collections.singletonList(authenticationProvider));
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilter() {
        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }



//    @Bean
//    SimpleCorsFilter corsFilter() {
//        SimpleCorsFilter filter = new SimpleCorsFilter();
//        return filter;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
//                .addFilterBefore(corsFilter(), SessionManagementFilter.class)
                .cors()
                .and()
                .authorizeRequests().antMatchers("/rest/*").authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();

    }
}
