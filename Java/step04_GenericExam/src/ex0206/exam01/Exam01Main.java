package ex0206.exam01;

class Board{}

public class Exam01Main {

	public static void main(String[] args) {
		Box<String> box01 = new Box<String>();
		box01.content = "새우깡";
		
		Box<Integer> box02 = new Box<Integer>();
		box02.content = 1000;	//AutoBoxing
		Box<Board> box3 = new Box<Board>();
		box3.content = new Board();
		//Wrapper 클래스
		//객체 타입임에도 프리미티브 타입을 넣을 수 있다.
	}

}
