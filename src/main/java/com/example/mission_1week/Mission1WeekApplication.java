package com.example.mission_1week;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Mission1WeekApplication {
    public static void main(String[] args) {
        //SpringApplication.run(Mission1WeekApplication.class, args);
        Scanner scanner = new Scanner(System.in);
        String cmd, content, author;
        int lastId = 0;
        List<Word> words = new ArrayList<>();

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

                Word word = new Word();
                word.content = content;
                word.author = author;
                word.id = lastId;
                words.add(word);

                System.out.println(lastId + "번 명언이 등록되었습니다.");
            }
            if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int i = words.size() - 1; i >= 0; i--){
                    Word listingWord = words.get(i);
                    System.out.println(listingWord.id + " / " + listingWord.author + " / " + listingWord.content);
                }
            }
        }
    }
}
