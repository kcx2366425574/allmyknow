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
 * @description �������̴߳�����
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
			 * 3.��ȡ�ֽ�����������ȡ�ͻ��˷��͵���Ϣ
			 */
			is = socket.getInputStream();
			
			/**
			 * 4.���ֽ�������ת�����ַ�������
			 */
			isr = new InputStreamReader(is);
			
			/**
			 * 5.Ϊ��������ӻ���
			 */
			br = new BufferedReader(isr);
			String info = null;
			/**
			 * ѭ����ȡ�ͻ��˵���Ϣ
			 */
			while ((info = br.readLine()) != null) {
				System.out.println("���Ƿ�����,�ͻ���˵��" + info);
			}
			/**
			 * �ر���Ӧ����Դ
			 */
			socket.shutdownInput();
			
			/**
			 * ��ȡ���������Ӧ�ͻ��˵�����
			 */
			os = socket.getOutputStream();
			
			/**
			 * ��װΪ��ӡ��
			 */
			pw = new PrintWriter(os);
			pw.write("��ӭ��!");
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
