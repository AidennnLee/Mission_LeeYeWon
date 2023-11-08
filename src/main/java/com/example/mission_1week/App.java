package com.example.mission_1week;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    String content, author;
    int lastId = 0;
    List<Word> words = new ArrayList<>();
    void run() throws IOException {
        File file = new File("words.txt");
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    //파일 생성 성공한 경우
                } else {
                    System.out.println("파일 생성에 실패했습니다.");
                }
            } catch (IOException e) {
                System.out.println("파일 생성 중 오류가 발생했습니다: " + e.getMessage());
            }
        }

        words = readWords(words);
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
        writeWords();
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

    // 텍스트 파일로부터 데이터를 읽어 arrayList words에 저장. 프로그램 시작 시 최초 1번만 실행.
    List<Word> readWords(List<Word> wordList) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("words.txt"));

        String line;
        while ((line = reader.readLine()) != null){
            Word readWord = new Word();
            readWord.id = Integer.parseInt(line);
            readWord.author = reader.readLine();
            readWord.content = reader.readLine();
            wordList.add(readWord);
            lastId++;
        }
        reader.close();
        return wordList;
    }

    //arrayList words로부터 데이터를 읽어 텍스트 파일에 저장. 프로그램 종료 직전 1번만 실행.
    void writeWords() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("words.txt"));

        for(int i = 0; i < words.size(); i++){
            writer.write(Integer.toString(words.get(i).id));
            writer.newLine(); // 다음 줄로 이동
            writer.write(words.get(i).author);
            writer.newLine(); // 다음 줄로 이동
            writer.write(words.get(i).content);
            writer.newLine(); // 다음 줄로 이동
        }
        writer.close();
    }
}