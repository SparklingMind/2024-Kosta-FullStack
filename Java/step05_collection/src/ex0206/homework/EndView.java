package ex0206.homework;

import java.util.List;

/**
  사용자 요청에 해당하는 결과를 모니터에 출력하는 클래스 
*/
class EndView{
    /**
	   전달된 List을 출력(전체 검색 결과)
	*/
	public static void printAll(List<Student> list){
        System.out.println("***학생의 정보 ("+list.size()+")명 ******");
        //Student st = list.get(0);
        
        for(Student st : list) {
        	System.out.println(st);//st.toString()호출된다
        }
        System.out.println();
	}

	/**
	  학생번호에 해당하는 학생 정보 출력
	*/
	public static void printSearchBySno(Student student){
		System.out.println(student.getSno()+"의 정보는 아래와 같습니다-------");  
		System.out.println(student);//student.toString()
		
		System.out.println();
	}
	/**
	  성공 여부에 관련된 메시지 출력
	*/
	public static void printMessage(String message){
         System.out.println(message+"\n");
	}

}