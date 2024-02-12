package ex0205;

import java.io.IOException;
import java.util.Scanner;


/**
 * 어떤 쇼핑몰에 입장하기 위해서는 나이 입력이 필수.
 * 만약 나이가 18보다 작으면 예외 발생시키고 아니면 입장하신 걸 환영합니다." 메시지 출력.
 *메인 메소드 마지막 줄에서...
 *총 발생한 예외의 개수를 찍어라..!!
 *조건 : exception 클래스의 필드 피용.
 */

/*
 * 조건 
 * 1. 예외 클래스 한 개 -> exception을 상속 - 체크 예외
 * 	 예외 메시지 작성("애들은 가라") -> String 하나 받는 부모 생성자 호출
 * 2. 쇼핑몰 클래스 한 개
 * 	나이를 인수로 받는 메소드 작성
 * 	입력된 나이에 따라 예외발생 또는 메시지 출력
 * 	만약, 예외가 발생하면 직접 처리하지 않고 던진다.
 * 3. main 클래스 한 개
 * 	난수를 1~55 사이를 발생하여 쇼핑몰 클래스와 메소드를 10번 호출한다.
 * 
 * (int)(Math.random() * 경우의 수) + 최소값->0.0~.9999
 */

public class AgeCheckException extends Exception{	
	public static int count;
	public AgeCheckException() {	//Exception클래스의 생성자를 오버로딩
		super("애들은 가라");
		count++;
	}
	public AgeCheckException(String message) {
		super(message);
		count++;
	}
	
}