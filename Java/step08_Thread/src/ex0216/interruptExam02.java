package ex0216;

public class interruptExam02 {

	public static void main(String[] args) {
		System.out.println("***메인 시작입니다...***");
		Thread th = new Thread(() -> { // 람다식. 재사용성은 떨어짐.
			try {
				while (true) {
					if(Thread.interrupted()) break;	//interrupt된 상태면 일시정지.
	/*
	 * 01번과 다르게 sleep이 없으므로 interrupted를 통해 break해줘야 interrupt 종료 가능하다.
	 */
					System.out.println("Thread 실행하고 있어요~");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		th.start();
		try {
			// 3초 후에 스레드를 종료시키자.
			Thread.sleep(3000); // 3초
		} catch (Exception e) {
			e.printStackTrace();
		}

		th.interrupt(); // 스레드 종료 //반드시 일시정지 상태가 될 때 종료를 감지하고 스레드를 안전하게 종료할 수 있다.
		System.out.println("***메인 종료합니다...***");
	}

}
