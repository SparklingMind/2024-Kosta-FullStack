package ex0124.제어문;
class IfExam02{

	public static void main(String[] args){
	//1~12 사이의 난수를 발생한다.
	//발생한 난수가 1이면 일요일, 2이면 월요일, 3이면 화요일...5이면 금요일까지 만들고, 이외는 토요일로 출력한다.
	
	String day;
	int nansu = (int)(Math.random() * 12 + 1);
	int num = (int)nansu;
	if(num == 1) {
		day = "일요일";
	} else if(num == 2) {
		day = "월요일";
	} else if(num == 3) {
		day = "화요일";
	} else if(num == 4) {
		day = "목요일";
	} else if(num == 5) {
		day = "금요일";
	} else {
		day = "토요일";
	}
	System.out.println(num+"은 " + day);
	

	}
}