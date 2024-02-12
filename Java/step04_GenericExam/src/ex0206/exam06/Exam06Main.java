package ex0206.exam06;
/*
 * 상속에 따른 각 클래스 생성에서의 인수 제한
 */
public class Exam06Main {
	public static void main(String[] args) {
		
		
		Course course = new Course();
		
		System.out.println("--<?> applicant>인 경우------------------------------------------");
		course.register1(new Applicant<Person>(new Person()));
		course.register1(new Applicant<Worker>(new Worker()));
		course.register1(new Applicant<Student>(new Student()));
		course.register1(new Applicant<HighStudent>(new HighStudent()));
		course.register1(new Applicant<MiddleStudent>(new MiddleStudent()));
		
		System.out.println("--<? super Worker>인 경우------------------------------------------");
		
		course.register2(new Applicant<Person>(new Person()));
		course.register2(new Applicant<Worker>(new Worker()));
//		course.register2(new Applicant<Student>(new Student()));
//		course.register2(new Applicant<HighStudent>(new HighStudent()));
//		course.register2(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println("--? extends Student인 경우------------------------------------------");
		
//		course.register3(new Applicant<Person>(new Person()));
//		course.register3(new Applicant<Worker>(new Worker()));
		course.register3(new Applicant<Student>(new Student()));
		course.register3(new Applicant<HighStudent>(new HighStudent()));
		course.register3(new Applicant<MiddleStudent>(new MiddleStudent()));
	}
}
