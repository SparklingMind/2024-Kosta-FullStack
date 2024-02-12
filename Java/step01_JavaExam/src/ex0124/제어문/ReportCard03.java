package ex0124.제어문;
/**
 *  document 주석
 *  @author 정다희
 *  :성적관리 프로그램
 */
public class ReportCard03 {

	public static void main(String[] args) {
		//국어, 영어, 수학 점수를 45~ 100사이의 난수로 저장
		//점수가 90이상이면 A학점, 80~89이면 B학점, 70~79이면 C학점, 60~69이면 D학점, 나머지는 E학점으로 나타내기.
		
		
		int koreanScore;
		int mathScore;
		int englishScore;
		int totalScore;
		double averageScore;
		char grade;
	   
		koreanScore = (int)(Math.random() * 56 + 45);
		mathScore = (int)(Math.random() * 56 + 45);
		englishScore = (int)(Math.random() * 56 + 45);
		
		totalScore = koreanScore + mathScore + englishScore;
		averageScore = totalScore/3.0;	//int와 int 연산은 int. 대입연산자는 순서가 마지막이라서 3.0으로 해야 정확한 값이 나옴.
//		if(averageScore >= 90) {
//			grade = 'A';
//		}
//		else if(averageScore >= 80) {
//			grade = 'B';
//		}
//		else if(averageScore >= 70) {
//			grade = 'C';
//		}
//		else if(averageScore >= 60) {
//			grade = 'D';
//		}
//		else {
//			grade = 'E';
//		}
		//switch 문으로 변경해보자.
		grade = switch((int)(averageScore/10)) {	
		//double인 averageScore을 십의 자리만 남기기위해 10으로 나눈 후, int형으로 형변환.
		case 10 , 9 ->'A';
		case 8 ->'B'; 
		case 7 -> {
			yield 'C';	//중괄호가 있으면 yield필요 
		}
		case 6 ->'D'; 
		default ->'E'; 
		};
		
		System.out.print("국어점수 : " + koreanScore + "\t");
		System.out.print("수학점수 : " + mathScore + "\t");
		System.out.print("영어점수 : " + englishScore + "\n");
		System.out.println("총점 : " + totalScore);
		System.out.println("평균 : " + averageScore);
		System.out.println("학점 : " + grade);
		
		}
	}



