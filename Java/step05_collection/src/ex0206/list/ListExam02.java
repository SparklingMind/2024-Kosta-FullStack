package ex0206.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListExam02{
//	List<Integer> list = new ArrayList<Integer>(5);
	List<Integer> list = new LinkedList<Integer>();	//다형성. list의 메서드들이 오버라이딩되어 있기 때문에 new LinkedList로 선언해도 밑의 코드가 에러가 나지 않는다.
	
	public ListExam02(){
		
		System.out.println("요소의 개수 : " + list.size());
		
		//추가
		list.add(5);
		list.add(6);
		list.add(8);
		list.add(220);
		list.add(19);
		list.add(8);
		list.add(1);
		list.add(220);
		
		System.out.println("추가 후 요소의 개수 : " + list.size());	//요소의 개수 7개. ->자료구조는 공간 부족하면 자동으로 늘려준다.
		
		//list안에 요소 꺼내기
			//첫번째방법(개선된 for문)
		for(int no:list) {
			System.out.print(no + " , ");
		}
		System.out.println();
		
			//두번째방법
		for(int i = 0; i<list.size(); i++) {
			int no = list.get(i);	//Integer 언박싱
			System.out.print(no+" , ");
		}
		
		//list의 요소제거
		list.remove(2);	//인덱스[2]의 요소 삭제하고 앞으로 밀기.
		System.out.println("\nlist = "+list);	// = list.toString. 
		//모든 콜렉션의 toString은 오버라이딩되어, [5, 6, 19, 8, 220, 220]와 같이 나타난다. -> 굳이 반복문으로 요소 확인할 필요없다.
		//System.out.println(super); //super는 이런 식으로 못 쓴다.
		
		//정렬
		Collections.sort(list);	//올림차순 정렬 
		System.out.println("올림차 순 정렬 후 : " + list);
		Collections.sort(list, Collections.reverseOrder() );	//내림차순 옵션 주기.
		
		System.out.println("내림차순 정렬 후 : " + list);
	}
	
	
	public static void main(String[] args) {
		new ListExam02();
	}
}
