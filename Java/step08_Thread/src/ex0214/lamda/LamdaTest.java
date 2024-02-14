package ex0214.lamda;

public class LamdaTest {
	public static void main(String[] args) {
		//기존코딩방식
		/*AInterface ai = new Test();
		ai.aa();*/
		
		//@FunctionalInterface 인경우 람다식으로 변경가능하다.////////////////////////////////////
		//  () -> { }
		/*AInterface ai = ()->{
			System.out.println("람다식... aa() call...");
		};*/
		
		AInterface ai = () -> System.out.println("람다식... aa() call...");
		ai.aa();
		
		System.out.println("--인수 매개변수가 있는 경우--------------");
		BInterface bi = (a)->{
			System.out.println("전달된 인수 = " + a);
			//기능
		};
		
	    bi.bb(10);
	    bi.bb(5);
		
	    System.out.println("--인수 매개변수, 리턴 있는 경우--------------");
       /* CInterface ci = (a, b)->{
        	//기능
        	System.out.println("CInterface의 cc() cal..." );
        	System.out.println(a+" , " + b);
        	return a*b;
        };*/
	    
	    /*CInterface ci = (a, b)->{
        	return a*b;
        };*/
	    
	    
	   // CInterface ci = (a, b)-> a*b;
	    
	    CInterface ci = (a, b)->{ return a*b;};
       
        
        int result = ci.cc(4, 5);
	    System.out.println("결과 = " +  result);
	}

}

///////////////////////////////
class Test implements AInterface{
	@Override
	public void aa() {
		System.out.println("Test의 aa() call....");
		
	}
}
