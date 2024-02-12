package ex0126.overloading;

public class VariableArgsExam {
    public void test(int... i) { // 0개 이상의 int형인수를 허용한다.
        System.out.println(i); // 배열로 처리
    }

    public void test2(String name, int... i) { // ...은 마지막 인수에만 사용가능하다. 어디까지 사용할지 모르기 때문이다.

    }

    public static void main(String[] args) {
        // 메인메소드는 static이기 때문에 같은 클래스 내라도, 다른 메소드에 객체 생성없이 접근하지 못한다.
        VariableArgsExam va = new VariableArgsExam();
        va.test(5);
        va.test(6, 1, 2);
        va.test(12, 5, 6, 2, 6, 2); // 결과가 배열의 주소값으로 출력된다.

        // va.test(3.2); //인수의 타입이 맞지 않는 메소드가 있으면 처리가 불가하다.
    }
}
