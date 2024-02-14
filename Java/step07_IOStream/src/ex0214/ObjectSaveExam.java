package ex0214;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectSaveExam {
    public ObjectSaveExam() {
    	Student st1 = new Student("희정", 20, "서울");
    	Student st2 = new Student("가현", 18, "오리");
    	
    	List<Student> list = new ArrayList<Student>();
    	list.add(st1);
    	list.add(st2);
    	
    	list.add(new Student("나영", 25, "대구"));
    	list.add(new Student("미미", 22, "대전"));
    	list.add(new Student("삼순", 23, "대구"));
    	list.add(new Student("삼식", 20, "제주도"));
    	
    	
    	//객체를 파일에 저장하는 클래스 - ObjectOutputStream 이용
    	try(ObjectOutputStream oos =
    			new ObjectOutputStream(
    					new FileOutputStream("src/ex0214/objSave.txt"))){
    		// 저장하자
    		//oos.writeObject(st1);
    		//oos.writeObject(st2);
    		
    		//list를 파일에 저장해보자.
    		oos.writeObject(list);
    		
    		System.out.println("저장완료!~~~");
    		
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }
	public static void main(String[] args) {
		new ObjectSaveExam();

	}

}
