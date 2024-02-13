package ex0213.assignment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * 키보드입력을  exit단어를 만날때 까지 입력 받아서 모니터에 출력하고
   exit단어를 입력하면 종료한다.
   입력된 내용을 파일에 저장한다.
 */
public class KeyboardInputToFile {
	private static final String OUTPUT_FILE_NAME = "src/ex0213/assignment/output.txt";

	public KeyboardInputToFile() {
		try (Scanner sc = new Scanner(System.in);
				BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME, true))) {
			System.out.println("안녕하세요. 나가고 싶을 때는 'exit'을 입력하세요. ");

			while (sc.hasNextLine()) {
				String inputLine = sc.nextLine();
				if ("exit".equalsIgnoreCase(inputLine)) {
					System.out.println("프로그램 종료.");
					break;
				}
				System.out.println(inputLine); // 입력한 문자열을 모니터에 출력
				bw.write(inputLine); // 파일에 쓰기.
				bw.newLine(); // 새로운 줄로 구분

			}
		} catch (IOException e) {
			System.err.println("에러 발생 : " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		new KeyboardInputToFile();
	}
}