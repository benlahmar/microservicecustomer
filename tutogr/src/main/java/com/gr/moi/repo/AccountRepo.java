/**
 * 
 */
package com.gr.moi.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gr.moi.model.Account;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public interface AccountRepo extends JpaRepository<Account, Long>{
		public List<Account> findByUsernameAndPassword(String username, String password);

		List<Account> findByProfileId(Long id);
	public Optional<Account> findByUsername(String username);
}
