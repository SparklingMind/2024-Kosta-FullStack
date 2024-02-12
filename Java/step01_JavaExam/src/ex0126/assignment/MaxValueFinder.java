package ex0126.assignment;

/**
 * 주어진 배열의 항목에서 최댓값을 구한다.
 */

public class MaxValueFinder {
    public static void main(String[] args) {
        int max = 0;
        int[] array = { 1, 5, 3, 8, 2 };
        int arrLen = array.length;
        for (int i = 0; i < arrLen; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println("max : " + max);
    }
}
