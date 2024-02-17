package com.example.swaggerapifirstexample.security;
//
//package com.example.swaggerannotationconfigexample.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
///**
// * @author Piyush Kumar.
// * @since 17/02/24.
// */
//
//@Configuration
//public class NewConfig2 {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.csrf().disable();
//        httpSecurity.authorizeRequests().antMatchers("/swagger-ui.html", "/swagger-ui/**", "/swagger-resources/**", "/swagger-resources", "/v3/api-docs/**", "/proxy/**").permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .httpBasic();
//
//        return httpSecurity.build();
//    }
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//            .username("piyush")
//            .password("kumar")
//            .roles("ADMIN")
//            .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
//}
