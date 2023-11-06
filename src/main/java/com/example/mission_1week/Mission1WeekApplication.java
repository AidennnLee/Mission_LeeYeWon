package com.example.mission_1week;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Mission1WeekApplication {
    public static void main(String[] args) {
        //SpringApplication.run(Mission1WeekApplication.class, args);
        Scanner scanner = new Scanner(System.in);
        String cmd;

        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.print("명령) ");
            cmd = scanner.nextLine();
            if(cmd.equals("종료")) break;
        }
    }
}
