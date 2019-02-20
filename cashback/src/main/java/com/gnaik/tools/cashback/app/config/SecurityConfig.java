package com.gnaik.tools.cashback.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private AppUserDetailsService appAserDetailsService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        super.configure(httpSecurity);
        httpSecurity
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "img/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/account/login").permitAll()
                .usernameParameter("app_username").passwordParameter("app_password")
                .loginProcessingUrl("/app-login")
                .defaultSuccessUrl("/home")
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutUrl("/app-logout")
                .logoutSuccessUrl("/login")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/loginError");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        auth.userDetailsService(appAserDetailsService).passwordEncoder(passwordEncoder);
        UserDetails user = User.withUsername("gshop")
                .password("{bcrypt}$2a$10$.fB9kobYP7CM2Qriy3EqwO0R0tl7PUQbbGv4AT4Ntl73nQLvfX6ZG")
                .roles("USER")
                .build();
        auth.inMemoryAuthentication().withUser(user);
    }
}
