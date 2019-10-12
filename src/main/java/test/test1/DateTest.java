package test.test1;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @date 2019-08-24
 * @author kcx
 * @description ��ȡ��ǰ����
 */
public class DateTest {

	public static void main(String[] args) {
		
		/**
		 * ��һ��
		 */
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHСʱmm��ss��");
		System.out.println(sdf.format(date));
		
		/**
		 * �ڶ���
		 */
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		System.out.println(year+"-"+month+"-"+day+" "+hour+"Сʱ"+minute+"��"+second+"��");

		/**
		 * ������
		 */
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HHСʱmm��ss��");
		System.out.println(dtf.format(ldt));
	}

}
