package ex0126.array;

class ArrayValue {
	// 정수형 10개 저장하는 배열선언(선언과 동시에 임의값 지정)
	int intArr[] = new int[] { 1, 3, 5, 3, 2, 1, 5, 7, 0, 3 };

	/*
	 * printArrayvalue 메소드작성
	 * => 메소드 안에서 위에 선언된 배열방의 값을 출력한다.
	 * 
	 */
	public void printArrayvalue() {
		int len = intArr.length;
		// System.out.println("저장된 배열의 값 : ");
		// for (int i = 0; i < len; i++) {
		// System.out.print(intArr[i] + " ");
		// }

		for (int i : intArr) {
			// 개선된 for문의 예시. why? => 비슷한 패턴의 for문을 반복하는 것이 번거로워서.
			// 단점 : 인덱스 i를 체크해주는 코드는 사용 불가.
			System.out.println(intArr[i] + " ");
		}
	}
}

/////////////////////////////////////////////////
class ArrayValueExam {
	public static void main(String args[]) {
		// ArrayValue에 있는 printArrayvalue메소드 호출
		ArrayValue av = new ArrayValue();
		av.printArrayvalue();
	}
}