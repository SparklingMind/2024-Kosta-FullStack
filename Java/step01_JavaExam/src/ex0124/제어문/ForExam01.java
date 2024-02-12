package ex0124.제어문;

public class ForExam01 {

	public static void main(String[] args) {
		
		
		
		
		
		//1~100까지 한 줄로 출력
		System.out.println("1~100까지 한 줄로 출력");
		for(int i=1; i<=100; i++)
			System.out.println(i);
		
		//A ~ Z까지 한 줄로 출력
		
		System.out.println("A ~ Z까지 한 줄로 출력");
		for(char i='A'; i<='Z'; i++)
			System.out.println((char)i);
		
		//1 ~ 10까지 합을 구한다.
		int sum = 0;
		for(int i=1; i<=10; i++) {
			sum += i;
		}
		System.out.println("1~10까지 수의 합 : " + sum);
		
		//1~100사이의 7의 배수만 출력 한다.
		for(int i=1; i<=100; i++) {
			if(i % 7 == 0) {
				System.out.println("7의 배수 : " + i);
			}
		}
	}

}
