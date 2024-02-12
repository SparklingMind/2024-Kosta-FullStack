package mvc.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import mvc.dto.Electronics;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;
import mvc.service.ElectronicsService;
import mvc.service.ElectronicsServiceImpl;
import mvc.view.FailView;
import mvc.view.SuccessView;



/**
 * View와 Model 사이에서 중간 역할 
 *  : 사용자의 요청을 받아서 그에 해당하는 서비스를 호출하고
 *    호출한 결과를 받아서 결과값에 따라 결과 뷰를 호출해준다.
 */

public class ElectronicsController {
    private ElectronicsService service = ElectronicsServiceImpl.getInstance();
    

    /**
     * 전체검색
     */
    public void selectAll() {
    	List<Electronics> list = service.selectAll();
		SuccessView.printAll(list);
		
    }
 

	 /**
     * 전자제품 등록 
     */
   
    public void insert(Electronics electronics) {
       try {
    	   service.insert(electronics);
    	   SuccessView.printMessage("상품을 추가했습니다.");
       }catch (ElectronicsArrayBoundsException e) {
    	   FailView.errorMessage(e.getMessage());
       }
    }
    
    /**
     * 모델번호에 해당하는 전자제품 검색
     * @param modelNo
     */
    public void searchByModelNo(int modelNo) {
    	//서비스를 호출하고 그 결과를 받아서 성공 또는 실패로 이동한다.
    	try {
    		Electronics electronics = service.searchByModelNo(modelNo);
    		SuccessView.printSearchByModelNo(electronics);
    		
    	
    	}catch(SearchNotFoundException e) {
    		//예외가 발생한 경우
    		FailView.errorMessage(e.getMessage());
    	}
    } 

    /**
     * 모델번호에 해당하는 전자제품 수정하기 
     * @param electronics
     */
    public void update(Electronics electronics) {
    	try {
    		service.update(electronics);
    		SuccessView.printMessage("상품 정보를 수정했습니다.");
    	} catch(SearchNotFoundException e) {
    		//예외가 발생한 경우
    		FailView.errorMessage(e.getMessage());
    	}
    }
    
    /**
     * 모델번호에 해당하는 전자제품 삭제하기 
     * @param electronics
     */
	public void deleteModelNo(int modelNo) {
		try {
			service.delete(modelNo);
			SuccessView.printMessage("modelNo "+ modelNo+"번 상품을 삭제했습니다.");
		} catch(SearchNotFoundException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
     *  가격을 기준으로 정렬하기
     *  만약, 가격이 같으면 modelNo를 기준으로 정렬한다.
     * @return
     */
    public void ascendingSortByPrice() {
    	service.ascendingSortByPrice();
    	SuccessView.printMessage("가격과 모델명을 기준으로 오름차순으로 정렬했습니다.");
    }
    
    //추가기능 1
    public void descendingSortByPrice() {
    	service.descendingSortByPrice();
    	SuccessView.printMessage("가격과 모델명을 기준으로 내림차순으로 정렬했습니다.");
    }
    
    //추가기능 2
    public void randomDiscount() {
        try {
            Electronics discountedItem = service.randomDiscount(); // 할인이 적용된 객체 받기
            SuccessView.printMessage("할인이 적용된 모델: " + discountedItem.getModelName() + ", 최종 가격: " + discountedItem.getModelPrice()+ "원!!!!");
        } catch(ElectronicsArrayBoundsException e) {
            FailView.errorMessage(e.getMessage());
        }
    }
    
}











