package socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.junit.Test;

/**
 * @date 2019-08-29
 * @author kcx
 * @description {@link InetAddress}
 *
 */
public class TestInetAddress {

	public static void main(String[] args) throws UnknownHostException {
		
		/**
		 * ��ȡ������InetAddressʵ��
		 */
		InetAddress address = InetAddress.getLocalHost();
		
		System.out.println("��������ƣ�"+address.getHostName());
		
		System.out.println("IP��ַ��"+address.getHostAddress());
		
		/**
		 * ��ȡ�ֽ�������ʽ��IP��ַ
		 */
		byte[] bytes = address.getAddress();
		
		System.out.println("�ֽ�������ʽ��IP��ַ:"+Arrays.toString(bytes));
		
		/**
		 * ֱ�����InetAddress����
		 */
		System.out.println(address);
		
		System.out.println("------------------------------");
		
		InetAddress address2 = InetAddress.getByName("192.168.223.1");
		
		System.out.println("��������ƣ�"+address2.getHostName());
		
		System.out.println("IP��ַ��"+address2.getHostAddress());		
		
	}
	
	
}
