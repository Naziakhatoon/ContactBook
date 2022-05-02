package com.contactbook.contactbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication(scanBasePackages = {"com.contactbook.contactbook"})
@OpenAPIDefinition(info = @Info(title = "ContactBook",
version = "2.1.4", description = "ContackBook"))

public class ContactBookApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContactBookApplication.class, args);
    }
}
