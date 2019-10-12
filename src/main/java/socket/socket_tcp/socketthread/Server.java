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
			 * 1.����һ����������socket,��serversocket��ָ���󶨵Ķ˿ڣ��������˶˿�
			 */
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			
			/**
			 * ��¼���ӿͻ��˵õ�����
			 */
			int count = 0;
			while(true) {
				
				/**
				 * 2.ѭ������accept()������ʼ�������ȴ��ͻ�������
				 */
				socket = serverSocket.accept();
				
				/**
				 * ����һ���µ��߳�
				 */
				ServerThread serverThread = new ServerThread(socket);
				
				
				/**
				 * �����߳�
				 */
				serverThread.start();
				
				count++;
				System.out.println("�ͻ��˵�����Ϊ��"+count);
				
				InetAddress inetAddress = socket.getInetAddress();
				System.out.println("IP��ַ��"+inetAddress.getHostAddress());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
