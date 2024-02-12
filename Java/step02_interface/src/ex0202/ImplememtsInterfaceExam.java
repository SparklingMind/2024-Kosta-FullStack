package ex0202;

//이 소스를 컴파일이 되도록 수정/추가/주석처리 하세요.
interface InterfaceExam00 {
	abstract void interfaceExam00();
}

interface InterfaceExam01 extends InterfaceExam00 {
	final int i = 767;
	// protected int k = 999; //interface는 public static final이 기본세팅이고 그것만 가능하다.
	int k = 999;

	void interfaceExam01(int i, int k);
}

interface InterfaceExam02 {
	int j = 747;
	// private int privateInt = 8; //interface는 public static final이 기본세팅이고 그것만
	// 가능하다.
	int privateInt = 8;

	void interfaceExam02(int j);

}

class SuperClassExam {
	String superString = "Super";

	String superMethod() {
		System.out.println("SuperClassExam.SuperMethod()가 호출되었습니다.");
		return "returnString";
	}
}

class SubClassExam01 extends SuperClassExam implements InterfaceExam01 {
	public void interfaceExam00() { // 인터페이스의 부모 메서드도 모두 오버라이딩 해야 한다.

	}

	public void interfaceExam01(int i, int k) {

	}
}

class SubClassExam02 extends SuperClassExam
		implements InterfaceExam01, InterfaceExam02 { // interface의 메소드는 무조건 구현이 되어야한다.
	@Override
	public void interfaceExam01(int i, int k) {

	}

	@Override
	public void interfaceExam02(int j) {

	}

	@Override
	public void interfaceExam00() { // 인터페이스의 부모 메서드도 모두 오버라이딩 해야 한다.
		throw new UnsupportedOperationException("Unimplemented method 'interfaceExam00'");
	}
}

abstract class SubClassExam03 extends SuperClassExam
		implements InterfaceExam01, InterfaceExam02 {
} // abstract클래스는 인터페이스 오버라이딩 안 해도 에러가 발생하지 않는다.

class SubClassExam04 extends SubClassExam02 {
	// 여기에 필요한 것들을 추가하여 문제를 해결하세요..
	public void interfaceExam00() {
	}

	public void interfaceExam01(int i, int k) {
	}

	public void interfaceExam02(int j) {
	}

	SubClassExam04() {
		System.out.println("subClassExam04() 객체 생성");
		System.out.println(" i = " + i);
		System.out.println(" j = " + j);
	}

	SubClassExam04(String s1, String s2) {
		System.out.println(s1 + " 타입 " + "subClassExam04(" + s2 + ") 객체 생성");

	}

	void printSuperString() {
		// InterfaceExam01 ie01 = new InterfaceExam01(); //인터페이스는 타입은 가능해도 생성은 불가능하다.
		InterfaceExam01 ie01;

		System.out.println(" superString = " + superString);
	}
}

// 여기서부터는 하나도 고치지 마시고 그대로 쓰면 됩니다.
public class ImplememtsInterfaceExam {
	public static void main(String args[]) {
		SubClassExam02 sub02sub04 = new SubClassExam04("SubClassExam02", "sub02sub04");
		SuperClassExam superSub04 = new SubClassExam04("SuperClassExam", "superSub04");
		InterfaceExam01 ifc01Sub04 = new SubClassExam04("InterfaceExam01", "ifc01Sub04");
		SubClassExam04 sub04 = new SubClassExam04();
		sub04.interfaceExam00();
		sub04.interfaceExam01(1, 7);
		sub04.superMethod();
	}
}
