package com.example.mission_1week;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Mission1WeekApplication {
    public static void main(String[] args) throws IOException {
        //SpringApplication.run(Mission1WeekApplication.class, args);
        new App().run();
    }
}