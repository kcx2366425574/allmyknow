package socket.socket_tcp.socketthread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @date 2019-09-01
 * @author kcx
 * @description 服务器线程处理类
 */
public class ServerThread extends Thread {

	Socket socket = null;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		InputStream is = null;
		
		
		InputStreamReader isr = null;
		
		
		BufferedReader br = null;
		
		
		OutputStream os = null;
		
		
		PrintWriter pw = null;
		
		try {
			/**
			 * 3.获取字节输入流，读取客户端发送的信息
			 */
			is = socket.getInputStream();
			
			/**
			 * 4.将字节输入流转换成字符输入流
			 */
			isr = new InputStreamReader(is);
			
			/**
			 * 5.为输入流添加缓冲
			 */
			br = new BufferedReader(isr);
			String info = null;
			/**
			 * 循环读取客户端的信息
			 */
			while ((info = br.readLine()) != null) {
				System.out.println("我是服务器,客户端说：" + info);
			}
			/**
			 * 关闭相应的资源
			 */
			socket.shutdownInput();
			
			/**
			 * 获取输出流，响应客户端的请求
			 */
			os = socket.getOutputStream();
			
			/**
			 * 包装为打印流
			 */
			pw = new PrintWriter(os);
			pw.write("欢迎你!");
			pw.flush();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pw!=null) pw.close();
				if(os!=null) os.close();
				if(br!=null) br.close();
				if(isr!=null) isr.close();
				if(is!=null) is.close();
				if(socket!=null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
