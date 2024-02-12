package ex0125.assingment;

import java.util.Scanner;

class GradeCalculator {
    private int calculateTotalScore(int korean, int english, int math) {
        return korean + english + math;
    }

    private double calculateAverage(int totalScore, int subjectCount) {
        return totalScore / (double) subjectCount;
    }

    private char determineGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void printGradeReport(String name, int korean, int english, int math) {
        int totalScore = calculateTotalScore(korean, english, math);
        double average = calculateAverage(totalScore, 3);
        char grade = determineGrade(average);

        System.out.println("이름: " + name);
        System.out.println("총점: " + totalScore);
        System.out.println("평균: " + average);
        System.out.println("등급: " + grade);
    }
}

public class GradeProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. 성적표 구하기   2. 종료 ");
            System.out.print("선택 : ");
            int menuOption = sc.nextInt();
            String name;
            int koreanInput;
            int englishInput;
            int mathInput;
            GradeCalculator gc = new GradeCalculator();
            switch (menuOption) {
                case 1:
                    System.out.print("이름 : ");
                    name = sc.next();
                    System.out.print("국어 성적: ");
                    koreanInput = sc.nextInt();
                    System.out.print("영어 성적: ");
                    englishInput = sc.nextInt();
                    System.out.print("수학 성적: ");
                    mathInput = sc.nextInt();

                    gc.printGradeReport(name, koreanInput, englishInput, mathInput);

                    break;
                case 2:
                    System.out.println("프로그램 종료");
                    System.exit(0);
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }

    }
}