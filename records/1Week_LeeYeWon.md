## [1Week] 이예원

### 1주차 미션 요약

---

**[접근 방법]**

프로젝트 목표

- 단계별로 기능을 추가해 본 경험이 많지 않아 계속 추가할 때마다 코드가 지저분해지고 스파게티 코드가 되는 일이 많았으므로, 우선적으로 가독성을 신경쓰고 최소한의 기능만 구현하려 했다.
- 단계별 요구하는 기능을 확실히 수행하는 것에 중점을 두었다.
- 분리할 수 있는 기능은 최대한 분리하는 것을 부가적인 목표로 삼았다.

단계별 상세

- 1단계
  - while문을 이용해 '종료'가 입력될 때까지 반복
- 2단계
  - '등록' 명령문 입력 시 명언과 작가 입력.(저장하지 X)
- 3단계
  - 명언 등록 시 명언번호 출력.
- 4단계
  - 명언 등록 시 명언번호 출력되며 등록된 명언 순서에 따라 번호 부여. 이 때, 실제 인덱스는 명언 번호보다 1 작은 수임에 주의
- 5단계
  - 저장한 명언의 목록을 출력. 목록을 출력하려면 등록한 명언은 어딘가에 저장되어 있어야 함. 명언은 배열에 저장할 수도 있으나 삭제가 쉽도록 arrayList 컬렉션을 사용했다.
  - 명언을 저장할 때 명언 정보에는 명언 내용과 작가가 포함되어야 하므로 Word 클래스를 생성해 내용을 담기 위한 문자열 content와 작가를 담기위한 문자열 author를 필드로 선언했다.
    또한, 명언을 삭제하고 추가함을 통해 실제 인덱스와 명언 번호에는 차이가 생기므로 명언 번호인 id를 필드로 추가했다.
  - 조건에 맞게 출력하려면 arrayList에 저장된 역순으로 출력해야 한다.
- 6단계
  - 삭제 명령어를 처리하기 위해 startsWith()로 삭제 명령을 체크하고 subString()과 Integer.parseInt()로 명언 id를 추출했다. arrayList words의 모든 내용물을 훑어 일치하는 id가 발견되는 경우 삭제하도록 했다. 
- 7단계
  - 삭제할 명언 번호가 존재하지 않는 경우 오류 메세지를 출력하기 위해, 삭제 성공 시 즉시 return하도록 설계했다. 삭제 실패 시 메세지가 출력된다.
- 8단계
  - 삭제 명령어를 처리하기 위해 startsWith()로 수정 명령을 체크하고 subString()과 Integer.parseInt()로 명언 id를 추출했다. arrayList words의 모든 내용물을 훑어 일치하는 id가 발견되는 경우 수정하도록 했다.
- 9단계 파일 입출력
  - 파일에 저장 형태는 3줄을 사용하여 각각 첫 줄은 명언 번호, 두 번째 줄은 작가, 세 번째 줄은 명언 내용으로 간주했다.
  - 텍스트 파일에서 읽어 온 데이터를 먼저 arrayList words에 저장하여 초기화된 상태에서 나머지는 동일하게 수행하도록 했다.
  - 프로그램 종료 시 텍스트 파일에 arrayList words의 전체 데이터를 새로 작성하도록 설계했다.
  - 파일 입출력 시 한 줄 씩 읽고 쓰기 위해 FileReader, FileWriter가 아닌 BufferedReader와 BufferedWriter 클래스를 사용했다. 참고한 예제는 다음과 같다.
    ```java
      import java.io.BufferedReader;
      import java.io.BufferedWriter;
      import java.io.FileReader;
      import java.io.FileWriter;
      import java.io.IOException;

      public class Main {
        public static void main(String[] args) {
          try {
            // 파일로부터 읽을 BufferedReader 생성
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

            // 파일에 쓸 BufferedWriter 생성
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
              // 한 줄을 읽어와서 처리
              // 예시로 읽은 줄을 대문자로 변환하여 쓰기
              String upperCaseLine = line.toUpperCase();
              writer.write(upperCaseLine);
              writer.newLine(); // 다음 줄로 이동
             }

            // 스트림 닫기
            reader.close();
            writer.close();
        } catch (IOException e) {
        e.printStackTrace();
        }
      }
    }
    ```

**[특이사항]**

아쉬웠던 점
- 기본으로 제시 된 10단계까지 달성하는 것이 목표였으나, json 파일 생성까지 수행하지 못한 것
- TDD를 이용하여 작성하지 않은 점
- 쿼리를 해체하지 않고 단순히 startsWith()를 사용하여 else if로 처리했는데, 코드도 중복되고 프로그램 자체가 얕은 느낌이 들어 강사님이 알려주신 대로 rq 객체를 따로 만들어 쿼리를 처리했으면 좋았을 것이다.

추후 리팩토링 시, 추가적으로 진행하고 싶은 부분
- 1차 리팩토링
  - 쿼리 해체를 위한 객체 만들기
  - 10단계 data.jason 빌드 완성하기
  - 클래스 필드에 직접 접근하지 못하도록 getter, setter 추가하기


- 2차 리팩토링