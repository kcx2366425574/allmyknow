package socket.socket_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @date 2019-09-01
 * @author kcx
 * @description UDP服务端
 */
public class Server {

	public static void main(String[] args) throws IOException {
		/**
		 * 创建服务器端DatagramSocket，指定端口
		 */
		DatagramSocket socket = new DatagramSocket(8800);
		
		/**
		 * 创建数据报，用于接收客户端发送的数据
		 * 创建字节数组，指定接收的数据报大小
		 */
		byte[] data = new byte[1024];
		
		DatagramPacket packet = new DatagramPacket(data, data.length);
		
		/**
		 * 接收客户端发送的数据,receive()方法会在接收数据报之前一直阻塞
		 */
		socket.receive(packet);
		
		/**
		 * 读取数据
		 */
		String info = new String(data,0,packet.getLength());
		
		System.out.println("我是UDP服务器，客户端说："+info);
	}
}
