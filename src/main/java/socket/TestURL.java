package socket;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @date 2019-08-29
 * @author kcx
 *
 */
public class TestURL {

	public static void main(String[] args) {
		/**
		 * ����һ��URLʵ��
		 */
		try {
			URL imooc = new URL("http://www.imooc.com");
			URL url = new URL(imooc, "/index.html?username=tom#test");
			
			System.out.println("Э�飺"+url.getProtocol());
			System.out.println("������"+url.getHost());
			/**
			 * ���δָ���˿ںţ���ʹ��Ĭ�ϵĶ˿ںţ���ʱgetport()����ֵΪ-1
			 */
			System.out.println("�˿ںţ�"+url.getPort());
			System.out.println("�ļ�·����"+url.getPath());
			System.out.println("�ļ���:"+url.getFile());
			System.out.println("���·��:"+url.getRef());
			System.out.println("��ѯ�ַ�����"+url.getQuery());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
}
