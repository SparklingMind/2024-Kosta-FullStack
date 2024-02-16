package ex0216.chat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 키보드 입력을 받아서 상대 측에게 데이터 전송하기
 */
public class SendThread extends Thread {
    Socket sk;

    public SendThread(Socket sk, String name) {
        super(name);
        this.sk = sk;
    }

    @Override
    public void run() {
        // 키보드 입력 받기
        Scanner sc = new Scanner(System.in);
        try (PrintWriter pw = new PrintWriter(sk.getOutputStream(), true)) {
            while (true) {
                String inputData = sc.nextLine();
                // "exit" 입력 시 반복 종료
                if (inputData.equals("exit")) {
                    pw.println(inputData); // 여기서 "inputData"가 아닌 변수 inputData의 값을 전송해야 합니다.
                    break;
                } else {
                    // 상대 측에 전송
                    pw.println(getName() + "가 보낸 내용 : " + inputData); // 여기서는 super.getName() 대신 getName()을 사용하고, 메소드 호출이므로 괄호가 필요합니다.
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close(); // Scanner를 닫아주는 것이 좋습니다. 하지만 System.in을 닫는 것은 다른 부분에 영향을 줄 수 있으므로 신중해야 합니다.
        }
    }
}
