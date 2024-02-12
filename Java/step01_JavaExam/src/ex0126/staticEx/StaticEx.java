package ex0126.staticEx;

class Test {
    int i = 10; // 인스턴스필드(객체가 생성될 때 만들어진다.)
    static int j = 5; // static 필드(객체생성과 상관없이 하드웨어에 클래스가 로더 될 때 자동으로 메모리 만들어진다.)

    public void aa() { // non-static 메소드 안에서는 static, non-static 모두 접근 가능
        System.out.println(i);
        System.out.println(this.i);
        System.out.println(j);
        System.out.println(this.j);
        System.out.println(Test.j);
    }

    public void bb() {
        // 메소드 호출
        aa();
        this.aa();

        cc();
        this.cc();
    }

    public static void cc() { // static 메소드 안에서 non-static 접근 불가. this 사용 안 됨.
        // System.out.println(i);
        // System.out.println(this.i);
        System.out.println(j);
        // System.out.println(this.j);
        System.out.println(Test.j);

    }

    public static void dd() {
        // aa();
        // this.aa();

        cc();
        // this.cc();
    }

    /**
     * staic 초기화 작업, 초기 환경 세팅. 클래스 내부의 어딘가에만 선언되면 된다.
     */

}

public class StaticEx {
    public static void main(String[] args) {
        System.out.println("-----------메인시작합니다---------------");
        Test t1 = new Test();
        Test t2 = new Test();
        Test t3 = new Test();

        System.out.println("-----------인스턴스 필드 접근-----------");
        System.out.println("주소값 t1 : " + t1);
        System.out.println("주소값 t2 : " + t2);
        System.out.println("주소값 t3 : " + t3);

        System.out.println(t1.i);
        System.out.println(t2.i);
        System.out.println(t3.i);

        System.out.println("--------static필드 값 변경 전------------");

        System.out.println();

        System.out.println("--------static필드 값 변경 후------------");
        // 값변경
        t1.i = 50;

    }

    static {
        System.out.println("static init은 메인보다 먼저 실행됩니다. 이렇게요. ");
    }
}
