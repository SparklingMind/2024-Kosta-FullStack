package ex0131.superEx;

class Animal {
    int a = 10;
    int b = 5;

    public void aa() {
        System.out.println("super의 aa() call....");
    }

    public void bb() {
        System.out.println("super의 bb() call");
    }

}

class Cat extends Animal { // Cat is Animal 성립, Cat is Object 성립. Animal a = new Cat();과 같은 식은 접근 제한이 따른다.
    int a = 20;
    int c = 7;

    /*
     * 재정의 (@annotation) 꼭 필요한 것은 아니지만,
     * 1. 컴파일러가 오버라이딩한 메소드라는 것을 바로 파악해서 성능이 좋아진다.
     * 2. 다른 사람에게도 가독성이 좋다.
     */

    @Override
    public void aa() {
        System.out.println("Sub의 aa() call...");
        // System.out.println("a = " + a); // 20
        // System.out.println(("this.a = " + this.a)); // 20
        // System.out.println("super.a = " + super.a); // 10

        // System.out.println("b = " + b); //5
        // System.out.println(("this.b = " + this.b)); //5
        // System.out.println("super.b = " + super.b); //5

        // System.out.println("c = " + c); // 20
        // System.out.println(("this.c = " + this.c)); //20
        // System.out.println("super.c = " + super.c);
    }

    public void cc() {
        System.out.println("Sub의 cc() call...");
    }

    public void test() {
        // 메소드 호출
        // aa() 메소드는 재정의 되었다!!!(부모,자식에 존재)
        aa();
        this.aa();
        super.aa();

        System.out.println("bb는 부모쪽에만 존재하는 메서드");
        bb();
        this.bb();
        super.bb();

        System.out.println("cc는 자식쪽에만 존재하는 메서드");
        cc();
        this.cc();
        // super.cc(); //자식 쪽에만 있어서 불가
    }
}

public class SuperKeywordExam {
    public static void main(String[] args) {
        // new Cat().aa();
        // new Cat().test();

        Cat cat = new Cat();
        System.out.println("cat 주소 = " + cat);
        System.out.println("cat.a = " + cat.a);
        System.out.println("act.b = " + cat.b);
        System.out.println("cat.c = " + cat.c);

        System.out.println("========메소드 호출=========");
        cat.aa(); // Sub
        cat.bb(); // Super
        cat.cc(); // Sub
        System.out.println("----------------------------------");
        Animal animal = new Cat(); // 필드를 이용한 다형성
        System.out.println("Animal 주소 = " + animal);
        System.out.println("animal.a = " + animal.a); // 10
        System.out.println("animal.b = " + animal.b); // 5
        // System.out.println("animal.c = " + animal.c); //불가

        System.out.println("========메소드 호출=========");
        animal.aa();/* 재정의된 메소드는 부모타입이라도 반드시 재정의된 메소드가 호출된다. */
        animal.bb(); // Super
        // animal.cc(); // 부모타입으로는 접근 불가
        // 자식 쪽에 있는 필드나 메소드는 접근하기 위해서 캐스팅이 필요하다.
        Cat cat2 = (Cat) animal;

        if (animal instanceof Cat) {

            System.out.println("cat2 주소 = " + cat2);
            System.out.println("cat2.c = " + cat2.c);
            cat2.cc();
        }

    }
}