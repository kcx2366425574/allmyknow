package socket.socket_tcp.socketthread;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @date 2019-09-01
 * @author kcx
 * @description 
 *
 */
public class Server {
	public static void main(String[] args) {
		
		try {
			/**
			 * 1.创建一个服务器端socket,即serversocket，指定绑定的端口，并监听此端口
			 */
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			
			/**
			 * 记录连接客户端得到数量
			 */
			int count = 0;
			while(true) {
				
				/**
				 * 2.循环调用accept()方法开始监听，等待客户端连接
				 */
				socket = serverSocket.accept();
				
				/**
				 * 创建一个新的线程
				 */
				ServerThread serverThread = new ServerThread(socket);
				
				
				/**
				 * 启动线程
				 */
				serverThread.start();
				
				count++;
				System.out.println("客户端的数量为："+count);
				
				InetAddress inetAddress = socket.getInetAddress();
				System.out.println("IP地址："+inetAddress.getHostAddress());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
