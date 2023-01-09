package com.example.thingsFlow.config.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebAuthorizationConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()      // csrf를 disable 하지 않으면 Post 요청이 막힌다
                .authorizeRequests() // 인가 요청이 오면
                .antMatchers("/**",
                        "/api/**",
                        "/swagger-ui.html",
                        "/v1/**",
                        "/v2/**",
                        "/v3/**") // 해당 경로들은
                .permitAll() // 접근을 허용한다.
                .anyRequest() // 다른 모든 요청은
                .authenticated(); // 인증이 되야 들어갈 수 있다.
    }
}