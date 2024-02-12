package test.board;

/**
 * 모든 게시판이 공통으로 사용하게될 메소드 정의 (규격서)
 */
public interface BoardService {
    /**
     * 등록하기
     * 
     * @return:0이면 실패, 1이상이면 등록성공.
     * @param : QaBoard or UploadBoard or FreeBoard 전달
     */
    int insert(Board board); // QABoard, UploadBoard, FreeBoard가 모두 들어올 수 있다.(다형성)

    /**
     * 수정하기(글번호에 해당하는 제목, 내용을 수정한다.)
     * 
     * @return : true이면 수정완료. false이면 수정 실패
     * @param : QaBoard or UploadBoard or FreeBoard 전달
     */
    boolean update(Board board);

    /**
     * 글번호에 해당하는 게시물 조회하기
     * 
     * @param : 글번호
     * @return : 조회된 QABoard or UploadBoard or FreeBoard 리턴
     *         조회된 결과가 없으면 null 리턴.
     */
    Board selectByBno(int bon);

    /**
     * 글번호에 해당하는 게시물 조회하기
     */
    default void replyInsert() {	//디폴드메서드는 인터페이스 내에서도 정의가 가능 (공통기능)
    	System.out.println("답변기능.");
    }
    
    static void selectAll() {	//implements 내에서 정적 메소드 선언 가능.
    	System.out.println("BoardService의 selectAll 메서드입니다...");
    }
}


