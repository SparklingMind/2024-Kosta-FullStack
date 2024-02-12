package ex0125.method;

class Methodinvoke01 {
	// 다음과 같이 메소드를 작성하세요.

	/*
	 * method 이름 : method01
	 * 어디서나 누구나 접근가능
	 * 정수 리턴
	 * 인수로 정수2개 받음
	 * 인수로 들어온 정수 2개를 곱해서 출력하고 리턴
	 */

	public int method01(int n1, int n2) {
		int multiply = n1 * n2;
		System.out.printf("두 수의 곱 : %d ", multiply);
		return multiply;
	}

}

class Methodinvoke02 {

	// method 이름 : method02
	// 어디서나 누구나 접근가능,객체를 생성하지 않고도 접근가능
	// 정수 리턴
	// 인수로 정수2개 받음

	// 인수로 들어온 정수 2개를 더해서 출력하고 더한수 리턴

	public static int method02(int n1, int n2) {
		int sum = n1 + n2;
		System.out.printf("두 수의 합 : %d", sum);
		return sum;
	}

}

class MethodInvokeExam {
	public static void main(String[] args) {

		// MethodInvoke01의 method01 호출
		Methodinvoke01 t = new Methodinvoke01(); // static 제한자가 없는 클래스이므로 메서드 호출 시 객체 생성 필요.
		t.method01(9, 3);

		// MethodInvoke02의 method02 호출 //static 제한자가 있는 클래스이므로 메서드 호출시 객체 생성 불필요.
		Methodinvoke02.method02(5, 6);

	}
}
