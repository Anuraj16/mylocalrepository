package com.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.authentication.CustomUserDetailService;

@Configuration
@EnableWebSecurity
@Transactional
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	private CustomUserDetailService customUserDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		// Users in memory.
		System.out.println("in configure global");
		
		auth.inMemoryAuthentication().withUser("admin").password("12345").roles("USER", "ADMIN");

		// For User in database.
		System.out.println("after in mem auth");
		auth.userDetailsService(customUserDetailsService);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/* http.addFilterAfter(
new CustomFilter(), BasicAuthenticationFilter.class);*/
		http.csrf().disable();

		//allow framing in same origin
		http.headers().frameOptions().sameOrigin();

		// The pages does not require login
		http.authorizeRequests().antMatchers("/","/index","/login", "/logout").permitAll();

		//below all pages require login
		// user as well as admin pages
		http.authorizeRequests().antMatchers("/home","/changePass","/savestatus","/delete-status-*","/edit-status-*").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

		// admin only pages
		http.authorizeRequests().antMatchers("/userInfo","/register","/empstatus","/saveUser","/edit-user-*","/delete-user-*").access("hasRole('ROLE_ADMIN')");

		//access denied page
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		System.out.println("before spring security vlidation");
		// Config for Login Form
		http.authorizeRequests().and().formLogin()//
		// Submit URL of login page.
		.loginProcessingUrl("/j_spring_security_check") // Submit URL
		.loginPage("/login")//
		/*.defaultSuccessUrl("/home")*///
		.defaultSuccessUrl("/index")
		.failureUrl("/index?error=true")//
		.usernameParameter("username")//
		.passwordParameter("password")
		// Config for Logout Page
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/");

	}
}
