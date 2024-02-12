package ex0125.assingment;

/**4. 
   클래스를 만들고  그 안에 두개의 정수와 사칙연산기호-(+ , - , *, / )(String)  를 받는 메소들 만든다.
     : 그 메소드안에서 두 사칙연산기호에 따라 연산을 결과를 출력한다. 
       만약, 연산기호가 잘못되면 "연산기호가 잘못되었습니다." 출력
    
 (조건, 사칙연산을 하는 메소드와  메인메소드가 있는 클래스는 다르게 선언한다)
          키보드 입력으로 두개의 정수와 연산기호를 입력받아 메소드의 인수로 전달한다. */
import java.util.Scanner;

// 사칙연산을 수행하는 Calculator 클래스
class Calculator {
    public void Operation(int a, int b, String operator) {
        switch (operator) {
            case "+":
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case "-":
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case "*":
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            case "/":
                if (b != 0) {
                    System.out.println(a + " / " + b + " = " + ((double) a / b));
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                break;
            default:
                System.out.println("연산기호가 잘못되었습니다.");
        }
    }
}

// 메인 클래스
public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번째 정수를 입력하세요: ");
        int num1 = scanner.nextInt();
        System.out.print("두 번째 정수를 입력하세요: ");
        int num2 = scanner.nextInt();
        System.out.print("연산기호(+, -, *, /)를 입력하세요: ");
        String operator = scanner.next();

        Calculator calculator = new Calculator();
        calculator.Operation(num1, num2, operator);
    }
}
