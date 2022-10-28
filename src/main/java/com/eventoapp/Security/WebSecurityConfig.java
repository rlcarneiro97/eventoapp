package com.eventoapp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig {
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll()
        .antMatchers(HttpMethod.GET, "/cadastrarEvento").hasRole("ADMIN")
        .antMatchers(HttpMethod.POST, "/cadastrarEvento").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login")
        .defaultSuccessUrl("/eventos", true).permitAll()
        .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .permitAll().logoutSuccessUrl("/login?logout");

        return http.build();
	}

    @Bean
	public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
		return (web) -> web.ignoring().antMatchers("/materialize/**", "/style/**");
	}

    // @Bean
    // public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder){
    //     InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    //     manager.createUser(User.withUsername("admin")
    //     .password(bCryptPasswordEncoder.encode("123"))
    //     .roles("USER", "ADMIN")
    //     .build());
    //     return manager;
    // }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder, UserDetailsService userDetailService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(userDetailService)
            .passwordEncoder(passwordEncoder)
            .and()
            .build();
    }

}
