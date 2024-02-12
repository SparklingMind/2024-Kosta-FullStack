//MethodOverloadingExam.java
package ex0126.overloading;

class OverloadedMethod {
	private int i; // 전역필드, 0으로 초기화, 은닉(외부에서 접근 불가)
	private int j;
	private String s;
	private char c;

	public void setOverload(int i) {
		this.i = i; // 전달된 인수의 값을 전역 필드에 넣어라 (대입)
	}

	public int getOverload() {
		return i;
	}

	// 오버로드 예시들

	// setOverload를 Overloading하세요. 리턴도 하세요.
	public String setOverload(int i, int j) {
		this.i = i;
		this.j = j;
		return "숫자를 저장했어요.";
	}

	// setOverload를 또 Overloading 하세요. 또 다른 놈으로 리턴 하세요.
	public String setOverload(String s) {
		this.s = s;
		return "문장을 저장했어요.";
	}

	// setOverload를 또 또Overloading 하세요. 리턴 안해요
	public void setOverload(char c) {
		this.c = c;
	}

	// getOverload를 Overloading하세요. 리턴도 하세요.
	public String getOverload(int i, int j) {
		return "저장된 숫자들 : " + this.i + this.j;
	}

	// getOverload를 또 또Overloading 하세요. 리턴 안해요
	public void getOverload(String s) {
		System.out.println("저장된 문장 : " + this.s);
	}
}

class MethodOverloadingExam {

	public static void main(String[] agr) {
		// OverloadedMethod객체에서 호출가능한 메소드들을 한번씩 호출하세요.
		OverloadedMethod om = new OverloadedMethod();
		om.setOverload(3);
		System.out.println(om.getOverload());
		om.setOverload(5, 10);
		System.out.println(om.getOverload(3, 3));
		om.setOverload("Keep going.");
		om.getOverload("저장된 문장?");

	}

}
