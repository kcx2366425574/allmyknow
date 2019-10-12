package socket.socket_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @date 2019-09-01
 * @author kcx
 * @description UDP�����
 */
public class Server {

	public static void main(String[] args) throws IOException {
		/**
		 * ������������DatagramSocket��ָ���˿�
		 */
		DatagramSocket socket = new DatagramSocket(8800);
		
		/**
		 * �������ݱ������ڽ��տͻ��˷��͵�����
		 * �����ֽ����飬ָ�����յ����ݱ���С
		 */
		byte[] data = new byte[1024];
		
		DatagramPacket packet = new DatagramPacket(data, data.length);
		
		/**
		 * ���տͻ��˷��͵�����,receive()�������ڽ������ݱ�֮ǰһֱ����
		 */
		socket.receive(packet);
		
		/**
		 * ��ȡ����
		 */
		String info = new String(data,0,packet.getLength());
		
		System.out.println("����UDP���������ͻ���˵��"+info);
	}
}
