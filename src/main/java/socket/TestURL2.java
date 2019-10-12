package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @date 2019-08-29
 * @author kcx
 * @description 使用URl读取网页内容
 *
 */
public class TestURL2 {
	public static void main(String[] args) {
		try {
			URL baidu = new URL("http://www.baidu.com");
			/**
			 * 通过URL的openStream()方法获取URL对象所表示的资源的字节输入流
			 */
			InputStream is = baidu.openStream();
			/**
			 * 将字节输入流转换为字符输入流
			 */
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			/**
			 * 为字符输入流添加缓冲
			 */
			BufferedReader br = new BufferedReader(isr);
			
			/**
			 * 读取数据
			 */
			String data = br.readLine();
			
			while(data!=null) {
				System.out.println(data);
				data = br.readLine();
			}
			
			/**
			 * 关闭输入流
			 */
			br.close();
			isr.close();
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
