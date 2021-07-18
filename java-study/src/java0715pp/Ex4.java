package java0715pp;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4 {

	public static void main(String[] args) {
		System.out.println("키보드에서 입력받은 데이터를 test2.txt 파일로 저장하는 프로그램.");

		String projectPath = System.getProperty("user.dir");
		String savePath = projectPath + "\\temp\\test2.txt";

		BufferedReader reader = null;
		FileWriter writer = null;

		try {
			reader = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
			writer = new FileWriter(savePath);

			String line = "";

			while ((line = reader.readLine()) != null) {
				writer.write(line + "\n");
				writer.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("프로그램 종료");
	}// end of main

}
