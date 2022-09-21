package com.zmo.familydb;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class FamilyDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilyDbApplication.class, args);
	}

}
