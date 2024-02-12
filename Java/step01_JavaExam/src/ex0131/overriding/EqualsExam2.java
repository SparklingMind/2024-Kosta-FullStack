package ex0131.overriding;

class EqualsExam2 {
    String stringObject;

    public EqualsExam2(String s) {
        stringObject = s;
    }

    public boolean equals(Object obj) { // obj = ee2
        if (obj instanceof EqualsExam2) {
            EqualsExam2 ee = (EqualsExam2) obj;
            if (stringObject.equals(ee.stringObject)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        System.out.println("\nEqualsExam ee1 = new EqualsExam(\"Object.equals()\");");
        System.out.println("\nEqualsExam ee2 = new EqualsExam(\"Object.equals()\");");

        EqualsExam2 ee1 = new EqualsExam2("Object.equals()");
        EqualsExam2 ee2 = new EqualsExam2("Object.equals()");

        if (ee1.equals(ee2)) { // 주소값비교 //false
            System.out.println("ee1.equals(ee2) = true");
        } else {
            System.out.println("ee1.equals(ee2) = false");
        }

        if (ee1 == ee2) { // 주소값비교 //false
            System.out.println("(ee1 == ee2) = true");
        } else {
            System.out.println("(ee1 == ee2) = false");
        }

        System.out.println("\nString s1 = \"new String Object1\";");
        System.out.println("\nString s2 = \"new String Object1\";");

        String s1 = "new String Object1";
        String s2 = "new String Object1";

        if (s1.equals(s2)) { // 문자열비교 //true
            System.out.println("s1.equals(s2) = true");
        } else {
            System.out.println("s1.equals(s2) = false");
        }

        if (s1 == s2) { // 주소값비교 //!!!!자바에서 문자열 리터럴은 같은 문자열에 대해 하나의 인스턴스를 재사용. 따라서 s1과 s2는 같은 문자열 리터럴을
                        // 참조하므로 같은 주소를 가지게 됨!!!!
            System.out.println("(s1==s2) = true");
        } else {
            System.out.println("(s1==s2) = false");
        }

        System.out.println("\nString s3 = new String(\"new String Object2\");");
        System.out.println("\nString s4 = new String(\"new String Object2\");");

        String s3 = new String("new String Object2");
        String s4 = new String("new String Object2");

        if (s3.equals(s4)) { // 문자열비교 //true
            System.out.println("s3.equals(s4) = true");
        } else {
            System.out.println("s3.equals(s4) = false");
        }

        if (s3 == s4) { // 주소값비교 //false
            System.out.println("(s3==s4) = true");
        } else {
            System.out.println("(s3==s4) = false");
        }

        System.out.println("\nString s5 = new String(\"new String Object3\");");
        System.out.println("\nString s6 = \"new String Object3\";");
        System.out.println("\nString s7 = \"new String Object3\";");

        String s5 = new String("new String Object3");
        String s6 = "new String Object3";
        String s7 = "new String Object3";

        if (s5.equals(s6)) { // 문자열비교 //true
            System.out.println("s5.equals(s6) = true");
        } else {
            System.out.println("s5.equals(s6) = false");
        }

        if (s5 == s6) { // 주소값비교 //false
            System.out.println("(s5==s6) = true");
        } else {
            System.out.println("(s5==s6) = false");
        }

        if (s6.equals(s7)) { // 문자열 비교 //true
            System.out.println("s6.equals(s7) = true");
        } else {
            System.out.println("s6.equals(s7) = false");
        }

        if (s6 == s7) { // 주소값비교 //!!String타입은 new키워드를 이용해 새로 생성한 경우가 아니라면 문자열 재사용!!=>같은 곳을 가리킴. 주소 같음.
            System.out.println("(s6==s7) = true");
        } else {
            System.out.println("(s6==s7) = false");
        }
    }
}
