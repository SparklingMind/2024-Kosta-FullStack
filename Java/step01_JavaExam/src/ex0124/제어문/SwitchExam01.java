package ex0124.제어문;

public class SwitchExam01 {

	public static void main(String[] args) {
		char day;
		int nansu = (int)(Math.random() * 12 + 1);
		int num = (int)nansu;
		
		switch(num) {
		case 1 : day = '일'; break;	//break이 없으면 모든 값이 default값으로 나온다.
		case 2 : day = '월'; break;
		case 3 : day = '화'; break;
		case 4 : day = '수'; break;
		case 5 : day = '목'; break;
		case 6 : day = '금'; break;
		default : day = '토';
		}
		
		System.out.println(nansu + "는 " + day + "요일입니다.");
	}

}
