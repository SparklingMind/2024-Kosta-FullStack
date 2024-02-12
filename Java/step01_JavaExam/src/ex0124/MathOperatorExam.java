package ex0124;
class MathOperatorExam{
	public static void main(String []args){
		int i=5;
		int j=2;
		System.out.println("i+j="+i+j);	//7	//틀림
		System.out.println("i-j="+(i-j));	//3
		System.out.println("i*j="+(i*j));	//10
		System.out.println("i/j="+(i/j));	//2
		System.out.println("i%j="+(i%j));	//1

		System.out.println("i="+i);	//5
		
		int k=i++;
		System.out.println("k="+k);	//5
		System.out.println("i="+i);	//6
		
		int p=++i;
		System.out.println("p="+p);	//7
		System.out.println("i="+i);	//7

		int x=19 + 4 * 3 / 2 - 10 * 2 + 4;	//9

		System.out.println("19+4*3/2-10*2+4="+x);
	}	
}