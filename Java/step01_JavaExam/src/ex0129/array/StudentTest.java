package ex0129.array;

public class StudentTest {
    public static void main(String[] args) {
        System.out.println("***학생관리 프로그램 시작합니다.***");
        StudentService service = new StudentService();
        service.init(); // 초기치 데이터 세팅

        // 전체학생정보 출력
        System.out.println("--전체 학생 정보 출력--");
        service.selectAll();

        // 등록하기
        System.out.println("--새 학생 등록--");
        Student newStudent = new Student();
        newStudent.setName("쥬쥬");
        newStudent.setAge(22);
        newStudent.setAddr("뉴욕");
        service.insert(newStudent);

        service.selectAll();
        // 이름으로 검색하기
        System.out.println("--이름으로 검색--");
        service.selectByName("다희");
        // 수정하기
        System.out.println("--수정하기--");
        Student updateStudent = new Student();
        updateStudent.setName("지훈");
        updateStudent.setAge(29); // 나이 변경
        updateStudent.setAddr("은평"); // 주소 변경
        service.update(updateStudent);

        service.selectAll();
    }
}
