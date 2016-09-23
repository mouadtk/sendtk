package com.sendtk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("MAILER");
		auth.inMemoryAuthentication().withUser("mouadtk").password("123456").roles("MAILER");
		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.sessionManagement()
			.maximumSessions(15)
			.expiredUrl("/Auth/expired");
			
		
		http	
		.authorizeRequests()
			.antMatchers("/Auth/expired").permitAll()
	        .antMatchers("/resources/**").permitAll()
	        .antMatchers("/assets/**").permitAll()
	    .anyRequest().authenticated()
	        .and()
	    .formLogin()
	        .loginPage("/Auth/login")
	        .usernameParameter("username")
			.passwordParameter("password")
			.loginProcessingUrl("/Auth/Validate")
			.defaultSuccessUrl("/Campaign/PreparCampaign")
			.failureUrl("/Auth/login?error")
	        .permitAll()
	        .and()
	    .logout()
	    	.logoutSuccessUrl("/Auth/login?logout")
	        .permitAll()
	        .and()
	    .csrf().disable();
		
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
