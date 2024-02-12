package ex0201.final_abstract;

//Error 를 수정하고 이유를 주석으로 처리하세요.

final class FinalClassExam { // 상속불가, 생성가능
    final int i = -999999; // 고정값, 초기화 필수, 값변경불가
}

abstract class AbstractClassExam { // 상속가능, 생성 불가
    abstract String abstractMethodExam(int i, String s); // 기능 없고 재정의 위한 메소드

    final int finalMethodExam(int i, int j) { // 재정의불가
        return i + j;
    }
}

class Sample01 extends AbstractClassExam {
    String abstractMethodExam(int i, String s) {
        System.out.println("return " + s + i);
        return s + i;
    }

    // int finalMethodExam(int i, int j) { //final제한자가 붙은 메서드는 오버라이딩(재정의)이 불가능하다.
    // return i * j;
    // }
}

// class Sample02 extends FinalClassExam {//final이 제한자가 있는 클래스는 상속할 수 없다.
// }

abstract class Sample03 extends AbstractClassExam {
    String abstractMethodExam(String s, int i) { // 오버로딩 중복 불가가
        return s + i;
    }

    abstract String abstractMethodExam(int i, String s); // abstract method를 가진
    // 클래스도 abstract 제한자가 붙어야 한다.

    void sampleMethod03() {
        System.out.println("void sampleMethod03() 호출 됨");
    }
}

public class AbstractFinalClassTest {
    public static void main(String args[]) {
        AbstractClassExam ace;/* new AbstractClassExam(); abstract는 객체 생성이 불가하고, 부모가 되기 위해 존재한다. */
        FinalClassExam fce = new FinalClassExam();
        // fce.i = 100000; // final 제한자가 붙은 변수는 변경 불가하다.
        Sample01 s01 = new Sample01();
        AbstractClassExam aceS01 = new Sample01();
        aceS01.abstractMethodExam(700, "_999");
    }
}
