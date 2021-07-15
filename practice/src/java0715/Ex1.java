package java0715;

import java.io.File;
import java.util.Date;

public class Ex1 {

	public static void main(String[] args) {

	String projectPath = System.getProperty("user.dir");
		
		String filePath = projectPath + "\\temp\\test2.txt";
		String directoryPath = projectPath + "\\temp";
		
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
		
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(new Date(file.lastModified()));
		System.out.println(file.length() + "byte");
		System.out.println(file.canWrite()); // 권한 확인
		System.out.println(file.exists());
		
		System.out.println("===========================================");
		File[] files = dirFile.listFiles();
		
		for(File f : files) {
			System.out.print(f.getName());
			System.out.print("\t" + f.length() + "byte");
			System.out.println("\t" + (f.isDirectory()? "디렉토리" : ""));
		}
		
		System.out.println();
	}

}
