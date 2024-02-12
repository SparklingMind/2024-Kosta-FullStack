package ex0206.homework;
import java.util.List;
import java.util.Scanner;

/**
   사용자의 요청을 키보드로 입력받는 클래스 
*/
public class MenuView{
    Scanner sc= new Scanner(System.in);
    
	StudentService service = new StudentServiceImpl();
	
	/**
	  전체 메뉴를 출력하는 메소드
	*/
	public void printMenu(){
        
	     while(true){
           System.out.println("-----------------------------------------------------------------------------");
           System.out.println("1. 전체검색    2. 학생번호검색     3.등록     4. 수정    5. 삭제   6. 나이정렬   9. 종료");
		   System.out.println("-----------------------------------------------------------------------------");
		   System.out.print("메뉴선택 > ");

		   String  menu = sc.nextLine();
		   switch(menu){
               case "1" : 
            	   List<Student> list = service.selectAll();
            	   EndView.printAll(list);
			   break;
			   case "2" : 
                 this.inputSearch();
			   break;
			   case "3" : 
                 this.inputInsert();
			   break;
			   case "4" : 
                 this.inputUpdate();
			   break;
			   case "5" : 
	              this.inputDelete();
				break;
			   case "6" : 
		             // 정렬기능 호출....
					break;
			   case "9" : 
                 System.exit(0);
			   default:
				   System.out.println("메뉴를 다시 선택해주세요!!!!");

		   }//switch문끝

		 }//while문끝

	}//메소드끝

	/**
	   등록할때 키보드 입력을 처리하는 메소드
	*/
	public void inputInsert(){
        System.out.print("학생번호은? ");
        String sno = sc.nextLine();

		System.out.print("학생이름은? ");
        String name = sc.nextLine();

		System.out.print("학생나이은? ");
        int age = Integer.parseInt(sc.nextLine());

		System.out.print("학생 주소는? ");
        String addr = sc.nextLine();

        boolean result = service.insert( new Student(sno, name, age, addr) );
        
        if(result)EndView.printMessage("등록되었습니다.");
        else EndView.printMessage("등록되지 않았습니다");

	}

	/**
	 학생번호에 해당하는 학생정보 검색하기 위해서 학생번호 키보드입력 처리하는 메소드
	*/
    public void inputSearch(){
       System.out.print("찾을 학생번호은? ");
        String sno = sc.nextLine();
        
        Student st = service.selectBySno(sno);
        if(st == null) {
        	EndView.printMessage(sno+"에 해당하는 학생 정보는 없습니다.");
        }else {
            EndView.printSearchBySno(st);
        }
   
	}


	/**
	  학생번호에 해당하는 학생의 나이와 주소를 수정하기 위해 키보드 입력처리하는 메소드
	*/
	public void inputUpdate(){
         System.out.print("수정하려는 학생번호은? ");
         String sno = sc.nextLine();

		System.out.print("변경하려는 나이는? ");
        int age = Integer.parseInt(sc.nextLine());
        
        System.out.print("변경하려는 주소는? ");
        String addr = sc.nextLine();

		boolean result = service.update( new Student(sno, age, addr)) ;
		if(result)EndView.printMessage("수정되었습니다.");
		else EndView.printMessage("수정되지 않았습니다.");

	}
	
	/**
	 * 학생 번호에 해당하는 정보 삭제를 위한 키보드 입력 메소드
	 * */
	public void inputDelete(){
       System.out.print("삭제 할 학생 번호은? ");
       String sno  = sc.nextLine();
			
        boolean result = service.delete(sno);
        
        if(result)EndView.printMessage("삭제되었습니다.");
        else EndView.printMessage("삭제되지 않았습니다.");
	   
	}

	
	

}





