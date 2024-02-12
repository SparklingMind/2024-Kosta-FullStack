package ex0124;

public class StarMarker {

	public static void main(String[] args) {
		//1번 별찍기
		System.out.println("----------------**실행**------------------");
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		//2번 별찍기
		System.out.println("************************************");
		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		//3번 별찍기
		System.out.println("************************************");
		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= 5; j++) {
				if (j < i)
					System.out.print(" ");
				else
					System.out.print("★");
			}
			System.out.println();
		}
		//4번 별찍기
		System.out.println("************************************");
		for (int i = 5; i >= 1; i--) {
			for (int j = 5; j >= 1; j--) {
				if (j > i)
					System.out.print(" ");
				else
					System.out.print("★");
			}
			System.out.println();
		}

	}

}
