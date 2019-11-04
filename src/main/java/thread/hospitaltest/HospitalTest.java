package thread.hospitaltest;
/*
  @date 2019-08-01
  @Author kcx
*/
public class HospitalTest {

	public static void main(String[] args) {
		
		final Hospital hospital = new Hospital();
		
		Thread thread = new Thread(hospital, "����һ");
		Thread thread2 = new Thread(hospital, "���ڶ�");
		thread2.start();
		Thread thread3 = new Thread(hospital, "������");
		thread3.start();
		Thread thread4 = new Thread(hospital, "������");
		thread4.start();
		thread.start();


	}

}
