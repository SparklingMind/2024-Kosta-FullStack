package ex0130.Constuctor;

class Puppy3 {
	/*
	 * String 타입 전역 변수 선언
	 * int 타입 전역 변수 선언
	 */
	String name;
	int age;

	/*
	 * 인수가 없는 생성자작성
	 * String 타입 전역변수에 "메리" 할당
	 * "puplic Puppy3()호출되었습니다"출력
	 * 전역변수 출력
	 */

	Puppy3() {
		this.name = "츄츄";
		System.out.println("puplic Puppy3()호출되었습니다");
		System.out.println(this.name);
	}

	/*
	 * String 타입의 인수 1개를 받는 생성자작성
	 * String 타입 전역변수에 인수 할당
	 * "puplic Puppy3()호출되었습니다"출력
	 * 전역변수 출력
	 */

	Puppy3(String name) {
		this.name = name;
		System.out.println("puplic Puppy3()호출되었습니다");
		System.out.println(name);
	}

	/*
	 * String 타입의 인수 2개를 받는 생성자작성
	 * 인수2개를 하나의 String으로 만들어
	 * String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
	 * "puplic Puppy3()호출되었습니다"출력
	 */
	Puppy3(String name1, String name2) {
		this(name1 + name2);
		System.out.println("puplic Puppy3()호출되었습니다");
	}

	/*
	 * boolean 타입의 인수 1개를 받는 생성자작성
	 * 인수를 "쫑"과 붙여 하나의 String으로 만들어
	 * String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
	 * "puplic Puppy3()호출되었습니다" 출력
	 */
	Puppy3(boolean b) {
		this("쫑" + b);
		System.out.println("puplic Puppy3()호출되었습니다");
	}

	/*
	 * char 타입의 인수 1개를 받는 생성자작성
	 * 인수가 없는 생성자를 호출하고
	 * 인수로 받은 data를 int타입 전역변수에 할당
	 * "puplic Puppy3()호출되었습니다"출력
	 * int형 전역변수출력
	 */

	Puppy3(char c) {
		this();
		this.age = c;
		System.out.println("puplic Puppy3()호출되었습니다");
		System.out.println("age : " + this.age);
	}

	/*
	 * 메소드 printMemberVariable
	 * 리턴 없슴
	 * 전역변수를 출력
	 */

	public void printMemberVariable() {
		System.out.println("이름 : " + this.name + "\t" + "나이 : " + this.age);
	}

}

class ConstructorOverloadingExam {
	// 메인메소드에서
	public static void main(String[] args) {
		Puppy3[] pupArr = new Puppy3[5];
		// Puppy3 클래스의 각 생성자를 한번씩 이용해 객체 5개 생성
		pupArr[0] = new Puppy3();
		pupArr[1] = new Puppy3("삼이");
		pupArr[2] = new Puppy3("리", "리");
		pupArr[3] = new Puppy3(true);
		pupArr[4] = new Puppy3("A");

		// 각 객체의 printMemberVariable메소드를 한번씩 호출
		for (Puppy3 p : pupArr) {
			p.printMemberVariable();
		}
	}
}
