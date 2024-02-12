package ex0131.overriding;

class ObjectExam { // String 클래스에서처럼 toString 메소드 오버라이딩 해보기.
	String str;

	public ObjectExam() {

	}

	public ObjectExam(String str) {
		this.str = str;
	}

	public String toString() {
		return "주소값: " + super.toString() + " " + "문자열 : " + str;
	}

}

/**
 * println(Object obj) or print(Object obj)
 * :인수로 object 전달되면 obj.toString() 자동 호출
 * object에 정의되어 있는 toString() 메소드는 객체의 주소를 클래스이름@hashcode의 문자열로 만들어서 리턴해준다.
 */
public class ReferenceExam {

	public static void main(String[] args) {
		char c = 'a';
		String s01 = "장희정";
		String s02 = "Java";
		String s03 = new String("월요일");
		ObjectExam oe1 = new ObjectExam("안녕");
		ObjectExam oe2 = new ObjectExam("Hello");
		System.out.println(c);// a
		System.out.println(s01);// 문자열
		System.out.println(s02);// 문자열
		System.out.println(s03);// 문자열
		System.out.println(oe1);// 주소값
		System.out.println(oe2);// 주소값

	}
}
