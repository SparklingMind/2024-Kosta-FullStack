package ex0216;

public class DaemonThreadExam {

	public static void main(String[] args) {
		System.out.println("****메인 시작****");
		Runnable r = ()->{	
			//run 메소드에서 해야할 일 작성
			while(true) {
				System.out.println("데몬 스레드 작업 중...");
			}
		};
		
		Thread th = new Thread(r);
		th.setDaemon(true);
		th.start();

		//2초 후에 메인이 종료되면 스레드도 함께 종료하고 싶다. - 데몬 스레드로 만들자.
		try {
		Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("메인 종료");

	}

}
