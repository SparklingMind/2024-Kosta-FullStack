package ex0216.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientChatExam {
	public ClientChatExam() {
		try{
			Socket sk = new Socket("127.0.0.1", 9000);
			System.out.println("서버와 채팅을 시작합니다...");
			
			//보내는 스레드
			new SendThread(sk, "Client").start();
			//받는 스레드
			new Thread(()->{
				try (BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()))) {
	                String read;
	                while ((read = br.readLine()) != null) {
	                    if (read.equals("exit")) {
	                        System.out.println("클라이언트쪽 받는 스레드 종료합니다.");
	                        break;
	                    }
	                    System.out.println(read); //서버로부터 받은 메시지 출력
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }finally {
	        		System.out.println("클라이언트 스레드 종료하겠습니다...");
	            	System.exit(0);
	        		}
			}).start();
			
			
		}catch(Exception e) {
			
		}
	}
	public static void main(String[] args) {
		new ClientChatExam();
	}
}
