package ex0206.list;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListExam03 {
	List<Emp> list = new ArrayList<Emp>();
	//arrayList타입을 생성하여 List타입의 list에 할당(다형성.폴리모피즘)
	public ListExam03() {
		// list에 사원 3명 추가
		list.add(new Emp(60, "다희", 10, "성남"));
		list.add(new Emp(30, "희정", 20, "지구"));
		list.add(new Emp(20, "까치", 4, "탄천"));
		list.add(new Emp(90, "깜이", 3, "성남"));
		list.add(new Emp(61, "지현", 21, "강북"));

		// 출력
		for(Emp e:list)
		System.out.println(e); // toString을 오버라이딩함으로써, 각 속성이 표시됨.
	}
	
	/**
	 * 이름에 해당하는 사원 정보 검색(이름 중복 안 됨)
	 */
	public Emp selectByName(String name) {
		for(Emp e:list) {
			if(e.getEname().equals(name)) {
				return e;
			}
		}
		return null;
	}
	
	/**
	 * 주소에 해당하는 사원정보 검색(주소 중복가능)
	 * @param args
	 */
	public List<Emp> selectByAddr(String addr){
		List<Emp> searchList = new ArrayList<Emp>();
		for(Emp e:list) {
			if(e.getAddr().equals(addr)) {
				//주소가 같은 객체를 찾았다.
				searchList.add(e);//찾은 객체를 담는다.
			}
		}
		return searchList;
	}
	
	/**
	 * 사원의 사원번호를 기준으로 정렬한 결과를 리턴.
	 * @param args
	 */
	public List<Emp> sortByEmpNo(){
		List<Emp> shallowCopyList = new ArrayList<Emp>(list);
		/*System.out.println("정렬전 : ");
		for(Emp e:shallowCopyList) {
			System.out.println(e);
		}*/
		Collections.sort(shallowCopyList);//
		return shallowCopyList;
	}
	public static void main(String[] args) {
		ListExam03 ex = new ListExam03();
		
		System.out.println("---1.이름으로 검색---");
		System.out.println(ex.selectByName("다희"));	//객체의 주소값 리턴
		System.out.println(ex.selectByName("효민"));	//해당 객체가 없기 때문에 null값 리턴
		System.out.println("---2.주소로 검색---");
		List<Emp> searchList = ex.selectByAddr("성남");
		if(searchList.isEmpty()) {
			System.out.println("찾는 주소가 없습니다.");
		}else {
			for(Emp e : searchList) {
				System.out.println(e);
			}
		}
		
		System.out.println("정렬 연습");
		List<Emp> sortResult = ex.sortByEmpNo()
;
		for(Emp emp: sortResult) {
			System.out.println(emp);
		}
	}
}
