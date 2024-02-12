package test.board;

public class MainApp {
	private BoardService boardService;	//필드를 이용한 다형성
	private Board board;	//필드를 이용한 다형성
	public MainApp() {
		//1.QA
		board = new QABoard(1, "java", "희정", "어렵다", false);
		boardService = new QABoardServiceimpl();
		
		this.test(boardService, board);
		
		//2.Upload
		System.out.println("--2.");
		board = new UploadBoard(2,"주말이다","삼순이","좋아용","a.jpg");
		boardService = new UploadBoardSeriveceImpl();
		this.test(boardService, board);
		
		//3.Free
		System.out.println("--3. Free Test 입니다. ----");
		board = new FreeBoard(30,"다형성","삼순이","어려워요.");
		test(boardService,board);
	}
	/**
	 * 매개변수를 이용하는 다형성
	 * @param args
	 */
	public void test(BoardService boardService, Board board) {
		//1. 등록
		int result = boardService.insert(board);
		//2. 수정
		boardService.update(board);
		//3. 검색
		Board searchBoard = boardService.selectByBno(board.getBno());
		//4. 추가된 메소드 호출
		boardService.replyInsert();
		//5. static 메서드 호출
		BoardService.selectAll();//인터페이스의 정적메서드는 구현객체없이 바로 접근 가능
	}
	
	public static void main(String[] args) {
		System.err.println("**********Test Start");
		new MainApp();
		
	}

}
