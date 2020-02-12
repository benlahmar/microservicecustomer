/**
 * 
 */
package com.gr.moi.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gr.moi.model.Account;
import com.gr.moi.repo.AccountRepo;
import com.gr.moi.web.AccountNotFoundException;


/**
 * @author BEN LAHMAR EL HABIB
 *
 */
@Service
public class Securityservice implements UserDetailsService{
	
	@Autowired
	AccountRepo arepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> ac = arepo.findByUsername(username);
        ac.orElseThrow(() -> new AccountNotFoundException(0L));
        return ac.get();
	}

}
