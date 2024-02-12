package ex0206.exam05;

public class MainApp {

	public static void main(String[] args) {
		MainApp ma = new MainApp();
		
		Box<Integer> box1 = ma.boxing(100);
		System.out.println(box1.getT());
		Box<String> box2 = ma.boxing("희정");
		System.out.println(box2.getT());

	}
/**메소드 추가 - 제네릭메소드*/
	public <T> Box<T> boxing (T t) {	//제네릭타입을 인수나 리턴에서 사용할 때, 선언 문법 유의. 제한자 옆에 타입 파라미터 (ex. <T>) 정의해야한다.
		Box<T> box = new Box<T>();
		box.setT(t);
		
		return box;
	}
	
	public <T> Box<T> boxing2 () {	//제네릭타입을 인수나 리턴에서 사용할 때, 선언 문법 유의. 제한자 옆에 타입 파라미터 (ex. <T>) 정의해야한다.
		return null;
	}
	
	public <T> void boxing3 (T t) {	//제네릭타입을 인수나 리턴에서 사용할 때, 선언 문법 유의. 제한자 옆에 타입 파라미터 (ex. <T>) 정의해야한다.
		
	}
	
}

