package ex0213;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KeyboardExam {
	public KeyboardExam() throws Exception {
		/*
		 * //키보드 입력 받기
		 * 
		 * InputStream is = System.in; //byte단위로 읽기 int i = is.read();
		 * System.out.println(i + "," + (char)i);
		 */
		
		/*
		 * //InputStream ==> reader로 변환해서 키보드 입력 처리한다. (한글 입력 등에 더 편리) InputStreamReader
		 * isr = new InputStreamReader(System.in); int i = isr.read();
		 * System.out.println(i + " , " + (char)i);
		 */
		
		
		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 * String data = br.readLine(); System.out.println(data);
		 */
		
	////Scanner 제공////////////////////////////////////////////////////
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		System.out.println(data);
	}
	
	public static void main(String[] args) throws Exception{
		new KeyboardExam();
	}

}
