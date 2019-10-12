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
 * @description ����ˣ�����TCPЭ���Socketͨ�ţ�ʵ���û���¼
 *
 */
public class Server {
	public static void main(String[] args) {
		
		try {
			/**
			 * 1.����һ����������socket,��serversocket��ָ���󶨵Ķ˿ڣ��������˶˿�
			 */
			ServerSocket serverSocket = new ServerSocket(8888);
			
			/**
			 * 2.����accept()������ʼ�������ȴ��ͻ�������
			 */
			Socket socket = serverSocket.accept();
			
			/**
			 * 3.��ȡ�ֽ�����������ȡ�ͻ��˷��͵���Ϣ
			 */
			InputStream is = socket.getInputStream();
			
			/**
			 * 4.���ֽ�������ת�����ַ�������
			 */
			InputStreamReader isr = new InputStreamReader(is);
			
			/**
			 * 5.Ϊ��������ӻ���
			 */
			BufferedReader br = new BufferedReader(isr);
			
			String info = null;
			
			/**
			 * ѭ����ȡ�ͻ��˵���Ϣ
			 */
			while((info=br.readLine())!=null) {
				System.out.println("���Ƿ�����,�ͻ���˵��"+info);
			}
			
			/**
			 * �ر���Ӧ����Դ
			 */
			socket.shutdownInput();
			
			/**
			 * ��ȡ���������Ӧ�ͻ��˵�����
			 */
			OutputStream os = socket.getOutputStream();
			
			/**
			 * ��װΪ��ӡ��
			 */
			PrintWriter pw = new PrintWriter(os);
			
			pw.write("��ӭ��!");
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
