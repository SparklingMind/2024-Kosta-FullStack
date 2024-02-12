package ex0126.assignment;

import java.util.Scanner;

/**
 * 학생 수와 각 학생들의 점수를 입력받아서 최고 점수 및 평균 점수를 구하는 프로그램.
 */
class ScoreAnalyzer {
    public static void main(String[] args) {
        boolean run = true;
        int studentNum = 0;
        int[] scores = null; // scores 배열은 아직 어떤 실제 배열도 참조하지 않고 있음.
        Scanner sc = new Scanner(System.in);

        while (run) {
            System.out.println("------------------------------------------------------------------");
            System.out.println(" 1. 학생 수   | 2. 점수 입력 | 3. 점수 리스트 | 4. 분석 | 5. 종료");
            System.out.println("------------------------------------------------------------------");
            System.out.print("선택 > ");
            int selectNo = sc.nextInt();
            System.out.println();

            if (selectNo == 1) {
                System.out.print("학생 수 입력 : ");
                studentNum = sc.nextInt();
                scores = new int[studentNum];
            } else if (selectNo == 2) {
                System.out.println("점수 입력");
                for (int i = 0; i < studentNum; i++) {
                    System.out.printf("scores[%d] : ", i);
                    scores[i] = sc.nextInt();
                }

            } else if (selectNo == 3) {
                for (int i = 0; i < studentNum; i++) {
                    System.out.printf("scores[%d] : %d점", i, scores[i]);
                    System.out.println();
                }
            } else if (selectNo == 4) {

            } else if (selectNo == 5) {
                run = false;
            } else {
                System.out.println("잘못된 입력값입니다.");
            }

        }
        System.out.println("프로그램 종료");
    }
}