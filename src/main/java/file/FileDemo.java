package file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @date 2019-11-01
 * @author kcx
 * @description 匿名类过滤筛选文件
 */
public class FileDemo {

	public static void main(String[] args) {
		File file = new File("F:\\Wode\\t.txt");
		
		System.out.println(file.getName());
		
		System.out.println(file.getParent());
		
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("-----------------------");
		File newFile = new File(".");
		String[] filename = newFile.list();
		for (String string : filename) {
			System.out.println(string);
		}
		
		/**
		 * FilenameFilter是文件过滤器接口，使用匿名类实现accept()方法
		 */
		String[] lists = newFile.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				
				return (name.startsWith("."));
			}
		});
		System.out.println("...........................");
		for (String string : lists) {
			System.out.println(string);
		}
		
	}

}
