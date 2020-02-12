
/**
 * 
 */
package com.gr.moi.config;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gr.moi.model.Account;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {  
	
	private AuthenticationManager authenticationManager;

public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {  
	super();
this.authenticationManager = authenticationManager;
}

@Override
public Authentication attemptAuthentication(HttpServletRequest request,  HttpServletResponse response) throws AuthenticationException {

	Account user=null;  try {
	user = new ObjectMapper().readValue(request.getInputStream(), Account.class);
	} 
	catch (Exception e) {
		throw new RuntimeException(e);
	}
		return authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
				user.getUsername(),  user.getPassword()
	));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse  response, FilterChain chain,
	Authentication authResult) throws IOException, ServletException {
	
	Account springUser=(Account)authResult.getPrincipal();  
	String jwtToken=Jwts.builder()
	.setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
	.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
	.claim("roles", springUser.getAuthorities())
	.compact();  response.addHeader(SecurityConstants.HEADER_STRING,
	SecurityConstants.TOKEN_PREFIX+jwtToken);
	}
	
}

