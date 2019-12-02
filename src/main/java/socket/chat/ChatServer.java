package socket.chat;
/**
 * @date 2019-11-05
 * @author kcx
 * @description 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;

public class ChatServer {

	/**
	 * 声明服务器端套接字
	 */
	ServerSocket serverSocket;
	
	/**
	 * 输入流列表集合
	 */
	ArrayList<BufferedReader> brList = new ArrayList<BufferedReader>();
	
	/**
	 * 输出流列表集合
	 */
	ArrayList<PrintWriter> pWriters = new ArrayList<PrintWriter>();
	
	/**
	 * 聊天信息链表集合
	 */
	LinkedList<String> msgList = new LinkedList<String>();
	
	public ChatServer() {
		/**
		 * 创建服务器端套接字ServerSocket,在28888端口监听
		 */
		try {
			serverSocket = new ServerSocket(28888);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * 创建接收客户端Socket的线程实例，并启动
		 */
		new AcceptSocketThread().start();
		
		/**
		 * 创建给服务端发送信息的线程实例，并启动
		 */
		new SendMsgToClient().start();
		System.out.println("服务器已启动……");
		
	}
	
	//接收客户端Socket套接字线程
	class AcceptSocketThread extends Thread{
		public void run() {
			while(this.isAlive()) {
				try {
					Socket socket = serverSocket.accept();
					/**
					 * 建立该客户端的通信管道
					 */
					if(socket!=null) {
						/**
						 * 获取socket对象的输入流
						 */
						BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						
						/**
						 * 将输入流添加到输入流列表集合中
						 */
						brList.add(br);
						/**
						 * 开启一个线程接收该客户端的聊天信息
						 */
						new GetMsgFromClient(br).start();
						
						/**
						 * 获取socket对象的输出流，并添加到列表集合中
						 */
						pWriters.add(new PrintWriter(socket.getOutputStream()));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 接收客户端的聊天信息的线程
	 * @author kcx
	 *
	 */
	class GetMsgFromClient extends Thread{
		BufferedReader bReader;
		public GetMsgFromClient(BufferedReader bReader) {
			this.bReader = bReader;
		}
		
		public void run() {
			while(this.isAlive()) {
				try {
					/**
					 * 从输入流中读取一行信息
					 */
					String msg = bReader.readLine();
					if(msg!=null) {
						/**
						 * SimpleDateFormat日期格式化类，指定日期格式为
						 * “年-月-日   时-分-秒”，例如“2019-11-05 22:53:33”
						 */
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						/**
						 * 获取当前系统时间，并使用日期转化类格式转化为指定格式的字符串
						 */
						String strTime = sdf.format(new Date());
						/**
						 * 将时间和信息添加到信息链表集合中
						 */
						msgList.addFirst("<==  "+strTime+"  ==>"+msg);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 给所有客户发送聊天信息的线程
	 * @author kcx
	 *
	 */
	class SendMsgToClient extends Thread{
		public void run() {
			while(this.isAlive()) {
				try {
					/**
					 * 如果信息列表集合不为空（还有聊天信息未发送）
					 */
					if(!msgList.isEmpty()) {
						/**
						 * 读取信息列表最后一条，并移除
						 */
						String msg = msgList.removeLast();
						/**
						 * 对输出流列表集合进行遍历，循环发送信息给所有客户端
						 */
						for(int i = 0;i<pWriters.size();i++) {
							pWriters.get(i).println(msg);
							pWriters.get(i).flush();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
