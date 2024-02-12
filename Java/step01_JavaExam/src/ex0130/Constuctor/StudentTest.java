package ex0130.Constuctor;

public class StudentTest {
    public static void main(String[] args) {
        System.out.println("***학생관리 프로그램 시작합니다.***");
        StudentService service = new StudentService();
        // service.init(); // 초기치 데이터 세팅 => 기본생성자로 처리

        // 전체학생정보 출력
        System.out.println("--전체 학생 정보 출력--");
        service.selectAll();

        // 등록하기
        System.out.println("--새 학생 등록--");
        Student newStudent = new Student("쥬쥬", 22, "뉴욕");
        service.insert(newStudent);

        service.selectAll();
        // 이름으로 검색하기
        System.out.println("--이름으로 검색--");
        service.selectByName("다희");

        // 수정하기 (이름에 해당하는 주소를 변경하자.)
        System.out.println("--수정하기--");
        Student updateStudent = new Student("지훈", "은평");
        service.update(updateStudent);

        service.selectAll();
    }
}
