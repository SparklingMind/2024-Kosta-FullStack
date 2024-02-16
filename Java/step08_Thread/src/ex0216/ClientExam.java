package ex0216;

import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClientExam {
    public ClientExam() {
        // 서버에 접속
        try(Socket sk = new Socket("192.168.0.22", 8000)){ // 127.0.0.1은 localhost를 의미
            // 서버에 데이터를 전송하기 위한 PrintWriter 생성
            PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
            // 서버에 메시지 전송
            pw.println("왜 나는 안 연결시켜주나요?");

            // 서버로부터 데이터를 읽기 위한 BufferedReader 생성
            BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            // 서버가 보낸 데이터 읽기
            String response = br.readLine();
            System.out.println("서버로부터의 데이터: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ClientExam();
    }
}
