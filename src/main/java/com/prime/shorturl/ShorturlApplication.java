package com.prime.shorturl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ShorturlApplication {


	public static void main(String[] args) {
		SpringApplication.run(ShorturlApplication.class, args);
	}


}
