package ex0213;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class BufferedFileCopyExam {
	public BufferedFileCopyExam(String readName, String writeName) throws Exception {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(readName);
			fos = new FileOutputStream(writeName);
			
			//Buffered 적용
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			int i = 0;
			while ((i = bis.read()) != -1) {
				bos.write(i);
				
			}
			System.out.println("복사 완료되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 닫기
			try {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws Exception {
		String readName = JOptionPane.showInputDialog("읽을 파일 이름?");
		String writeName = JOptionPane.showInputDialog("저장할 파일 이름?");
		
		long start = System.nanoTime(); //복사 시작 시간, 끝나는 시간 구해서 복사에 걸리는 시간 구하기.
		new BufferedFileCopyExam(readName, writeName);
		long end = System.nanoTime();
		
		System.out.println("Buffered를 사용해서 총 " + (end-start) + " nanotime 걸림.");	//Bufferd 보조스트림을 사용하는 것이 훨씬 시간이 덜 걸린다.
	}

}
