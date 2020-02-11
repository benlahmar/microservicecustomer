package com.gr.moi.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gr.moi.model.Account;
import com.gr.moi.model.Profil;
import com.gr.moi.repo.AccountRepo;
import com.gr.moi.repo.ProfileRepo;

@RestController
public class AccountRest
{
	@Autowired
	AccountRepo arepo;
	@Autowired
	ProfileRepo prepo;
	
	@GetMapping("/accounts")
	public Page<Account> getaccounts(@RequestParam int page, @RequestParam int size)
	{
		Pageable  pr=PageRequest.of(page, size);
		return arepo.findAll(pr);
	}
	
	@GetMapping("/accounts/{id}")
	public Account  getaccount(@PathVariable Long id)
	{
		return arepo.findById(id)
		.orElseThrow(() -> new AccountNotFoundException(id));
	}
	
	@GetMapping("/accounts/profil/{id}")
	public ResponseEntity<List<Account>>  getaccount4profil(@PathVariable Long id)
	{
		ResponseEntity<List<Account>> resp;
		 List<Account> ps = arepo.findByProfileId(id);
		
			resp=new ResponseEntity<List<Account>>(ps, HttpStatus.OK);
					
		return resp;
	}
	
	
	@PostMapping("/accounts")
	public ResponseEntity<Account> addaccount(@RequestBody Account a)
	{
		Account ac = arepo.save(a);
		return new ResponseEntity<Account>(ac, HttpStatus.CREATED);
	}
	
	@PostMapping("/accounts/profile")
	public ResponseEntity<Account> addaccount2profil(@RequestBody Account a)
	{
		Profil p = prepo.findById(a.getProfile().getId()).orElse(null);
		a.setProfile(p);
		Account ac = arepo.save(a);
		return new ResponseEntity<Account>(ac, HttpStatus.CREATED);
	}
	
	@PostMapping("/profiles")
	public ResponseEntity<Profil> addaprofile(@RequestBody Profil p )
	{
		Profil ac = prepo.save(p);
		return new ResponseEntity<Profil>(ac, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/profiles")
	public Page<Profil> getprofiles(@RequestParam int page)
	{
		Pageable  pr=PageRequest.of(page, 10);
		return prepo.findAll(pr);
	}
	
	@GetMapping("/profiles/{id}")
	public ResponseEntity<Profil>  getaprofile(@PathVariable Long id)
	{
		ResponseEntity<Profil> resp;
		Optional<Profil> p = prepo.findById(id);
		if(p.isPresent()) {
			resp=new ResponseEntity<Profil>(p.get(), HttpStatus.OK);
			
		}
		else
		{
			resp=new ResponseEntity<Profil>(HttpStatus.NO_CONTENT);
		}
			
		return resp;
	}
	
	@PostMapping("/account/signin")
	public ResponseEntity<Account> singin(@RequestParam("log") String username,@RequestParam("pass") String pass)
	{
		List<Account> ac = arepo.findByUsernameAndPassword(username, pass);
		if(ac.size()>0)
			return new ResponseEntity<Account>(ac.get(0),HttpStatus.FOUND);
		else
			return 
					new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/account")
	public ResponseEntity<Account> updatePass(@RequestBody Account ac )
	{
		Optional<Account> a = arepo.findById(ac.getId());
		if(a.isPresent())
		{
			Account aa = arepo.save(ac);
			return new ResponseEntity<>(aa,HttpStatus.ACCEPTED);
		}else
			return 
					new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
}
