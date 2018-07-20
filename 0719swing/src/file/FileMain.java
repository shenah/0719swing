package file;

import java.io.File;
import java.util.Date;

public class FileMain {

	public static void main(String[] args) {
		File f = new File("C:\\Users\\503-03\\Desktop\\java\\15.JavaFX.pptx");
		System.out.println(f.exists());

		long size = f.length();
		System.out.println(size / 1024 + "K");

		Date date = new Date(f.lastModified());
		System.out.println(date);

		File file = new File("C:\\Users\\503-03\\Desktop\\java\\17.git.pptx");
		String parent = file.getParent();
		String filename = file.getName();
		System.out.println(parent);
		System.out.println(filename);

		// filename에서 15.을 제거한 부분을 가져오기
		// .의 위치를 찾아서 .이후의 문자열을 가져오기
		int idx = filename.indexOf('.');
		// 찾고자 하는 위치가 없으면 음수(-1)를 리턴
		if (idx >= 0) {
			// 문자열의 위치를 가지고 자르는 메소드 substring
			filename = filename.substring(idx + 1);
		}
		System.out.println(filename);

	}

}
