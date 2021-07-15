package java0715;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		System.out.println("키보드에서 입력받은 데이터를 test.txt 파일로 저장하는 프로그램.");

		String projectPath = System.getProperty("user.dir"); // 현재 프로젝트 절대경로
		System.out.println(projectPath);

		String classPath = Ex3.class.getResource(".").getPath(); // 현재 경로 정보 가져오기
		System.out.println(classPath);

		String path = projectPath + "\\temp\\test.txt";
		System.out.println(path);

		// 입력 스트림 준비
		Scanner scanner = new Scanner(System.in);

		// 출력 스트림 준비
		FileWriter writer = null;

		try {
			writer = new FileWriter(path);

			String line = "";

			// nextLine()은 '\n'문자 기준으로 '\n' 문자를 제외시켜서 한줄을 가져옴.
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				System.out.print(line + "\n");

				writer.write(line + "\n"); // 여기에 쓸때도 \n 해야함
				// 출력스트림은 대부분 내부적으로 버퍼가 있어서 <- 하나하나 왔다갔다하면 낭비라서 버퍼에 모아둠.
				// write() 호출시 출력내용을 곧장 내보내지 않음. - > 버퍼가 다 찼을때 한번에 내보냄
				writer.flush(); // 바로바로 해야할때는 수동으로 버퍼 비우기
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 닫아줘야함
			scanner.close();

			try {
				writer.close(); // 출력스트림 닫으면 내부적으로 자동으로 flush()가 호출되서 비워짐
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		System.out.println("프로그램 종료.");
	} // end of main

}
