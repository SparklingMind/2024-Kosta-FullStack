package ex0206.homework;

import java.util.List;

public interface StudentService {
	/**
	 * 등록하기
	 * 
	 * @return : true이면 등록성공, false이면 등록실패
	 */
	boolean insert(Student st);

	/**
	 * 전체검색
	 */
	List<Student> selectAll();

	/**
	 * 학번에 해당하는 학생의 정보 검색
	 */
	Student selectBySno(String sno);

	/**
	 * 학번에 해당하는 학생의 정보 삭제
	 * 
	 * @return : true이면 삭제성공, false이면 삭제실패
	 */
	boolean delete(String sno);

	/**
	 * 학번에 해당하는 학생의 정보 수정하기 (나이, 주소만 변경)
	 * 
	 * @return : true이면 수정성공, false이면 수정실패
	 */
	boolean update(Student student);
	/**
	 * 나이로 정렬하기
	 * 
	 * @return: 나이를 기준 올림차순으로 정렬된 list를 리턴한다.
	 */
	List<Student> sortByAge();
}


