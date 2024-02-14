package ex0214;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GuiThreadExam extends JFrame{
	JTextField text1 =new JTextField(5);
	JTextField text2 =new JTextField(5);
	
	JButton btn = new JButton("클릭");
	
    boolean state;//false (true이면 실행중, false이면 중지) 
	
    public GuiThreadExam() {
    	
    	setLayout(new FlowLayout()); //JFrame의 레이아웃변경
    	
    	Container con = super.getContentPane();
    	con.add(text1);
    	con.add(text2);
    	con.add(btn);
    	
    	setSize(500, 400);//JFrame의 크기 
    	setLocationRelativeTo(null);//정중앙에 놓기 
    	setVisible(true);
    	//x를 클릭했을때 프로그램 종료
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	new TimerThread().start();
    	new DecimalThread(text1).start();
    	
    	//이벤트 등록
        btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// a ~ z text박스에 출력 
				if(!state) {
					state=true;
					/*new Thread(){//355page
						public void run() {
							for(char ch='A' ; ch <= 'z' ; ch++) {
							  text2.setText(ch+"");
							  try {
							     Thread.sleep(100);//0.1초
							  }catch (Exception e) {
								e.printStackTrace();
							  }
							}//for문
							
							state=false; 
						}//run종료
				   }.start();*/
					/////////////////
					new Thread(()->{
						for(char ch='A' ; ch <= 'z' ; ch++) {
							  text2.setText(ch+"");
							  try {
							     Thread.sleep(100);//0.1초
							  }catch (Exception ex) {
								ex.printStackTrace();
							  }
							}//for문
							
							state=false; 
					}).start();
					
				}
				
			}
		});
    	
    }//생성자끝
	public static void main(String[] args) {
		new GuiThreadExam();

	}
	
	////////////////////////////////
	/**
	 * Jframe위에 시계를 동작 하게 하는 Thread(1초마다 갱신)
	 * */
	class TimerThread extends Thread{
		@Override
		public void run() {
			while(true) {
				//현재 날짜와 시계
				Calendar now = Calendar.getInstance();
				
				int y = now.get(Calendar.YEAR);
				int m = now.get(Calendar.MONTH) +1;
				int d = now.get(Calendar.DATE);
				
				int h = now.get(Calendar.HOUR_OF_DAY);
				int min = now.get(Calendar.MINUTE);
				int s = now.get(Calendar.SECOND);
				
				String time = y+"년 " + m+"월 " + d +"일 " + h +" : "+ min +" : "+ s; 
				
				GuiThreadExam.this.setTitle(time);
				
				try {
				  Thread.sleep(1000); //1초 대기상태
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//while문
		}//runEnd
	}
	

}//클래스끝
///////////////////////////////////
/**
 *  1 ~ 1000까지 text박스에 출력하기 
 * */
class DecimalThread extends Thread{
	private JTextField text;
	public DecimalThread(JTextField text) {
		this.text = text;
	}
	@Override
	public void run() {
		for(int i=1; i <=1000 ; i++) {
			//text박스에 숫자 출력
			text.setText(i+"");
			try {
			  Thread.sleep(10);//0.01초 대기
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
//////////////////////////////////////////////////











