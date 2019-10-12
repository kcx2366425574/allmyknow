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
		 * 创建一个URL实例
		 */
		try {
			URL imooc = new URL("http://www.imooc.com");
			URL url = new URL(imooc, "/index.html?username=tom#test");
			
			System.out.println("协议："+url.getProtocol());
			System.out.println("主机："+url.getHost());
			/**
			 * 如果未指定端口号，则使用默认的端口号，此时getport()返回值为-1
			 */
			System.out.println("端口号："+url.getPort());
			System.out.println("文件路径："+url.getPath());
			System.out.println("文件名:"+url.getFile());
			System.out.println("相对路径:"+url.getRef());
			System.out.println("查询字符串："+url.getQuery());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
}
