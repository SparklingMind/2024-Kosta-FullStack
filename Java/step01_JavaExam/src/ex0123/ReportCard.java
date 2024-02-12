package ex0123;
/**
 *  document 주석
 *  @author 장희정
 *  :성적관리 프로그램
 */
public class ReportCard {

	public static void main(String[] args) {
		
		int koreanScore;
		int mathScore;
		int englishScore;
		int totalScore;
		double averageScore;
		char grade;
	   
		koreanScore = 90;
		mathScore = 97;
		englishScore = 95;
		
		totalScore = koreanScore + mathScore + englishScore;
		averageScore = totalScore/3.0;	//int와 int 연산은 int. 대입연산자는 순서가 마지막이라서 3.0으로 해야 정확한 값이 나옴.
		grade = averageScore >= 90 ? 'A' : 'F';
		
		System.out.println("국어점수 : " + koreanScore);
		System.out.println("수학점수 : " + mathScore);
		System.out.println("영어점수 : " + englishScore);
		System.out.println("총점 : " + totalScore);
		System.out.println("평균 : " + averageScore);
		System.out.println("학점 : " + grade);
		
		}
	}



