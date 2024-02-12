package ex0129.array;

/**
 * 학생의 정보를 관리하는 서비스(등록, 수정, 검색, ...)
 */
public class StudentService {
    private Student stArr[] = new Student[5];
    private int count; // 배열방에 저장된 객체의 개수 체크해주기 위한 변수. int 초기값 0;

    /**
     * 초기치 데이터 3명 정도 세팅하기
     */
    public void init() {
        stArr[count++] = this.create("다희", 33, "성남");
        stArr[count++] = this.create("채린", 12, "강동");
        stArr[count++] = this.create("지훈", 28, "강서");

    }

    /**
     * Student 객체를 생성해서 리턴해주는 메소드 작성
     */
    private Student create(String name, int age, String addr) {
        Student st = new Student();
        // stArr[0].name = "다희"; //private 이므로 접근 불가, setXxx로 접근해야한다.
        st.setName(name);
        st.setAge(age);
        st.setAddr(addr);

        return st;
    }

    /*
     * 학생의 정보 등록하기
     * : 배열의 경계를 벗어나면 더 이상 추가할 수 없습니다. 메세지 출력.
     * 추가가 성공하면 "등록되었습니다." 메시지를 출력한다.
     */
    public void insert(Student st) { // 이름, 나이, 주소 // 배열방에 인수로 전달된 학생 정보를 추가한다.
        if (count >= stArr.length) {
            System.out.println("더 이상 추가할 수 없습니다.");
        } else {
            stArr[count] = st;
            count++;
            System.out.println("등록되었습니다.");
        }
    }

    /**
     * 전체 학생의 정보 조회하기
     */
    public void selectAll() {
        System.out.println("----전체 학생 정보 조회----(" + count + "명)--------------");
        for (int i = 0; i < count; i++) {
            System.out.print("이름 : " + stArr[i].getName() + "\t");
            System.out.print("나이 : " + stArr[i].getAge() + "\t");
            System.out.print("주소 : " + stArr[i].getAddr() + "\n");
        }
    }

    /**
     * 이름에 해당하는 학생의 정보 검색하기
     * :이름에 해당하는 학생이 있으면 학생의 이름, 나이, 주소를 출력하고
     * 없으면 "찾는 정보가 없습니다."를 출력한다.
     */
    public void selectByName(String name) {

        for (int i = 0; i < count; i++) {
            if (stArr[i].getName().equals(name)) {// equals메서드 : 왼쪽 문자열과 인수의 문자열이 같으면 true, 아니면 false return
                // if (name.equals(stArr[i].getName())) { //인수.equals는 인수가 잘못됐을 가능성이 있어 권장되지
                // 않는다.
                System.out.println(
                        "이름: " + stArr[i].getName() + ", 나이: " + stArr[i].getAge() + ", 주소: " + stArr[i].getAddr());
                // break; //break은 for문을 빠져나간다.
                return; // return의 뜻 : 함수를 빠져나가라. 함수의 리턴값이 void든 다른 자료형이든 상관없다.
            }
        }

        System.out.println("찾는 정보가 없습니다.");

    }

    /**
     * 이름에 해당하는 학생의 나이와 주소 변경하기
     * : 이름에 해당하는 학생이 있는지 찾아서 없으면 "수정할 수 없습니다." 출력
     * 있으면 setAge(), setAddr() 이용해서 전달된 인수의 값으로 변경하고
     * "수정되었습니다" 출력
     */

    public void update(Student student) {

        for (int i = 0; i < count; i++) {
            if (stArr[i].getName().equals(student.getName())) { // 해당 객체의 이름으로 학생 검색.
                // 찾은 객체의 정보를 전달된 정보로 변경
                stArr[i].setAge(student.getAge());
                stArr[i].setAddr(student.getAddr());

                System.out.println("수정되었습니다.");
                return;
            }
        }

        System.out.println("학생을 찾을 수 없어, 수정할 수 없습니다.");
    }
}
