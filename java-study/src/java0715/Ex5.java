package java0715;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex5 {

	public static void main(String[] args) {
		System.out.println("test2.txt파일을 읽어서 모니터 콘솔로 출력");

		String projectPath = System.getProperty("user.dir"); // 현재 프로젝트 절대경로

		String path = projectPath + "\\temp\\test2.txt"; // <- \t 로하면 탭으로 인식해서 \\t
		System.out.println(path); // C:\Users\YoungHan-Jo\Desktop\java-study\src\temp\test2.txt

		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(path));

			String line = "";
			while ((line = reader.readLine()) != null) { // readLine()은 \n 단위로 가져옴.
				System.out.print(line + "\n"); // 입력할때는 \n까지 들고오지 않기 때문에 수동으로 \n
				// 다른 프로그램에서는 \n붙어있는 메서드가 없기때문에.

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("프로그램종료");
	}// end of main

}
