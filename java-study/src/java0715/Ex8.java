package java0715;

import java.io.File;

public class Ex8 {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		String filePath = projectPath + "\\java-study\\src\\temp\\test2.txt";
		String directoryPath = projectPath + "\\src\\temp";
		
		
		File file = new File(filePath); // test2.txt 파일
		File dirFile = new File(directoryPath); // temp 디렉토리
		
		System.out.println(file.exists()); // 존재여부 true/false
		System.out.println("isFile : " +file.isFile());
		System.out.println("isDirectory : " + file.isDirectory());
		
		System.out.println(dirFile.exists());
		System.out.println("isFile : " +dirFile.isFile());
		System.out.println("isDirectory : " + dirFile.isDirectory());
		
		System.out.println("================================================");
		
		String dirName = directoryPath +"\\temp\\java_sample\\aa\\bb";
		File dirFile2 = new File(dirName);
		if(dirFile2.exists() == false) {
			dirFile2.mkdirs();
		}
		
		dirFile2.renameTo(new File(directoryPath +"\\temp\\java_sample\\aa\\bbbb"));
		
		
		System.out.println("프로그램 종료");
	} // end of main

}
