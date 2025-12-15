package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Profile({"dev","prod"})
public class DummyComponent {

    @Value("${sample.data}")
    private String data;

    @Value("${server.port}")
    private String port;

    @Value("${prod}") 
    private String prop;
    
    @Value("${db_password}")
    String dbp;

    @Autowired
    private Environment env;


    @PostConstruct
    public void init() {
        System.out.println("Sample Data: " + data);
        System.out.println("Server Port: " + port);
        System.out.println("Prod Specific: " + prop);
        System.out.println("password"+dbp);
        System.out.println("Active Profiles: " + String.join(", ", env.getActiveProfiles()));
    }
}

