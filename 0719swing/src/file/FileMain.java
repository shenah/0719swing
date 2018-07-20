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

		// filename���� 15.�� ������ �κ��� ��������
		// .�� ��ġ�� ã�Ƽ� .������ ���ڿ��� ��������
		int idx = filename.indexOf('.');
		// ã���� �ϴ� ��ġ�� ������ ����(-1)�� ����
		if (idx >= 0) {
			// ���ڿ��� ��ġ�� ������ �ڸ��� �޼ҵ� substring
			filename = filename.substring(idx + 1);
		}
		System.out.println(filename);

	}

}
