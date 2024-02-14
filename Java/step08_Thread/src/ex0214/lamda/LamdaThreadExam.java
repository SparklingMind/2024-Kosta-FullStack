package ex0214.lamda;

public class LamdaThreadExam {
	public static void main(String[] args) {
		System.out.println("****메인 시작합니다.******");
		
		NumberThread th1 = new NumberThread("첫번째  Thread");
		NumberThread th2 = new NumberThread("두번째 Thread");
		
		/*Runnable alphaRun = ()->{
			//run메소드 안
			//현재 스레드 
			Thread th = Thread.currentThread();
			
			for(char ch='A' ; ch <= 'z' ; ch++) {
				System.out.println(th.getName() +" ==> "+ ch);
				//Thread.yield();//양보(현재 스레드를 대기상태로)
				try {
				 Thread.sleep(10);
				}catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
			System.out.println(th.getName()+" 종료합니다.^^");
		};
		
		Thread th3 = new Thread(alphaRun, "세번째 Thread");*/
		
		Thread th3 = new Thread( ()->{
            Thread th = Thread.currentThread();
			
			for(char ch='A' ; ch <= 'z' ; ch++) {
				System.out.println(th.getName() +" ==> "+ ch);
				//Thread.yield();//양보(현재 스레드를 대기상태로)
				try {
				 Thread.sleep(10);
				}catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
			System.out.println(th.getName()+" 종료합니다.^^");
		}  , "세번째 Thread");
		
		/*th1.run();
		th2.run();
		th3.run();*/
		
		//스레드 대기영역 
		th1.start();
		th2.start();
		th3.start();
		/*try {
		  th1.join(); //th1스레드가 일을 마칠때 까지 현재 스레드는 대기 
		}catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		System.out.println("총합 = " + th1.sum);
		
		System.out.println("**메인 종료합니다.*********");

	}
}

//////////////////////////////////
/**
 *  1~ 100 출력하는 스레드
 * */
class NumberThread extends Thread{
	int sum;
	public NumberThread(String name) {
		super(name);// 스레드의 이름
	}
	@Override
	public void run() {
		for(int i=1; i<=100 ; i++) {
			System.out.println(super.getName() +"--> " + i );
			//Thread.yield();//양보(현재 스레드를 대기상태로)
			sum+=i;
			
			try {
				 Thread.sleep(100);
				}catch (InterruptedException e) {
					// TODO: handle exception
				}
		}
		
		System.out.println(super.getName()+" 종료합니다.^^");
	}
	
}
///////////////////////////////////////////





