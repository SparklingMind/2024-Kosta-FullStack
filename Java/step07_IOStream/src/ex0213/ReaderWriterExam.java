package ex0213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ReaderWriterExam {
    public ReaderWriterExam() {
        // 문자 단위로 파일 읽기 - buffered 이용
        /*
         * FileReader라는 노드 스트림을 보조 스트림인 BufferedReader을 이용해 읽어오는 속도를 높인다.
         */
        try (BufferedReader br = new BufferedReader(new FileReader("src/ex0213/a.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0213/new.txt"))) {

            // 한 줄씩 읽기
            String data;
            while ((data = br.readLine()) != null) {
                System.out.println(data);
                bw.write(data);
                bw.newLine(); // 새로운 줄을 추가
            }

            // (이어서)추가적인 문자 및 문자열 쓰기
            bw.write(65); // 'A'의 ASCII 값
            bw.write("BCDEF");
            bw.write(32); // 공백의 ASCII 값
            bw.write("재미있다.");
        } catch (Exception e) {
            e.printStackTrace(); // 오류 발생 시 스택 트레이스 출력
        }
    }

    public static void main(String[] args) {
        new ReaderWriterExam();
    }
}
