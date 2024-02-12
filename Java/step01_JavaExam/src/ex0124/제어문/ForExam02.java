package ex0124.제어문;

public class ForExam02 {

	public static void main(String[] args) {
		//1~100까지 10행 10열로 출력 (for문 안에 for문 이용)
		System.out.println("------------1~100까지 10행 10열로 출력 (for문 안에 for문 이용)-------------");
//		for(int i=1;i<=100;i++) {
//			System.out.print(i + "\t");
//			if(i%10 == 0) System.out.println();
//			
//		}
		
		for(int i=0;i < 10; i++) {
			for(int j=1;j<=10;j++) {
				System.out.print((i * 10) + j + "\t");
			}
			System.out.println();
		}
		
		//구구단 출력
		System.out.println("\n-------------구구단 출력--------------");
		for(int row=2;row<=9;row++) {	//9행
			for(int col=1;col<=9;col++) {	//8열
				System.out.print(row + " * " + col + " = " + row*col + "\t");
			}
			System.out.println();
		}
		
		//5단만 빼고 찍기
		System.out.println("\n-------------5단만 빼고 찍기--------------");
		for(int row=2;row<=9;row++) {	//9행
			
			for(int col=1;col<=9;col++) {	//8열
				if(row==5) break;
				System.out.print(row + " * " + col + " = " + row*col + "\t");
			}
			System.out.println();
		}
		//5단까지만 찍기
		System.out.println("\n-------------5단까지만 찍기--------------");
		for(int row=2;row<=9;row++) {	//9행
			if(row>5) break;
			for(int col=1;col<=9;col++) {	//8열
				System.out.print(row + " * " + col + " = " + row*col + "\t");
			}
			System.out.println();
		}
	}

	}

