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
 * @description ʹ��URl��ȡ��ҳ����
 *
 */
public class TestURL2 {
	public static void main(String[] args) {
		try {
			URL baidu = new URL("http://www.baidu.com");
			/**
			 * ͨ��URL��openStream()������ȡURL��������ʾ����Դ���ֽ�������
			 */
			InputStream is = baidu.openStream();
			/**
			 * ���ֽ�������ת��Ϊ�ַ�������
			 */
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			/**
			 * Ϊ�ַ���������ӻ���
			 */
			BufferedReader br = new BufferedReader(isr);
			
			/**
			 * ��ȡ����
			 */
			String data = br.readLine();
			
			while(data!=null) {
				System.out.println(data);
				data = br.readLine();
			}
			
			/**
			 * �ر�������
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
