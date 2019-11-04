package thread.queryflight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 2019-07-23
 * @author kcx
 *
 */
public class QueryFlightExample {
	
	//�����ĸ���˾
	private static List<String> flightCompany = Arrays.asList("CSA","CEA","HNA");
	
	

	public static void main(String[] args) {
		
		List<String> results =search("SH", "BJ");
		System.out.println("=========result==========");
		for (String string : results) {
			System.out.println(string);
		}

	}
	
	private static List<String> search(String original,String dest){
		
		final List<String> result  = new ArrayList<String>();
		
		//������ѯ������Ϣ���߳��б�
		List<FlightQueryTask> tasks =new ArrayList<FlightQueryTask>();
		for(int i= 0;i<flightCompany.size();i++) {
			FlightQueryTask flightQueryTask = createFlightQueryTask(flightCompany.get(i), original, dest);
			tasks.add(flightQueryTask);
		}
		
		tasks.forEach(Thread::start);
		
		tasks.forEach(t->{
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		for(int i = 0;i<tasks.size();i++) {
			List<String> l = tasks.get(i).getFlight();
			for (String string : l) {
				result.add(string);
			}
		}
		return result;
	}
	
	private static FlightQueryTask createFlightQueryTask(String flight,String original,String dest) {
		return new FlightQueryTask(flight, original, dest);
	}

}
