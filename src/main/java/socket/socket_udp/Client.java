package socket.socket_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @date 2019-09-01
 * @author kcx
 * @description UDP�ͻ���
 */
public class Client {

	public static void main(String[] args) throws IOException {
		/**
		 * �����������ַ���˿ںţ�����
		 */
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		
		byte[] data = "�û���: admin,����: 123".getBytes();
		
		/**
		 * �������ݱ����������͵�������Ϣ
		 */
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		
		/**
		 * ����DatagramSocket����
		 */
		DatagramSocket socket = new DatagramSocket();
		
		/**
		 * ��������˷������ݱ�
		 */
		socket.send(packet);
		
		/**
		 * ���շ���������Ӧ������
		 * 1.�������ݱ������ڽ��շ���������Ӧ������
		 */
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		
		socket.receive(packet2);
		
		/**
		 * ��ȡ����
		 */
		String reply = new String(data2, 0, packet2.getLength());
		System.out.println("���ǿͻ��ˣ�������˵:"+reply);
		
		/**
		 * �ر���Դ
		 */
		socket.close();
	}
}
