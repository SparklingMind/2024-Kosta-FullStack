package ex0125.assingment;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 */
class RandomUtil {
    static void getRandomInt(int n1, int n2) { // java.lang.Math.random() 사용
        System.out.println("****Math.random()을 사용하여, 두 수 사이의 100개의 수를 랜덤으로 출력합니다.****");
        for (int i = 1; i <= 100; i++) {
            int ranNum = (int) (Math.random() * (n2 - n1 + 1)) + n1;
            System.out.print(ranNum + " ");
        }
        System.out.println();
    }

    static void getRandomInt2(int n1, int n2) { // java.util.Random.nextInt() 사용
        System.out.println("****Random.nextInt()를 사용하여 두 수 사이의 100개의 수를 랜덤으로 출력합니다.****");
        Random r = new Random();
        for (int i = 1; i <= 100; i++) {
            int ranNum = r.nextInt(n2 - n1 + 1) + n1;
            System.out.print(ranNum + " ");

        }
        System.out.println();
    }

}

public class RandomUtilTest {
    public static void main(String[] args) {
        int n1, n2;
        Scanner sc = new Scanner(System.in);
        System.out.println("두 수를 입력하세요.");
        System.out.print("첫 번째 수 : ");
        n1 = sc.nextInt();
        System.out.print("두 번째 수 : ");
        n2 = sc.nextInt();

        int min = Math.min(n1, n2);
        int max = Math.max(n1, n2);

        RandomUtil.getRandomInt(min, max);
        RandomUtil.getRandomInt2(min, max);
    }
}
