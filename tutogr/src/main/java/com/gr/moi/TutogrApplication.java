package com.gr.moi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.gr.moi.model.Account;
import com.gr.moi.repo.AccountRepo;
import com.gr.moi.repo.ProfileRepo;

@SpringBootApplication

public class TutogrApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(TutogrApplication.class, args);
	}


	
}
