package ex0205;

class Test {
    public void aa(int i) throws ArithmeticException {
        System.out.println("Test aa() 호출됨......");
        this.bb(i); // try-catch 블록 없이 bb 메서드 호출. bb에서 예외 처리됨.
        System.out.println("Test aa() 호출끝......");
    }
    
    public void bb(int i) throws ArithmeticException {
        System.out.println("Test bb() 호출됨......");
        try {
            int result = 100/i; // ArithmeticException 가능성이 있는 부분.
            System.out.println("나눈 결과 = " + result);
        } catch (ArithmeticException e) {
            e.printStackTrace(); // 예외 발생 시 스택 추적 출력
        } finally {
            System.out.println("Test bb() 호출끝......"); // 항상 출력
        }
    }
}

public class ThrowsExceptionExam {
    public static void main(String[] args) {
        System.out.println("----메인 시작합니다.----");
        
        Test test = new Test(); // Test 객체 생성
        try {
            test.aa(0); // aa 메서드 호출, 0으로 나누어 예외 발생 가능
        } catch (ArithmeticException e) {
            // aa 메서드 내부에서 예외가 처리되므로 이 블록은 실행되지 않음
        }
        
        // bb 메서드는 이미 자신의 내부에서 예외를 처리하므로 별도의 try-catch 블록 필요 없음
        
        
        System.out.println("----메인 끝 입니다.----");
    }
}
