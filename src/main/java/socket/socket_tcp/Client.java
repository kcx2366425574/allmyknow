package socket.socket_tcp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @date 2019-11-07
 * @author kcx
 * @description 
 */
public class Client {
	
	public static void main(String[] args) {

		Socket socket = null;
		PrintWriter pWriter = null;
		
		try {
			socket = new Socket("127.0.0.1", 28888);
			pWriter = new PrintWriter(socket.getOutputStream());
			pWriter.write("我是旷聪贤");
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				pWriter.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
