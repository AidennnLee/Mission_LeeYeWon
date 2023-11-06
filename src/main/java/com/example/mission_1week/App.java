package com.example.mission_1week;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    String content, author;
    int lastId = 0;
    List<Word> words = new ArrayList<>();
    void run(){
        String cmd;

        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.print("명령) ");
            cmd = scanner.nextLine();

            if (cmd.equals("종료")) break;
            else if (cmd.equals("등록")) register();
            else if (cmd.equals("목록")) listing();
            else if (cmd.startsWith("삭제")) delete(cmd);
            else if (cmd.startsWith("수정")) modify(cmd);
        }
        scanner.close();
    }
    void register(){
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

    void listing(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for(int i = words.size() - 1; i >= 0; i--){
            Word listingWord = words.get(i);
            System.out.println(listingWord.id + " / " + listingWord.author + " / " + listingWord.content);
        }
    }

    void delete(String cmd){
        cmd = cmd.substring(6);
        int deleteId = Integer.parseInt(cmd);

        for(int i = words.size() - 1; i >= 0; i--){
            if(words.get(i).id == deleteId){
                words.remove(i);
                System.out.println(deleteId + "번 명언이 삭제되었습니다.");
                return;
            }
        }
        System.out.println(cmd + "번 명언은 존재하지 않습니다.");
    }

    void modify(String cmd){
        cmd = cmd.substring(6);
        int modifyId = Integer.parseInt(cmd);

        for(int i = words.size() - 1; i >= 0; i--){
            if(words.get(i).id == modifyId){
                Word modifyWord = words.get(i);
                System.out.print("명언(기존) : " + modifyWord.content + "\n명언 : ");
                modifyWord.content = scanner.nextLine();
                System.out.print("작가(기존) : " + modifyWord.author + "\n작가 : ");
                modifyWord.author = scanner.nextLine();

                System.out.println(modifyId + "번 명언이 수정되었습니다.");
                return;
            }
        }
        System.out.println(cmd + "번 명언은 존재하지 않습니다.");
    }
}
