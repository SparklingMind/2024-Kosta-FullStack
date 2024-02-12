package ex0129.array;

/**
 * 학생의 속성을 관리하는 객체
 * : VO(Value Object) = DTO(Data Transfer Object) = Domain
 */
public class Student {
    // 외부에서 직접 필드를 접근할 수 없다. =>get과 set 메서드를 제공.
    private String name;
    private int age;
    private String addr;

    /**
     * setXxx,getXxx 만들기
     */

    /**
     * setXxx()
     * 제한자 - public
     * 리턴타입 - void
     * 메소드 이름 - set + 필드이름 첫글자 대문자
     * 인수 : 있다.
     */

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 18) {
            this.age = age;
        }

    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * 제한자 - public
     * 리턴타입 - 있다.
     * 메소드 이름 - get + 필드이름 첫글자 대문자
     * 인수 - 없다
     */

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getAddr() {
        return this.addr;
    }
}
