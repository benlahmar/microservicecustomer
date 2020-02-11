package com.gr.moi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gr.moi.model.Account;
import com.gr.moi.repo.AccountRepo;
import com.gr.moi.repo.ProfileRepo;

@SpringBootApplication
public class TutogrApplication {

	@Autowired
	AccountRepo arepo;
	@Autowired
	ProfileRepo prepo;
	public static void main(String[] args) {
		SpringApplication.run(TutogrApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		
//		Account ac=new Account();
//		ac.setUsername("username1");
//		ac.setPassword("password1");
//		ac.setRole("admin");
//		arepo.save(ac);
//	}

	
}
