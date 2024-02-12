package ex0201.final_abstract;

class Test {
    final int age; // 반드시 초기화 필수 (명시적 초기화 or 생성자를 이용한 초기화)

    static final int pie = 3; // 생성자에서 초기화 못 함. 명시적 초기화 or static 블럭에서 초기화 가능 = contant = 상수

    Test(int age) {
        this.age = age; // 생성자를 이용해서 final필드를 초기화.
    }
}

public class FinalConstantExam {
    public static void main(String[] args) {
        // Test t = new Test();
        // System.out.println("t.age = " + t.age);
        // //t.age = 30; final 필드이므로 값변경 불가.

        Test t = new Test(20);
        System.out.println("t.age = " + t.age);

        Test t2 = new Test(30);
        System.out.println("t2.age = " + t2.age);
    }
}
