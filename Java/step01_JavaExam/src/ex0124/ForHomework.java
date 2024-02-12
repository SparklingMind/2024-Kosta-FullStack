package ex0124;

public class ForHomework {

	public static void main(String[] args) {
		
		System.out.println("*************************별찍기 문제****************************");
		//1번 별찍기
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		//2번 별찍기
		System.out.println("-------------------------------------------------------------------");
		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		//3번 별찍기
		System.out.println("-------------------------------------------------------------------");
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
		System.out.println("-------------------------------------------------------------------");
		for (int i = 5; i >= 1; i--) {
			for (int j = 5; j >= 1; j--) {
				if (j > i)
					System.out.print(" ");
				else
					System.out.print("★");
			}
			System.out.println();
		}

	
		//for문과 Math.random()메소드를 이용해 두 개의 주사위의 눈을
		//(눈1, 눈2) 형태로 계속 출력하고,
		//눈의 합이 5가 되면 실행을 멈추기
		System.out.println("********************************주사위 눈의 합*******************************");
		int diceNum1, diceNum2;
		int diceSum = 0;
		while (diceSum != 5) {
			diceNum1 = (int) (Math.random() * 6 + 1);
			diceNum2 = (int) (Math.random() * 6 + 1);
			System.out.println("(눈1 : " + diceNum1 + "  눈2 : " + diceNum2 + ")");
			diceSum = diceNum1 + diceNum2;
			System.out.println("눈의 합 : " + diceSum);
		}
		System.out.println("눈의 합이 5가 되어 종료함.");

		//중첩 for문을 사용해 4x + 5y = 60 의 모든 해를 구해 (x,y) 형태로 출력.
		//(단, x와 y는 10 이하의 자연수)
		System.out.println("***********************4x + 5y = 60 의 10이하의 모든 해****************************");
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if((4*x+5*y) == 60){
					System.out.printf("(%d,%d)\n", x, y);
				}
			}
		}
	}

}
