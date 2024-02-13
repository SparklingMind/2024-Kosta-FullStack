package ex0213;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

public class AutoClosableBufferedFileCopyExam {
    public AutoClosableBufferedFileCopyExam(String readName, String writeName) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(readName));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(writeName))) {

            int i;
            while ((i = bis.read()) != -1) {
                bos.write(i);
            }
            System.out.println("복사 완료되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        boolean fileReadSuccess = false;
        String readName = "";
        while (!fileReadSuccess) {
            readName = JOptionPane.showInputDialog("읽을 파일 이름?");
            if (new File(readName).exists()) {
                fileReadSuccess = true;
            } else {
                JOptionPane.showMessageDialog(null, "파일이 존재하지 않습니다. 다시 입력해주세요.");
            }
        }

        String writeName = JOptionPane.showInputDialog("저장할 파일 이름?");

        long start = System.nanoTime(); // 복사 시작 시간
        new AutoClosableBufferedFileCopyExam(readName, writeName);
        long end = System.nanoTime(); // 복사 끝나는 시간

        System.out.println("Buffered를 사용해서 총 " + (end - start) + " nanotime 걸림.");
    }
}
