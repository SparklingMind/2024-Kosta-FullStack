package ex0124.Casting;

class CastingExam{
	public static void main(String []args){
		byte b1;
		byte b2, b3;
		int i1=7;
		System.out.println("int i1="+i1);

		b1=(byte)i1; //int -> byte 변환 안 된다 -> 캐스팅연산자
		System.out.println("byte b1="+b1);

		b2=20;
		System.out.println("byte b2="+b2);
		
	   	b3=(byte)(b2+b1);	//b3가 byte면 산술연산 결과를 담을 수 없음.

		System.out.println("byte b3="+b3);
		
		long lo=56897L;
		System.out.println("long lo="+lo);

		int i4=(int)lo+i1; //lo가 long이면 결과가 long이라 결과를 담을 수 없음.
		System.out.println("int i4="+i4);
		
		boolean boo;
		boo=true;	//java에서 true,false는 0,1의 숫자로 나타낼 수 없음. 
		
		System.out.println("boolean boo="+boo);

		double d=4.67e-3;	//e는 지수를 표현해서 소수점 3개를 축약한 거.
		System.out.println("double d="+d);

		float f1=lo;	//크기의 나열순서가 long < float이므로 에러 없음.
		System.out.println("float f1="+f1);
				
		
	    float f2=(float)d;
		System.out.println("float f2="+f2);

		char c1,c2, c3;
		c1='\u0167';	//싱클쿼테이션이지만 유니코드로서 한 글자를 나타냄.
		System.out.println("char c1="+c1);

		b2=(byte)c1; 
		System.out.println("byte b2="+b2);
		
		c2='가';
		System.out.println("char c2="+c2);
		
		b2=(byte)c1;
		System.out.println("byte b2="+b2);
		
		c3=(char)(c2+2);
		System.out.println("char c3="+c3);
		
		
	}

}