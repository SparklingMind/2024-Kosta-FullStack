package test.board;

public class FreeBoardServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println(super.getClass().getSimpleName()+"의 insert 기능입니다...");
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println(super.getClass().getSimpleName()+"의 update 기능입니다...");
		return true;
	}

	@Override
	public Board selectByBno(int bon) {
		System.out.println(super.getClass().getSimpleName()+"의 selectByBno 기능입니다...");
		return null;
	}

}
