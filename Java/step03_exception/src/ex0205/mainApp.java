package ex0205;

import java.util.Random;

public class mainApp {

	public static void main(String[] args) {
		System.out.println("***ShoppingMall Open");
		ShoppingMall mall = new ShoppingMall();
		Random r = new Random();
		for(int i=1; i<=10;i++) {
			int age = r.nextInt(55)+1;
			try {
				mall.enter(age);
			}catch (AgeCheckException e) {
				System.out.println(e.getMessage());
			}
			System.out.println();
		}
		System.out.println("**** ShoppingMall Close ****");
		
		System.out.println("예외 고객 : " + AgeCheckException.count + "명");
	}

}
