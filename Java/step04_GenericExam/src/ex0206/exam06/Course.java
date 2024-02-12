package ex0206.exam06;

/**
 * 신청자(사람, 직장인, 고등, 중학)가 과정을 신청하는 클래스
 */
public class Course {
	/**
	 * 모든 사람을 허용(등록)
	 */
	public void register1(Applicant<?> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName()+ "가 신청하였습니다. register1");
		//메소드 체인 : 연쇄적으로 메서드 호출.
	}

	/**
	 * 직장인만 허용(등록)
	 */
	public void register2(Applicant<? super Worker> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName()+ "가 신청하였습니다.register2");

	}

	/**
	 * 학생만 허용(등록)
	 */

	public void register3(Applicant<? extends Student> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName()+ "가 신청하였습니다.register3");

	}

}
