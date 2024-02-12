
package ex0131;

class CarCenter {
	public void engineer(Car cd) {
		System.out.println("cd 주소 = " + cd);
		// System.out.println("cd.color " + cd.color);// 접근불가.(부모타입으로는 자식부분 접근 불가.) =>
		// 부모타입을 자식타입으로 형변환해야 함.

		if (cd instanceof Excel) {// cd가 excel타입인지 체크.
			// 자식 부분을 접근하기 위해서는 ObjectDownCasting이 필요하다. !!상속관계일 때는 Object type들도 형변환이
			// 가능하다!!
			// 부모 > 자식 (개념적으로)
			Excel e = (Excel) cd; // ObjectDownCasting
			System.out.println("e.color = " + e.color);
			System.out.println("e 주소 = " + e);
		}

		System.out.print(cd.carname + " 수리완료!\t");
		System.out.println("청구비용" + cd.cost + " 원");

	}
}

public class PolymorphismExam {
	public static void main(String[] args) {

		CarCenter cc = new CarCenter();
		EfSonata ef = new EfSonata();
		Carnival ca = new Carnival();
		Excel ex = new Excel();

		Car c = new Car();

		System.out.println("ex주소 = " + ex);
		System.out.println("ex.color = " + ex.color);
		cc.engineer(c);//
		cc.engineer(ef);// 폴리모피즘 성립. EfSonata는 car이다. 그러나 cc는 인수로 ef를 car로서 불렀기 때문에 ef의 car상속영역밖에 접근하지
						// 못한다.
		cc.engineer(ca);//
		cc.engineer(ex);//

	}
}
