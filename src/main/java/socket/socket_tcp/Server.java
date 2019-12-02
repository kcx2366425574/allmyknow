package socket.socket_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.net.SocketServer;

/**
 * @date 2019-11-07
 * @author kcx
 * @description 
 */
public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		BufferedReader bReader = null;
		Socket socket = null;
		
		
		try {
			serverSocket = new ServerSocket(28888);
			socket = serverSocket.accept();
			
			bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String strMsg = null;
			if((strMsg=bReader.readLine())!=null) {
				System.out.println(strMsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
