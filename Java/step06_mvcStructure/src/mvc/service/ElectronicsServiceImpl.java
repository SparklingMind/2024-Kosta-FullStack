package mvc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import mvc.dto.Electronics;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;

/**
 * 전자제품에 관련된 기능을 담당할 클래스 : 싱글톤 클래스로 만든다. => (private 생성자, 자기 자신 멤버에서 생성, 현재 객체를
 * 리턴하는 static 메소드 제공)
 */

public class ElectronicsServiceImpl implements ElectronicsService {

	private static ElectronicsService instance = new ElectronicsServiceImpl(); // 싱글톤
	private static final int MAX_SIZE = 10;
	List<Electronics> list = new ArrayList<Electronics>();

	/**
	 * 외부에서 객체 생성안됨. InitInfo.properties파일을 로딩하여 List에 추가하여 초기치 데이터를 만든다.
	 * 
	 */
	private ElectronicsServiceImpl() {
		ResourceBundle rb = ResourceBundle.getBundle("mvc/service/InitInfo");
		for (String key : rb.keySet()) {
			String value = rb.getString(key);
			String v[] = value.split(","); // split 이용해서 ","를 기준으로 분리해서 리스트에 넣기.
//        	System.out.println(key + " = " + value);	
			list.add(new Electronics(Integer.parseInt(v[0]), v[1], Integer.parseInt(v[2]), v[3]));
		}
		System.out.println(list);
	}

	public static ElectronicsService getInstance() { // 싱글톤패턴
		return instance;
	}

	@Override
	public void insert(Electronics electronics) throws ElectronicsArrayBoundsException {
		if (list.size() < MAX_SIZE) {
			list.add(electronics);
		} else {
			throw new ElectronicsArrayBoundsException("배열의 길이를 벗어나 더이상 등록할 수 없습니다.");
		}
	}

	@Override
	public List<Electronics> selectAll() {
		return list;
	}

	@Override
	public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException {
		for (Electronics e : list) {
			if (e.getModelNo() == modelNo) {
				// 찾았다.
				return e;
			}
		}
		throw new SearchNotFoundException(modelNo + "은 없는 모델 번호로 검색할 수 없습니다.");
	}

	@Override
	public void update(Electronics electronics) throws SearchNotFoundException {
		for (Electronics e : list) {
			if (e.getModelNo() == electronics.getModelNo()) {
				// 찾았다.
				e.setModelDetail(electronics.getModelDetail());
				return;
			}
		}
		throw new SearchNotFoundException(electronics.getModelNo() + "은 없는 모델 번호로 검색할 수 없습니다.");
	}

	@Override
	public void delete(int modelNo) throws SearchNotFoundException {
		Electronics e = this.searchByModelNo(modelNo);
		list.remove(e);
	}

	@Override
	public List<Electronics> ascendingSortByPrice() {
		Collections.sort(list, new Comparator<Electronics>() {
			@Override
			public int compare(Electronics e1, Electronics e2) {
				int priceCompare = Integer.compare(e1.getModelPrice(), e2.getModelPrice());
				if (priceCompare != 0) {
					return priceCompare;

				} else
					return Integer.compare(e1.getModelNo(), e2.getModelNo());
			}

		});
		return list;
	}

	public List<Electronics> descendingSortByPrice() {
		Collections.sort(list, new Comparator<Electronics>() {
			@Override
			public int compare(Electronics e1, Electronics e2) {
				int priceCompare = Integer.compare(e2.getModelPrice(), e1.getModelPrice());
				if (priceCompare != 0) {
					return priceCompare;
				} else

					return Integer.compare(e2.getModelNo(), e1.getModelNo());
			}

		});
		return list;
	}
	
	public Electronics randomDiscount() throws ElectronicsArrayBoundsException {
	    Random random = new Random();

	    // 10에서 50 사이의 랜덤 정수 생성
	    int discountRate = 10 + random.nextInt(41); // 0~40 사이의 값에 10을 더해 10~50 사이의 값 생성
	    
	    if (list.size() == 0) {
	        throw new ElectronicsArrayBoundsException("할인을 적용할 제품이 없습니다.");
	    }
	    
	    int randomModelIndex = random.nextInt(list.size()); // 0부터 list.size() - 1 사이의 인덱스 생성
	    Electronics SelectedItem = list.get(randomModelIndex);
	    // 할인 적용 후 최종 가격 계산. 결과를 int로 형 변환
	    int finalPrice = (int) (list.get(randomModelIndex).getModelPrice() * (1 - discountRate * 0.01));

	    // 계산된 최종 가격을 모델 가격에 설정
	    SelectedItem.setModelPrice(finalPrice);
	    SelectedItem.setModelDetail(SelectedItem.getModelDetail().concat("  <-- 할인 적용!!!"));
	    
	    return SelectedItem;
	}


} // 클래스 끝