package socket.socket_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @date 2019-08-30
 * @author kcx
 * @description 服务端，基于TCP协议的Socket通信，实现用户登录
 *
 */
public class Server {
	public static void main(String[] args) {
		
		try {
			/**
			 * 1.创建一个服务器端socket,即serversocket，指定绑定的端口，并监听此端口
			 */
			ServerSocket serverSocket = new ServerSocket(8888);
			
			/**
			 * 2.调用accept()方法开始监听，等待客户端连接
			 */
			Socket socket = serverSocket.accept();
			
			/**
			 * 3.获取字节输入流，读取客户端发送的信息
			 */
			InputStream is = socket.getInputStream();
			
			/**
			 * 4.将字节输入流转换成字符输入流
			 */
			InputStreamReader isr = new InputStreamReader(is);
			
			/**
			 * 5.为输入流添加缓冲
			 */
			BufferedReader br = new BufferedReader(isr);
			
			String info = null;
			
			/**
			 * 循环读取客户端的信息
			 */
			while((info=br.readLine())!=null) {
				System.out.println("我是服务器,客户端说："+info);
			}
			
			/**
			 * 关闭相应的资源
			 */
			socket.shutdownInput();
			
			/**
			 * 获取输出流，相应客户端的请求
			 */
			OutputStream os = socket.getOutputStream();
			
			/**
			 * 包装为打印流
			 */
			PrintWriter pw = new PrintWriter(os);
			
			pw.write("欢迎你!");
			pw.flush();
			
			pw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
