package ex0206.homework;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
	
	private ArrayList<Student> list = new ArrayList<Student>();
	
	/**
	 * 초기치 데이터 5명의 정보를 저장
	 * */
	public StudentServiceImpl() {
		list.add(new Student("A01", "희정", 20, "서울"));
		list.add(new Student("A02", "나영", 25, "대구"));
		list.add(new Student("A03", "효리", 22, "부산"));
		list.add(new Student("A04", "민아", 21, "경기"));
		list.add(new Student("A05", "선경", 20, "서울"));
	}

	@Override
	public boolean insert(Student st) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Student> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student selectBySno(String sno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String sno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Student> sortByAge() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
