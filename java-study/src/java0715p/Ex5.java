package java0715p;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex5 {

	public static void main(String[] args) {
		System.out.println("test2.txt파일을 읽어서 모니터 콘솔로 출력");

		String projectPath = System.getProperty("user.dir");

		String path = projectPath + "\\temp\\test2.txt";

		BufferedReader reader = null;

		try {
			
			reader = new BufferedReader(new FileReader(path));
			
			String line = "";
			
			while((line = reader.readLine())!=null) {
				System.out.print(line+"\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("프로그램 종료");
	}// end of main

}
