package test.board;

public class FreeBoard extends Board {
   public FreeBoard() {}
	public FreeBoard(int bno, String subject, String writer, String content) {
		super(bno, subject, writer, content);
		
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		return builder.toString();
	}
   
}
