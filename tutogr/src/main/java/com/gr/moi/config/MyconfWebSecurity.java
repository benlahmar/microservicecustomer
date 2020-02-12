/**
 * 
 */
package com.gr.moi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyconfWebSecurity extends WebSecurityConfigurerAdapter{
	@Autowired
	Securityservice userservice;
	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		 http.csrf().disable().authorizeRequests()
//		 .antMatchers("/accounts/**").hasRole("ADMIN")
//		.anyRequest().authenticated()
//		 .and()
//		 .formLogin()
//		 .permitAll();
		 
		http.csrf().disable()
		// don't create session

		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()

		
         .formLogin()
             .permitAll()
         .and()
             .logout()
                 .permitAll()
         .and()
             .authorizeRequests()
                 .antMatchers("/").permitAll()
                 .antMatchers("/account/**").hasRole("ADMIN")
                 .antMatchers("/profiles/**").hasRole("user")
                 .anyRequest().fullyAuthenticated()
                 .and()
                 .addFilter (new JWTAuthenticationFilter(authenticationManager()))
                 .addFilterBefore (new JWTAuthorizationFilter(),   UsernamePasswordAuthenticationFilter.class);

         //.and().exceptionHandling().accessDeniedPage("/error/403");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication()
		.withUser("moi")
		.password("{noop}pass")
		.roles("USER");
		
		auth.inMemoryAuthentication()
		.withUser("toi")
		.password("{noop}pass")
		.roles("Admin");*/
		auth.userDetailsService(userservice).passwordEncoder(getPasswordEncoder());
	}
	
	private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }

}
