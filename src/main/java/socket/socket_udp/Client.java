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
 * @description UDP客户端
 */
public class Client {

	public static void main(String[] args) throws IOException {
		/**
		 * 定义服务器地址、端口号，数据
		 */
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		
		byte[] data = "用户名: admin,密码: 123".getBytes();
		
		/**
		 * 创建数据报，包含发送的数据信息
		 */
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		
		/**
		 * 创建DatagramSocket对象
		 */
		DatagramSocket socket = new DatagramSocket();
		
		/**
		 * 向服务器端发送数据报
		 */
		socket.send(packet);
		
		/**
		 * 接收服务器端响应的数据
		 * 1.创建数据报，用于接收服务器端响应的数据
		 */
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		
		socket.receive(packet2);
		
		/**
		 * 读取数据
		 */
		String reply = new String(data2, 0, packet2.getLength());
		System.out.println("我是客户端，服务器说:"+reply);
		
		/**
		 * 关闭资源
		 */
		socket.close();
	}
}
