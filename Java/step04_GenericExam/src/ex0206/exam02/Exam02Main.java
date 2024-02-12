package ex0206.exam02;

public class Exam02Main {

	public static void main(String[] args) {
		
		//상품 2개 생성
		Product<Tv,String> p1 = new Product<Tv, String>();
		p1.setKind(new Tv());
		p1.setModel("스마트 Tv");
		
		System.out.println("-------------");
		
	}

}
