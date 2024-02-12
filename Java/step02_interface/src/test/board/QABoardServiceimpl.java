package test.board;
/**
 * QA에 관련된 비지니스로직 담당...
 */
public class QABoardServiceimpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("QABoardServiceimpl의 insert call....");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("QABoardServiceimpl의 update call....");
		return true;
	}

	@Override
	public Board selectByBno(int bon) {
		System.out.println("QABoardServiceimpl의 selectByBno call....");
		return null;
	}
	
	public void replyInsert(){
		System.out.println("QABoard의 답변기능...");
	}
}
