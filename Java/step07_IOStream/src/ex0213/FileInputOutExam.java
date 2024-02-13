package ex0213;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutExam {
	public FileInputOutExam() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
//			// byte 단위로 파일 읽기
//			fis = new FileInputStream("src/ex0213/a.txt");
//
////			// 1byte씩 읽기. 한글은 2byte이므로 문자단위 읽기가 편한 것을 확인할 수 있다.
////			while (true) {
////				int i = fis.read();
////				if (i == -1)
////					break;
////				System.out.println(i + "," + (char) i);
////			}
//			
//			int length = fis.available(); //읽을 수 있는 byte 개수 = 파일의 크기.
//			System.out.println("length = "+ length);
//			byte b [] = new byte[length];
//			fis.read(b);	//바이트 배열의 크기만큼 한 번에 읽어서 배열에 저장
////			for(byte bb : b) {
////				System.out.println(bb);
////			}
//			
//			String str = new String(b);
//			System.out.println(str);
			///////////////////////////////////////////
			
			//byte단위로 저장 = 쓰기
			fos = new FileOutputStream("src/ex0213/writer.txt",true);	//기본적으로 덮어쓰기. true값을 주면 이어쓰기.
			fos.write(65);
			fos.write(66);
			fos.write(67);
			
			fos.write(13);
			fos.write(10);
			
			fos.write(70);
			
			//String을 byte배열로 변환
			String message = "안녕하세요. sparkling";
			fos.write(message.getBytes());	//message를 getByte로 바이트 배열로 변환.
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if(fos!=null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		new FileInputOutExam();

	}

}
