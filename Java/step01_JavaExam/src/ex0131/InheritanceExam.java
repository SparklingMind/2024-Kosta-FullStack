
package ex0131;

class Car {
	public String carname;
	public int cost;

	protected void printAttributes() {
		System.out.println("carname=" + carname + "\tcost=" + cost);
	}
}

class EfSonata extends Car {
	public EfSonata() {
		this.carname = "A";
		this.cost = 30000000;
	}
}
// Car를 상속받는 EfSonata, Excel, Carnival 3개 클래스 작성
// 각 클래스에 인수를 받지않는 생성자 작성
// 각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당

class Excel extends Car {
	String color = "pink";

	public Excel() {
		super.carname = "B";
		this.cost = 40000000;
	}
}

class Carnival extends Car {
	public Carnival() {
		this.carname = "c";
		super.cost = 50000000;
	}
}

public class InheritanceExam {
	// 메인메소드에서
	public static void main(String[] args) {
		Car c1 = new Car();
		EfSonata c2 = new EfSonata();
		Excel c3 = new Excel();
		Carnival c4 = new Carnival();

		System.out.println("c1의 주소값 : " + c1);
		System.out.println("c2의 주소값 : " + c2);
		System.out.println("c3의 주소값 : " + c3);
		System.out.println("c4의 주소값 : " + c4);

		c1.printAttributes();
		c2.printAttributes();
		c3.printAttributes();
		c4.printAttributes();
		// Car, EfSonata, Excel, Canival 네개의 객체를 생성
		// 각 클래스에서 Car calss에있는 printAttributes()메소드를 호출할수있다.
	}

}
