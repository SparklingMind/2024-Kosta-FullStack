package ex0206.exam04;

public class Exam04Main {

	public static void main(String[] args) {
		Box<String> box1 = new Box<String>();
		Box<String> box2 = new Box<String>();
		
		box1.content = "배고파";
		box2.content = "배고파";
		
		boolean result = box1.compare(box2);
		System.out.println("result = "+ result);
		
		Box<Integer> box3 = new Box<Integer>();
		Box<Integer> box4 = new Box<Integer>();
		
		box3.content = 5;
		box4.content = 5;
		
		result = box3.compare(box4);
		System.out.println("result = "+ result);
	}

}
