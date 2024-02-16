package ex0216.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChatExam {
    Socket sk;

    public ServerChatExam() {
        try (ServerSocket server = new ServerSocket(9000)) {
            System.out.println("클라이언트 접속 대기중...");
            sk = server.accept();

            // 클라이언트로부터 데이터를 읽기 위한 스레드 실행
            new ServerReceiveThread().start();

            // 클라이언트에게 데이터를 보내는 스레드 실행
            new SendThread(sk, "SERVER").start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServerChatExam();
    }

    /**
     * 클라이언트로부터 데이터를 읽는 내부 클래스
     */
    class ServerReceiveThread extends Thread {
        public void run() {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()))) {
                String read;
                while ((read = br.readLine()) != null) {
                    if (read.equals("exit")) {
                        System.out.println("서버 받는 스레드 종료합니다.");
                        break;
                    }
                    System.out.println(read); // 클라이언트로부터 받은 메시지 출력
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
            	System.out.println("서버 스레드 종료하겠습니다...");
            	System.exit(0);
            }
            
        }
    }
}
