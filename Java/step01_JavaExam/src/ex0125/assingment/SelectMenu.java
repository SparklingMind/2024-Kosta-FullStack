package ex0125.assingment;

/**
 * while문과 Scanner의 nextLine() 메소드를 이용하여, 
 * 키보드로부터 입력된 데이터로 예금, 출금, 조회, 종료 기능을 제공하는 코드를 작성.
 */
import java.util.Scanner;

public class SelectMenu {
    public static void main(String[] args) {
        int balance = 0; // 잔고를 저장할 변수
        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("---------------------------------------------");
            System.out.println("1. 예금  | 2. 출금  | 3.잔고  | 4. 종료  ");
            System.out.println("---------------------------------------------");
            System.out.print("선택> ");

            int selectNum = Integer.parseInt(sc.nextLine());

            switch (selectNum) {
                case 1:
                    System.out.print("예금액> ");
                    int deposit = Integer.parseInt(sc.nextLine());
                    balance += deposit;
                    System.out.println("예금이 완료되었습니다.");
                    break;
                case 2:
                    System.out.print("출금액> ");
                    int withdrawal = Integer.parseInt(sc.nextLine());
                    if (withdrawal <= balance) {
                        balance -= withdrawal;
                        System.out.println("출금이 완료되었습니다.");
                    } else {
                        System.out.println("잔고가 부족합니다.");
                    }
                    break;
                case 3:
                    System.out.println("잔고 > " + balance);
                    break;
                case 4: // 종료
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                // return 키워드가 사용되면, 현재 메소드의 실행을 즉시 종료하고 메소드를 호출한 곳으로 돌아감.
                // 만약 이 return이 메인 메소드 (main) 내부에서 호출되면, 프로그램 자체가 종료됨.
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                    break;

            }

        }
    }
}
