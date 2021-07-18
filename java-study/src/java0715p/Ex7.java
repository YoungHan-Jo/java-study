package java0715p;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex7 {

	public static void main(String[] args) {
		System.out.println("apple.jpg 이미지 파일을 읽어서 apple-복사본.jpg 파일을 생성하는 프로그램.");

		String projectPath = System.getProperty("user.dir");

		String inputPath = projectPath + "\\temp\\apple.jpg";
		String outputPath = projectPath + "\\temp\\apple-복사본.jpg";

		BufferedInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new BufferedInputStream(new FileInputStream(inputPath));
			out = new FileOutputStream(outputPath);
			
			int data = 0;
			
			while((data = in.read()) != -1) {
				out.write(data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("프로그램 종료");
	} // end of main

}
