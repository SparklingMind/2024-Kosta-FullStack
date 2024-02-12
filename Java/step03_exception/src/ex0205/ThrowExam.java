package ex0205;



import java.io.IOException;



public class ThrowExam {
	public void aa(int i)throws IOException, ArithmeticException {
		System.out.println("aa method call...");
		//인수가 음수이면 안 되는 프로그램으로 가정.-> 강제로 예외를 발생시킨다.
		
		if(i<0) {
			throw new IOException("음수는 안 돼요~");
//			throw new RuntimeException("음수는 안 돼요~");//비체크예외
		}
		
		System.out.println("양수 i의 값은 = "+ i);
		int result = 100/i; //0이면 ArithemticException 발생 가능.
		
		System.out.println("aa method End...");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--- 메인 시작 ---");
		try {
			new ThrowExam().aa(0);
		}catch(IOException| ArithmeticException e) {
			System.out.println("첫 번째 예외 : " + e.getMessage());
		}
		
		
		System.out.println("--- 메인 끝 ---");
	}

}
