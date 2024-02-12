package ex0131.superEx;

class Parent {

    // Parent() {
    // System.out.println(1);
    // }

    Parent(int i) {
        System.out.println(2);
    }

    Parent(String s) {
        System.out.println(s);
    }
}

class Child extends Parent { // Child is a Parent 성립.(폴리모피즘)
    Child() {
        this(4); // 현재 객체의 int형 한 개 받는 생성자 호출.
        System.out.println(4);
    }

    Child(int i) {
        super(i); // 부모의 int형 하나 받는 생성자 호출.
        // super(); //생략 가능
        System.out.println(5);
    }

    Child(boolean b) {
        super("하이");
        System.out.println(6);
    }
}

public class SuperConstructorExam {
    public static void main(String[] args) {
        // new Child(); //1,4
        // new Child(5); //1,5
        // new Child(true); //1,6

        // 결론 : 자식생성자 구현부 첫 번째 줄에는 super()이 생략되어 있다.
        // 부모의 기본생성자를 호출한다.
        // 만약, 부모의 생성자 하나도 없다면...-> 그래도 기본 생성자 super()가 암묵적으로 자동 삽입된다.
        new Child(); // 4
        new Child(5); // 5
        new Child(true); // 6
        // 결론 : 생성자를 하나도 작성하지 않으면 기본생성자는 자동 삽입 되어진다.
        // 만약, 부모의 기본생성자는 없고 인수 있는 생성자만 존재한다면
    }
}
