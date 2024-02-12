package ex0124.제어문;

public class ifExam01 {
	public static void main(String[] args) {
		
		//임의의 정수 변수를 선언하고 초기화한다.
		//선언된 변수의 값이 짝수이면 짝수, 홀수이면 홀수를 출력한다.
		int intNum = 6;
		if(intNum % 2 == 0) {
			System.out.println(intNum+"은 짝수입니다.");
		}
		else {
			System.out.println(intNum+"은 홀수입니다.");
		}
		
		double nansu = Math.random(); //0.0~0.9999999
		System.out.println("nansu = " + nansu);
		nansu = nansu*10+1;	//1~10사이 숫자 랜덤으로 저장
		System.out.println("nansu = " + (int)nansu);
	}
		
}
