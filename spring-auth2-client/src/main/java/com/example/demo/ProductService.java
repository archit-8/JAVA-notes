
package com.example.demo;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final Environment env;

    public ProductService(Environment env) {
        this.env = env;
    }

    public void printConnectionProps() {
        String url = env.getProperty("connection.db.url");
        String user = env.getProperty("connection.db.user");
        String pass = env.getProperty("connection.db.pass");
        System.out.println("[connection.properties]");
        System.out.println("connection.db.url  = " + url);
        System.out.println("connection.db.user = " + user);
        System.out.println("connection.db.pass = " + pass);
    }

    public void printAppSettings() {
        String toggle = env.getProperty("settings.feature.toggle");
        String welcome = env.getProperty("settings.welcome.message");
        System.out.println("[appsettings.properties]");
        System.out.println("settings.feature.toggle  = " + toggle);
        System.out.println("settings.welcome.message = " + welcome);
    }
}