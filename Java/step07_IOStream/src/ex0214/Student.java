package ex0214;

import java.io.Serializable;

/**
 * 객체를 파일에 저장하기위한 클래스  - 직렬화 필수이다.
 *  : 필드만 직렬화 대상이다(파일에 저장됨) -  생성자, 메소드 안됨.
 *  : static , transient 키워드가 붙어 있으면 직렬화 대상에서 제외됨
 * */
public class Student implements Serializable {
   private String name;
   private int age;
   private /*transient*/ String addr;
   
   public Student() {}
  public Student(String name, int age, String addr) {
	super();
	this.name = name;
	this.age = age;
	this.addr = addr;
  }

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", addr=");
		builder.append(addr);
		builder.append("]");
		return builder.toString();
	}
  
   
}
