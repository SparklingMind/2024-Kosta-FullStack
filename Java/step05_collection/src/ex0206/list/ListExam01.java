package ex0206.list;

import java.util.ArrayList;
import java.util.Collections;

public class ListExam01 extends ArrayList<Integer>{
	public ListExam01(){
		super(5);
		
		System.out.println("요소의 개수 : " + size());
		
		//추가
		this.add(5);
		this.add(6);
		this.add(8);
		this.add(220);
		this.add(19);
		this.add(8);
		this.add(1);
		this.add(220);
		
		System.out.println("추가 후 요소의 개수 : " + size());	//요소의 개수 7개. ->자료구조는 공간 부족하면 자동으로 늘려준다.
		
		//list안에 요소 꺼내기
			//첫번째방법(개선된 for문)
		for(int no:this) {
			System.out.print(no + " , ");
		}
		System.out.println();
		
			//두번째방법
		for(int i = 0; i<size(); i++) {
			int no = super.get(i);	//Integer 언박싱
			System.out.print(no+" , ");
		}
		
		//list의 요소제거
		super.remove(2);	//인덱스[2]의 요소 삭제하고 앞으로 밀기.
		System.out.println("\nthis = "+this);	// = this.toString. 
		//모든 콜렉션의 toString은 오버라이딩되어, [5, 6, 19, 8, 220, 220]와 같이 나타난다. -> 굳이 반복문으로 요소 확인할 필요없다.
		//System.out.println(super); //super는 이런 식으로 못 쓴다.
		
		//정렬
		Collections.sort(this);	//올림차순 정렬 
		System.out.println("올림차 순 정렬 후 : " + this);
		Collections.sort(this, Collections.reverseOrder() );	//내림차순 옵션 주기.
		
		System.out.println("내림차순 정렬 후 : " + this);
	}
	
	
	public static void main(String[] args) {
		new ListExam01();
	}
}
