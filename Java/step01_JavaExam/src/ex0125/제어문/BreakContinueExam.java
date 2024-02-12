package ex0125.제어문;

public class BreakContinueExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		outer: for(int a =1; a<=5; a++) {
			for(int b=1; b<=3; b++) {
//				if(b==2)continue;
				if(b==2)break outer;
//				if(a==2)break;
				System.out.print(b+" ");
				
			}
			System.out.println();
		}
	}

}
