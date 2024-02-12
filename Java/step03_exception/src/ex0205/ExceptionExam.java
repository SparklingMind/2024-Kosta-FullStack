package ex0205;

public class ExceptionExam {
    public static void main(String[] args) {
        System.out.println("---메인 시작하기---");
//        System.out.println("args = " + args);
//        System.out.println("args.length = " + args.length);
//        if(args.length>0){
//            fpr(String s : args) {
//                System.out.println(s);
//            }
//        }
        try{
            String param =args[0];
            System.out.println("param = " + param);
        } catch (ArrayIndexOutOfBoundsException e) {
            //예외 발생했을 때 해야 할 일 작성
            System.out.println("e" + e);//e.toString()호출
        }

        System.out.println("---메인 끝---");
    }
}

/**
 * 실행 java ExceptionExam 값 값 값...
 */