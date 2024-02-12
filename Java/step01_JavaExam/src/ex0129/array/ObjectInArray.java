package ex0129.array;

//ObjectInArray.java

class ObjectOne {
    public int a;
}

public class ObjectInArray {
    public static void main(String[] args) {
        // 메인 메소드에서

        // ObjectOne 타입을 5개 까지 저장하는 배열을 선언하고

        ObjectOne[] obArr = new ObjectOne[5]; // objectOne을 생성한 것이 아니라 배열을 생성한 것.
        System.out.print("배열의 주소 : " + obArr);
        System.out.println();
        // 5개의 ObjectOne객체를 생성하세요.
        // 각 객체가 갖고있는 전역변수 출력
        // 각 객체의 주소값 출력

        // 각각의 ObjectOne객체가 서로 다른 a의 값을 갖도록 a의 값을 변경하세요.
        // 각 ObjectOne 객체의 a를 출력하세요

        for (int i = 0; i < obArr.length; i++) {
            System.out.print("생성전 arr[" + i + "] = " + obArr[i] + "\t"); // 객체 생성 전이므로 주소값이 null로 비어있다.
            obArr[i] = new ObjectOne();
            System.out.print("생성후 arr[" + i + "] = " + obArr[i] + "\t");
            obArr[i].a = i;
            System.out.print("생성후 arr[" + i + "].a = " + obArr[i].a + "\t");
            System.out.println();
        }

        for (ObjectOne ob : obArr) {
            System.out.print(ob.a);
            System.out.println();

        }

    }
}
