package ex0129.array.assingment;

//TwoDmArrayExam.java

class TwoDmArray {
    // String을 저장하는 twoDmArray 배열선언
    String[][] aptArr;

    // 메소드 make2DmArray
    // twoDmArray 배열에 값을 할당
    public void make2DmArray() {
        aptArr = new String[10][];
        for (int i = 0; i < aptArr.length; i++) {
            aptArr[i] = new String[i + 1];
            for (int j = 0; j < aptArr[i].length; j++) {
                aptArr[i][j] = (i + 1) + "동" + " " + (j + 1) + "호";
                System.out.print(aptArr[i][j] + " ");
            }
            System.out.println();

        }
    }

    public void print2DmArray() {
        for (int i = aptArr.length - 1; i >= 0; i--) {
            // 필요한 만큼의 탭을 출력
            for (int j = aptArr.length - 1; j > i; j--) {
                System.out.print("\t");
            }
            // 각 항목을 출력
            for (int j = 0; j <= i; j++) {
                System.out.print(aptArr[i][j] + "\t");
            }
            System.out.println();
        }
    }
    // 메소드 print2DmArray
    // twoDmArray 배열의 값을 주어진형식으로 출력
    // public void print2DmArray() {
    // int len = aptArr.length;
    // for (int j = 0; j < len; j++) {
    // for (int k = 0; k < j; k++) {
    // System.out.print("\t");
    // }
    // for (int i = j; i < len; i++) {
    // System.out.print(aptArr[i][j] + "\t");
    // }
    // }
    // }
}

public class TwoDmArrayExam {
    // main메소드에서
    // TwoDmArray객체생성
    // TwoDmArray객체의 make2DmArray메소드 호출
    // TwoDmArray객체의 print2DmArray메소드 호출
    public static void main(String[] args) {
        TwoDmArray twoDmArray = new TwoDmArray();
        twoDmArray.make2DmArray();
        twoDmArray.print2DmArray();
    }
}