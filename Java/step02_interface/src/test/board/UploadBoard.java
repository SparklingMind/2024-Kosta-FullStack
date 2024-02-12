package test.board;

/**
 * 자료실게시판 속성관리 객체
 */
public class UploadBoard extends Board {
    private String fileName; // 첨부파일

    public UploadBoard() {

    }

    public UploadBoard(String fileName) {
        this.fileName = fileName;
    }

    public UploadBoard(int bno, String subject, String writer, String content, String fileName) {
        super(bno, subject, writer, content);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(fileName);
		builder.append("]");
		return builder.toString();
	}


}
