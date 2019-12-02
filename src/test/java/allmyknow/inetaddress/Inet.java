package allmyknow.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;


/**
 * @date 2019-11-04
 * @author kcx
 * @description 
 */
public class Inet {

	
	
	@Test
	public void testInetAddress() {
		try {
			InetAddress address = InetAddress.getByName("www.baidu.com");
			System.out.println(address.toString());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
