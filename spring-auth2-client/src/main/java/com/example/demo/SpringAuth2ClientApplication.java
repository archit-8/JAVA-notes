
package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@PropertySources({
    @PropertySource("classpath:connection.properties"),
    @PropertySource("classpath:appsettings.properties")
})
public class SpringAuth2ClientApplication implements CommandLineRunner {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(SpringAuth2ClientApplication.class, args);
    }


@Override
public void run(String... args) {
    System.out.println("=== connection.properties ===");
    System.out.println("connection.db.url  = " + env.getProperty("connection.db.url"));
    System.out.println("connection.db.user = " + env.getProperty("connection.db.user"));
    System.out.println("connection.db.pass = " + env.getProperty("connection.db.pass"));

    System.out.println("=== appsettings.properties ===");
    System.out.println("settings.feature.toggle  = " + env.getProperty("settings.feature.toggle"));
    System.out.println("settings.welcome.message = " + env.getProperty("settings.welcome.message"));
}

}
