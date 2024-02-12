package ex0129.array;

public class MultiArrayExam {
    // int[][] arr = new int[3][4]; // 3행 4열
    // int [][] arr = new int[3][] //3행의 가변형 배열 선언. 열은 추후에 지정.

    // 생성과 동시에 명시적 초기화. 가변형(행마다 열의 길이가 다름) 배열.
    /*
     * int[][] arr = new int[][] {
     * { 1, 3, 5, 6 },
     * { 3, 5 },
     * { 1 },
     * { 3, 3, 6, 2, 5 }
     * };
     */

    int arr[][] = new int[3][];

    public void test() {
        arr[0] = new int[4];
        arr[1] = new int[] { 1, 3, 5, 7, 8, 1 };
        arr[2] = new int[] { 2, 4 };
        System.out.println("arr = " + arr); // 2차원 배열의 주소값
        System.out.println("arr[0] = " + arr[0]); // 1차원 배열의 주소값
        System.out.println("arr[0][0] = " + arr[0][0]); // 0
        System.out.println("arr.length = " + arr.length); // 3. 3 x 4 의 12개 아니고 행의 길이가 나온다.
        System.out.println("arr[0].length = " + arr.length); // 3
        System.out.println("-------------------------------------------------");
        /* 배열의 모든 값을 출력. */
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + "\t");
            }
            System.out.println();
        }

        // 개선된 for문으로 출력해보기
        for (int[] row : arr) {
            for (int col : row) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MultiArrayExam mae = new MultiArrayExam();
        mae.test();

        // new MultiArrayExam.test(); //굳이 변수에 담지 않고 한 번 메소드 사용할 거면 이런식으로 해도 된다.

    }
}
