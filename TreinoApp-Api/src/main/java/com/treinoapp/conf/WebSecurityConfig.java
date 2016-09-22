package com.treinoapp.conf;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationSuccessHandler successHandler;

	@Autowired
	private AuthenticationFailureHandler failureHandler;

	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	    http
	    	.cors().and()
	      .csrf().disable()
	      
	      .authorizeRequests()
	      	//.antMatchers("/api/**").authenticated()
	        .anyRequest().permitAll()
	        .and()
	        
	        
	        .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).accessDeniedHandler(accessDeniedHandler).and()
	        
	        
	        .formLogin().loginPage("/login").successHandler(successHandler).failureHandler(failureHandler)
			.usernameParameter("username").passwordParameter("password").permitAll().and()
			.logout().logoutUrl("/logout").logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler()).deleteCookies("JSESSIONID").permitAll().and()
	        
	        
	      .httpBasic().and()
	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST","DELETE","PUT","OPTIONS"));
		configuration.setAllowedHeaders(Arrays.asList("x-requested-with", "authorization", "Content-Type"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		// auth.inMemoryAuthentication().withUser("user").password("password").roles("ALUNO");
	}

}
