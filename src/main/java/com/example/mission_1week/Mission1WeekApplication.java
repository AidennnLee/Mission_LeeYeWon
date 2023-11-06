package com.example.mission_1week;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Mission1WeekApplication {
    public static void main(String[] args) {
        //SpringApplication.run(Mission1WeekApplication.class, args);
        Scanner scanner = new Scanner(System.in);
        String cmd, content, author;
        int lastId = 0;

        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.print("명령) ");
            cmd = scanner.nextLine();

            if(cmd.equals("종료")) break;
            if(cmd.equals("등록")){
                System.out.print("명언 : ");
                content = scanner.nextLine();
                System.out.print("작가 : ");
                author = scanner.nextLine();
                lastId++;
                System.out.println(lastId + "번 명언이 등록되었습니다.");
            }
        }
    }
}
