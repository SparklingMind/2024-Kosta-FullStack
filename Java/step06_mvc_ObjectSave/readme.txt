1. 프로그램이 시작될때
   
   ElectronicsServiceImpl 생성자에서
   	//save.txt문서가 존재하는지 체크한후
    	//없으면 ResourceBundle를 이용해서 
    	//list에 데이터를 저장한다.
    	//만약 있으면 save.txt에 있는 파일을
    	//로딩해서 list를 복원한다.!!!
    	
 
    	
 2. 종료 메뉴를 클릭하면 saveObject() 호출한다.
 ElectronicsService에
 public void saveObject() ; 추가하고
 
 구현객체에서 재정의 한후
  기능을 완료한다.
    	