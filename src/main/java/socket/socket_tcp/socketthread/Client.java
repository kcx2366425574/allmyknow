package socket.socket_tcp.socketthread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @date 2019-09-01
 * @author kcx
 * @description 客户端
 *
 */
public class Client {

	public static void main(String[] args) {
		
		
		try {
			/**
			 * 1.创建客户端socket，指定服务器地址和端口
			 */
			Socket socket = new Socket("localhost", 8888);
			
			/**
			 * 2.获取字节输出流，向服务器端发送信息
			 */
			OutputStream os = socket.getOutputStream();
			
			/**
			 * 3.将输出流包装成打印流
			 */
			PrintWriter pw = new PrintWriter(os);
			
			pw.write("用户名: tom;密码: 123");
			pw.flush();
			
			socket.shutdownOutput();
			
			/**
			 * 获取输入流，用来读取服务器端的响应信息
			 */
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String info = null;
			
			/**
			 * 循环读取服务器端的信息
			 */
			while((info=br.readLine())!=null) {
				System.out.println("我是客户端,服务器说："+info);
			}
			
			/**
			 * 关闭相关资源
			 */
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
