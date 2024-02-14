package mvc.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

import mvc.dto.Electronics;
import mvc.exception.DMLException;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;

/**
 * 전자제품에 관련된 기능을 담당할 클래스
 */

public class ElectronicsServiceImpl implements ElectronicsService {
	
	
	private static ElectronicsService instance = new ElectronicsServiceImpl(); 
    private static final int MAX_SIZE=10;
    List<Electronics> list = new ArrayList<Electronics>();
    
    
    /** 
     * 외부에서 객체 생성안됨. 
     * InitInfo.properties파일을 로딩하여  List에 추가하여
     * 초기치 데이터를 만든다.
     * 
     */
    private ElectronicsServiceImpl() {
    	
    	//save.txt문서가 존재하는지 체크한후
    	//없으면 ResourceBundle를 이용해서 
    	//list에 데이터를 저장한다.
    	//만약 있으면 save.txt에 있는 파일을
    	//로딩해서 list를 복원한다.!!!
    	
    	
    	ResourceBundle rb = ResourceBundle.getBundle("mvc/service/InitInfo");//dbInfo.properties
        for(String key : rb.keySet()) {
     	  String value =  rb.getString(key);
     	   String data[] = value.split(",");
     	   //System.out.println(key +" = " + value);
     	  
     	     list.add(new Electronics( Integer.parseInt(data[0]) ,data[1],   
     	    		 Integer.parseInt( data[2]), data[3]) );
     	  
        }
        
      
    }
    
    public static ElectronicsService getInstance() {
		return instance;
	}

	@Override
	public void insert(Electronics electronics) throws ElectronicsArrayBoundsException {
		
		if(list.size() == MAX_SIZE) {
			throw new ElectronicsArrayBoundsException("더이상 등록할수 없습니다.");
		}
		
		try {
			// 모델번호 존재유무 체크
			this.searchByModelNo(electronics.getModelNo());
			throw new ElectronicsArrayBoundsException("모델번호 오류로 등록할수 없어요.");
			
		} catch (SearchNotFoundException e) {
			//예외가 발생했다는것은 모델번호가 중복이 아니다. 그래서 추가한다.
			list.add(electronics);
		}
	}

	@Override
	public List<Electronics> selectAll() {
		
		return this.list;
	}

	@Override
	public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException {
		for(Electronics elec : list) {
    		if(elec.getModelNo() == modelNo ){
                return elec;
            }
    	}
        
        //찾는 정보가 없다!!!
        throw new SearchNotFoundException(modelNo+"는 없는 모델번호로 검색할수 없습니다.");
	}
	

	  /**
     * 모델번호에 해당하는 전자제품 수정하기 
     * (설명만 수정한다)
     * @param electronics
     * @return
     */
	
    public void update(Electronics electronics) throws DMLException{
		//인수로 전달된 모델번호에 해당하는 전자제품이 있는지 검색한다.
    	try {
         Electronics dbElectronics = this.searchByModelNo(electronics.getModelNo());
         dbElectronics.setModelDetail( electronics.getModelDetail()  );
         
    	}catch (SearchNotFoundException e) {
			 throw new DMLException("모델번호 오류로 수정할수 없습니다.");
		}
    }
    
    

	@Override
	public void delete(int modelNo) throws SearchNotFoundException {
		 Electronics dbElectronics = this.searchByModelNo(modelNo);
		list.remove(dbElectronics);
		
		
	}

	/*@Override
	public List<Electronics> selectSortByPrice() {
		List<Electronics> sortList = new ArrayList<Electronics>(list);
		Collections.sort(sortList, (o1,o2) ->{
			int result =  (o1.getModelPrice() - o2.getModelPrice()) == 0 
					? o1.getModelNo() - o2.getModelNo() : 
						(o1.getModelPrice() - o2.getModelPrice());
		    return result;
		});
		
		return sortList;
	}*/
	
	@Override
	public List<Electronics> selectSortByPrice() {
		List<Electronics> sortList = new ArrayList<Electronics>(list);
		
		Collections.sort(sortList , new Comparator<Electronics>() {
			@Override
			public int compare(Electronics o1, Electronics o2) {
				//return o1.getModelPrice()  - o2.getModelPrice();
				//return o2.getModelPrice()  - o1.getModelPrice();
				return  (o1.getModelPrice()  - o2.getModelPrice()==0)
						? (o2.getModelNo() - o1.getModelNo()) : o1.getModelPrice()  - o2.getModelPrice();
			}
		});
		
		return sortList;
	}

	
	@Override
	public void saveObject() {
		//list 를 save.txt 에 저장한다.
		
	}

    
} // 클래스 끝 




	 
 














