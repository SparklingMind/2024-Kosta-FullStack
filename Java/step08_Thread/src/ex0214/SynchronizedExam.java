package ex0214;

public class SynchronizedExam {

	public static void main(String[] args) {
		System.out.println("*****메인 시작합니다.*****");
		
		//공유객체 생성
		Bank bank = new Bank();
		
		CustomerThread th1 = new CustomerThread(bank, "인출자", false);
		CustomerThread th2 = new CustomerThread(bank, "입금자", true);
		
		th1.start();
		th2.start();
		
		System.out.println("***메인 끝 ***********");

	}
}
//////////////////////////////////////////
/**
 * 여러 스레드가 공유 할 객체
 * */
class Bank{
	int balance;//잔액 (0)
	
	/**
	 *  인출자  또는 입금자가 잔액을 변경 하는 메소드
	 *  @param : state가 true라면 입금, false라면 출금  
	 * */
	public synchronized void balanceChange(String name , boolean state) {
		if(state) {
			if(balance==0) {
			//synchronized (this) {//괄호 안에는 공유객체
				System.out.print(name + "===> 현재 잔액 확인 : " + balance+" , ") ;
				balance++;
				System.out.println(name + "===> 증가 한 후 잔액 확인 : " + balance) ;
			//}
			}else {
				System.out.println(name+" 대기중 입니다..");
				try {
				  wait();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}else {
			if(balance > 0) {
			//synchronized (this) {
				System.out.print(name + "===> 현재 잔액 확인 : " + balance+" , ") ;
				balance--;
				System.out.println(name + "===> 감소 한 후 잔액 확인 : " + balance) ;
			//}
			}else {
				System.out.println(name+" 대기중입니다...");
				try {
				  wait();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}//elseEnd
		
		notifyAll();// wait()에 의해 대기중인 스레드 깨우기 
		
	}//메소드끝
}// bankEnd

/////////////////////////////////////////
/**
 * 고객  Thread
 * */
class CustomerThread extends Thread{
	Bank bank;
	String name;
	boolean state;
	
	public CustomerThread(Bank bank , String name, boolean state) {
		super(name);
		this.bank=bank;
		this.name=name;
		this.state=state;
	}
	
	@Override
	public void run() {
		for(int i=1; i <= 50 ; i++) {
			//스레드로 동작할 기능 작성 
			bank.balanceChange(name , state);
		}
		System.out.println(super.getName() +" End 입니다...");
	}
}


///////////////////////////////////////////////////





