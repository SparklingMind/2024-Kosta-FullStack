package ex0129.array;

class MultiArray {
    // 정수형 2차원 배열 8*9
    int[][] arr = new int[8][9];

    // 메소드이름 :array99
    // for loop 를 사용하여
    // 배열에 곱한 (구구단)결과저장
    // 배열에 결과를 꺼내출력
    public void array99() {
        int rowLen = arr.length;
        for (int i = 0; i < rowLen; i++) {
            int colLen = arr[i].length;
            for (int j = 0; j < colLen; j++) {
                arr[i][j] = (i + 2) * (j + 1);
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        // for (int row : arr.length) {
        // for(int col : arr[].length ){

        // }
        // }
    }

}

public class MemoryApart {
    public static void main(String[] args) {
        new MultiArray().array99();
    }
    // main메소드에서
    // MultiArray객체의 array99메소드호출
}
