package ex0124;

class BooleanOPeratorExam{
	public static void main(String args[]){
		boolean  t=true ;
		boolean f=false;
		//비트연산자
		System.out.println("true&false="+(t&f));	//f
		System.out.println("true&true="+(t&t));		//t
		System.out.println("false&false="+(f&f));	//f
		System.out.println();
	
		System.out.println("true|false="+(t|f));	//t
		System.out.println("true|true="+(t|t));	//t
		System.out.println("false|false="+(f|f));	//f
		System.out.println();

		System.out.println("true^false="+(t^f));	//t
		System.out.println("true^true="+(t^t));	//f
		System.out.println("true^false="+(t^f));	//t
		System.out.println("true^true="+(t^t));	//f
		System.out.println();
		
		//논리연산자
		System.out.println("true&&false="+(t&&f));	//f
		System.out.println("true&&true="+(t&&t));	//t
		System.out.println("true&&false="+(t&&f));
		System.out.println("false&&false="+(f&&f));
		System.out.println();

		System.out.println("true||false="+(t||f));	//t
		System.out.println("true||true="+(t||t));	//t
		System.out.println("false||false="+(f||f));	//f
		System.out.println();

		int i=5; int j=3;
		System.out.println("int i="+i+"\tint j="+j);	//int i=5	int j=3
		System.out.println("i>=j==>>"+(i>=j));	//true
		System.out.println("i>j=>>"+(i>j));	//true
		System.out.println("i<=j=>>"+(i<=j));	//false
		System.out.println("i<j=>>"+(i<j));	//false
		System.out.println("i==j=>>"+(i==j));	//false
		System.out.println("i!=j=>>"+(i != j));	//true

	}
}