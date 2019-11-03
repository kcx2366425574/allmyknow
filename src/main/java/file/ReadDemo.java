package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @date 2019-11-02
 * @author kcx
 * @description {@link FileReader}{@link BufferedReader}
 */
public class ReadDemo {

	public static void main(String[] args) {

		BufferedReader br = null;
		try {
			FileReader fr = new FileReader("F:\\Wode\\t.txt");
			br = new BufferedReader(fr);
			String result = null;
		
			while((result=br.readLine())!=null) {
				System.out.println(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
