package com.example.demo;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Demo1Application implements ApplicationRunner {

	@Autowired
	ProductRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

//		Product p1 = new Product();
//		p1.setPid(108);
//		p1.setDescription("charger");
//		p1.setPurchasedOn(Date.valueOf("2025-11-26"));
//		p1.setQty(15);
//		p1.setPrice(250);
//		repo.save(p1);
//
//		System.out.println(p1);
	}

}
