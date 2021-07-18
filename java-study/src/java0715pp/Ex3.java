package java0715pp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		System.out.println("키보드에서 입력받은 데이터를 test.txt 파일로 저장하는 프로그램.");

		String projectPath = System.getProperty("user.dir");
		String savePath = projectPath + "\\temp\\test.txt";

		Scanner scanner = new Scanner(System.in);

		FileWriter writer = null;

		try {
			
			writer = new FileWriter(savePath);
			
			String line = "";
			
			while(scanner.hasNextLine()) {
				line = scanner.nextLine();
				
				writer.write(line + "\n");
				
				writer.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();

			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}// end of main

}
