package ex0205;

import java.util.Scanner;

public class ShoppingMall {

	public void enter(int age) throws AgeCheckException{
		
		if(age < 18) {
			AgeCheckException ex = new AgeCheckException("어른이 되어서 오세요.");
			throw ex;
		}
		System.out.println(age + "살님, 환영합니다.");
	}

}
