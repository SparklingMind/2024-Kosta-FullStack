package test.board;

public class UploadBoardSeriveceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println("UpdateBoardSeriveimpl의 insert call...");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("UpdateBoardSeriveimpl의 update call...");
		return true;
	}

	@Override
	public Board selectByBno(int bon) {
		System.out.println("UpdateBoardSeriveimpl의 selectByBno call...");
		return null;
	}

}
