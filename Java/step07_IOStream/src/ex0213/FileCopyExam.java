package ex0213;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class FileCopyExam {
	public FileCopyExam(String readName, String writeName) throws Exception {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(readName);
			fos = new FileOutputStream(writeName);

			int i = 0;
			while ((i = fis.read()) != -1) {
				fos.write(i);
				
			}
			System.out.println("복사 완료되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 닫기
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws Exception {
		String readName = JOptionPane.showInputDialog("읽을 파일 이름?");
		String writeName = JOptionPane.showInputDialog("저장할 파일 이름?");
		
		long start = System.nanoTime(); //복사 시작 시간, 끝나는 시간 구해서 복사에 걸리는 시간 구하기.
		new FileCopyExam(readName, writeName);
		long end = System.nanoTime();
		
		System.out.println("Buffered 없이 총 " + (end-start) + " nanotime 걸림.");
	}

}