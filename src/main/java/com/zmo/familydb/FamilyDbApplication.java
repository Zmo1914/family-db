package com.zmo.familydb;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.zmo.familydb.repository.StatusRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEncryptableProperties
public class FamilyDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilyDbApplication.class, args);


	}
}
