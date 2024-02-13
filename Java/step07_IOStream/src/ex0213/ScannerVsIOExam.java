package ex0213;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

public class ScannerVsIOExam {

	public static void main(String[] args) throws Exception {
		
		ScannerVsIOExam se = new ScannerVsIOExam();
		
		System.out.println("1. Scanner ----------------");
		se.test(); //0.032453501s
		
		System.out.println("2. IO---------------------");
        se.test2();// 0.015301s. BufferedReader가 Scanner보다 훨씬 빠른 것을 확인할 수 있다.
        
	}
	
	/**
	 *  Scanner로 읽기
	 * */
	public void test() throws Exception{
		System.setIn(new FileInputStream("src/ex0213/input.txt"));
		Scanner sc = new Scanner(System.in);
		
		long start = System.nanoTime();
		
		while(sc.hasNext()) {
			String data = sc.nextLine();
//			System.out.println(data);
		}
		
		long end = System.nanoTime();
		
		System.out.println( (end-start) / 1_000_000_000.0 +"s");
	}
	
	/**
	 *  IO로 읽기 
	 * */
	public void test2() throws Exception {
		BufferedReader br = 
				new BufferedReader(new FileReader("src/ex0213/input.txt"));
		
		String data=null;
		long start = System.nanoTime();
		
		while((data=br.readLine()) != null) {
//			System.out.println(data);
		}
		
		long end = System.nanoTime();
		
		System.out.println( (end-start) / 1_000_000_000.0 +"s");
	}

}

