package ex0201.final_abstract;

/**
 * 모든 동물들이 갖는 공통의 속성과 메소드
 */

abstract class Animal {
    int legs; // 공통의 필드 = 속성

    public void eat() {
        System.out.println("고기를 좋아한다.");
    }

    public abstract void sound();

    public abstract void run();

}

////////////////////////////////////////////////
class Cat extends Animal {

    @Override
    public void sound() {
        System.out.println("야옹~");
    };

    public void run() {
        System.out.println("잘 뛰고 높은 곳도 잘 올라간다.");
    };
}

/////////////////////////////////////////////////
class Pig extends Animal {

    @Override
    public void sound() {
        System.out.println("꿀꿀~");
    };

    public void run() {
        System.out.println("잘 못 뛴다...");
    };
}

/////////////////////////////////////////////////
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }

    @Override
    public void run() {
        System.out.println("잘 달린다...");
    }
}

///////////////////////////////////////////////

public class AbstractSample {
    public static void main(String[] args) {
        Animal an = null; // 필드를 이용한 다형성
        an = new Cat();
        test(an);

        an = new Pig();
        test(an);

        test(new Dog());
    }

    public static void test(Animal an) { // 매개변수를 이용한 다형성
        System.out.println("---------------------------------");
        an.eat();
        an.sound();
        an.run();
    }
}