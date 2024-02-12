package ex0124.제어문;

public class SwitchExam02 {

	public static void main(String[] args) {
		//1~12 사이 난수 발생
		//출력 -> ~월은 ~일까지 입니다. (30, 31, 28)
		
		int month = (int)(Math.random() * 12 + 1);
		int endDay = 0;
		
//		switch(month) {	// case를 ','로 구분하기 시작한 것이 허용된지는 얼마 되지 않았다. version 14 이후. 
//		case 2:  endDay = 28; break;
//		case 4, 6, 9, 11 : endDay = 30; break;
//		default : endDay =31;
//		}
		
//		endDay = switch(month) {	//break 대신에 ->와 { }로 변경해보기
//		case 2 -> 28;
//		case 4, 6, 9, 11 -> {	//version 14 이후
//			yield 30;
//		}
//		default -> 31;
//		};	//스위치값을 변수에 바로 값으로 대입할 때는 끝에 세미콜론 필요
//		
//		System.out.println(month + "월은 " + endDay + "일까지 입니다.");
		
		//if문으로 변경//////////////////////////////////////////
		if(month == 2) {
			endDay = 28;
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11) {
			endDay = 30;
		}
		else {
			endDay = 31;
		}
		System.out.println(month + "월은 " + endDay + "일까지 입니다.");
	}

}
