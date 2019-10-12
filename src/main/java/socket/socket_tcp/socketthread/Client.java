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
 * @description �ͻ���
 *
 */
public class Client {

	public static void main(String[] args) {
		
		
		try {
			/**
			 * 1.�����ͻ���socket��ָ����������ַ�Ͷ˿�
			 */
			Socket socket = new Socket("localhost", 8888);
			
			/**
			 * 2.��ȡ�ֽ����������������˷�����Ϣ
			 */
			OutputStream os = socket.getOutputStream();
			
			/**
			 * 3.���������װ�ɴ�ӡ��
			 */
			PrintWriter pw = new PrintWriter(os);
			
			pw.write("�û���: tom;����: 123");
			pw.flush();
			
			socket.shutdownOutput();
			
			/**
			 * ��ȡ��������������ȡ�������˵���Ӧ��Ϣ
			 */
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String info = null;
			
			/**
			 * ѭ����ȡ�������˵���Ϣ
			 */
			while((info=br.readLine())!=null) {
				System.out.println("���ǿͻ���,������˵��"+info);
			}
			
			/**
			 * �ر������Դ
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
