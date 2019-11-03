package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @date 2019-11-02
 * @author kcx
 * @description {@link InputStream}读取文件内容  {@link OutputStream} 写入文件内容
 */
public class InputStreamDemo {

	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("F:\\Wode\\t.txt");
			fos = new FileOutputStream("F:\\Wode\\2.txt");
			/**
			 * 如果FileOutputStream()构造方法中有boolean append参数，表明是否将新的内容追加到文件的末尾
			 */
			
			//fos = new FileOutputStream("F:\\Wode\\2.txt",true);
			
			/**
			 * 创建一个长度为1024的字节数组作为缓冲区
			 */
			byte[] bytes = new byte[1024];
			
			/**
			 * 用于保存实际读取的字节数
			 */
			int hasread = 0;
			
			while((hasread=fis.read(bytes))>0) {
				System.out.print(new String(bytes, 0, hasread));
				fos.write(bytes, 0, hasread);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void readfile() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("F:\\Wode\\t.txt");
			fos = new FileOutputStream("F:\\Wode\\2.txt");
			byte[] bytes = new byte[1024];
			int hasread = 0;
		
			
			
			while((hasread=fis.read(bytes))>0) {
				System.out.print(new String(bytes, 0, hasread));
				fos.write(bytes, 0, hasread);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
