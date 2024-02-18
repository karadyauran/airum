package com.karadyauran.agile.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                        authorizationManagerRequestMatcherRegistry
                                .requestMatchers(
                                        new AntPathRequestMatcher("/api/product/**"),
                                        new AntPathRequestMatcher("/api/user/**"),
                                        new AntPathRequestMatcher("/api/start/**"),
                                        new AntPathRequestMatcher("/images/**"),
                                        new AntPathRequestMatcher("/api/enum/**"),


                                        new AntPathRequestMatcher("/**"),
                                        new AntPathRequestMatcher("/registration"),
                                        new AntPathRequestMatcher("/login"),
                                        new AntPathRequestMatcher("/login/**"),
                                        new AntPathRequestMatcher("/authentication/login/**")
                                )
                                .permitAll()
                                .anyRequest()
                                .authenticated())
                .sessionManagement(sessionManagement ->
                        sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
