package ex0125.assingment;

import java.util.Scanner;

class Calculator2 {
    public void operation(int a, int b, int menuOption) {
        switch (menuOption) {
            case 1:
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case 2:
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case 3:
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            case 4:
                if (b != 0) {
                    System.out.println(a + " / " + b + " = " + ((double) a / b));
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                break;
            default:
                System.out.println("숫자를 잘못 입력했습니다.");
        }
    }
}

public class CalculatorTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("******** 1. 더하기    2. 빼기   3. 곱하기    4. 나누기    9. 종료 ********  ");
            System.out.print("메뉴 선택 >  ");
            int menuOption = scanner.nextInt();

            if (menuOption == 9) {
                System.out.println("계산기를 종료합니다...");
                System.exit(0);
            }

            System.out.print("첫 번째 정수를 입력하세요: ");
            int num1 = scanner.nextInt();
            System.out.print("두 번째 정수를 입력하세요: ");
            int num2 = scanner.nextInt();

            Calculator2 calculator2 = new Calculator2();
            calculator2.operation(num1, num2, menuOption);

        }

    }
}