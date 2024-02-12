package ex0130.Constuctor;

/**
 * 싱글톤 패턴 클래스 만드는 방법
 * 1) private 생성자를 만든다.
 * 2) static 멤버 필드를 이용해서 객체를 새성
 * 3) 자기자신객체를 리턴해주는 static메서드 제공
 */
class Test {
    private static Test t = new Test();

    // private 생성자는 외부에서 객체를 직접 생성할 수 없도록 하는 것.
    private Test() {

    }

    /**
     * 자기자신 객체를 직접 생성해서 리턴해주는 메서드를 제공한다.
     */
    public static Test getInstance() { // 생성자에 private 붙어서 객체 생성을 못하는 상태이므로 당연히 static으로 해주어야 한다.
        return t;

    }
}

public class PrivateConstructorExam {
    public static void main(String[] args) {
        // new Test(); //생성자 직접 호출->private이므로 직접 생성 못 함.
        Test t1 = Test.getInstance();
        Test t2 = Test.getInstance();

        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);
    }
}
