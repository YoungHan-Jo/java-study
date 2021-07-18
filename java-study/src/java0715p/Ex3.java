package java0715p;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		System.out.println("키보드에서 입력받은 데이터를 test.txt 파일로 저장하는 프로그램.");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		String classPath = Ex3.class.getResource(".").getPath();
		System.out.println(classPath);
		
		String path = projectPath + "\\temp\\test.txt";
		
		//입력 스트림 준비
		Scanner scanner = new Scanner(System.in);
		
		//출력스트림 준비
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(path);
			
			String line = "";
			
			while(scanner.hasNextLine()) {
				line = scanner.nextLine();
				System.out.println(line + "\n");
				
				writer.write(line + "\n");
				
				writer.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			scanner.close();
			
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("프로그램 종료");
		
	} // end of main

}
