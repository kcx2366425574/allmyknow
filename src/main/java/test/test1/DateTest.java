package test.test1;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @date 2019-08-24
 * @author kcx
 * @description 获取当前日期
 */
public class DateTest {

	public static void main(String[] args) {
		
		/**
		 * 第一代
		 */
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH小时mm分ss秒");
		System.out.println(sdf.format(date));
		
		/**
		 * 第二代
		 */
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		System.out.println(year+"-"+month+"-"+day+" "+hour+"小时"+minute+"分"+second+"秒");

		/**
		 * 第三代
		 */
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH小时mm分ss秒");
		System.out.println(dtf.format(ldt));
	}

}
