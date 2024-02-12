package ex0130.Constuctor;

//ConstructorExam.java
class Puppy {
    // String,int 타입 전역 변수 선언(member 변수선언)
    String name;
    int age;

    /*
     * 메소드 printPuppyName작성
     * 인수없음, 리턴안함
     * "public void printPuppyName() 호출되었습니다!"출력
     * 전역변수를 출력
     */
    public void printPuppyName() {
        System.out.println("public void printPuppyName() 호출되었습니다!");
        System.out.print(name + " " + age + "살");

    }

    /*
     * 인수가 없는 생성자 작성
     * 출력
     * printPuppyName메소드 호출
     * 전역변수 String에"메리" 할당
     * 전역변수 int에 -98998 할당
     */
    public Puppy() {
        System.out.println("생성자 public Puppy() 호출되었습니다!");
        this.printPuppyName();
        this.name = "래브";
        this.age = 5;
        System.out.println();
    }
}

class ConstructorExam {
    // 메인메소드에서
    public static void main(String[] agrs) {
        // Puppy객체 생성
        Puppy p1 = new Puppy();
        // Puppy객체의 printPuppyName메소드 호출
        p1.printPuppyName();
    }
}
