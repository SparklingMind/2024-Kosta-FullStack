package ex0126.array;

class ArrayExam {

	// 각int,double,char,boolean ,String type별로 총 5개씩 저장하는 배열을 생성하세요
	int[] intArr = new int[5];
	double[] doubleArr = new double[5];
	char[] charArr = new char[5];
	boolean[] booArr = new boolean[5]; // 초기값 : null
	String[] strArr = new String[5];

	// 메소드 : printArrayValue01
	// 위의 배열들에 자동으로 초기화 된값을 출력하세요
	public void printArrayValue01() {

	}

	// 메소드 : printArrayValue02
	// 위의 5개의 배열에서 서로 다른른 적당한 값으로 data를 할당하세요.
	public void printArrayValue02() {

		// intArr = new int [] {1,2,3,4,5}
		// 이렇게 하면 원래의 intArr의 주소에 지정한 값들이 저장될 거 같지만, new int[]부분이 먼저 배열을 생성하고, 그 주소값이
		// intArr이 저장된다.

		for (int i = 0; i < 5; i++) { // 값을 변경하고 싶으면 실제 각각의 배열의 인덱스에 접근해서 변경해야 한다.
			intArr[i] = i + 10;
			doubleArr[i] = i * 3.0;
			charArr[i] = (char) ('B' + i);
			if (i % 2 == 0)
				booArr[i] = true;
			strArr[i] = "Hello!" + i;
		}

	}

	// 메소드 : printArrayValue03
	// 새롭게 할당된값을 출력하세요
	public void printArrayValue03() {
		System.out.println("*************int 배열*************");
		for (int i = 0; i < 5; i++) {
			System.out.print(intArr[i] + " ");
		}
		System.out.println();
		System.out.println("*************double 배열*************");
		for (int i = 0; i < 5; i++) {
			System.out.print(doubleArr[i] + " ");
		}
		System.out.println();

		System.out.println("double 배열 개선된 for문으로 출력");
		for (double d : doubleArr) {
			System.out.print(d + " ");
		}
		System.out.println();

		System.out.println();
		System.out.println("*************char 배열*************");
		for (int i = 0; i < 5; i++) {
			System.out.print(charArr[i] + " ");
		}
		System.out.println();
		System.out.println("*************boolean 배열*************");
		for (int i = 0; i < 5; i++) {
			System.out.print(booArr[i] + " ");
		}
		System.out.println();
		System.out.println("*************String 배열*************");
		for (int i = 0; i < 5; i++) {
			System.out.print(strArr[i] + " ");
		}
		System.out.println();
	}
	// 메인메소드에서
	// ArrayExam의 메소드들을 순서대로 호출하세요.

	public static void main(String[] args) {
		ArrayExam ae = new ArrayExam();
		ae.printArrayValue01();
		ae.printArrayValue02();
		ae.printArrayValue03();
	}
}