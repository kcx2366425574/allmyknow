package thread.queryflight;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @date 2019-07-21
 * @author afsl
 *
 */
public class FlightQueryTask extends Thread implements FlightQuery {

	private String origin ;
	private String destination;
	private List<String> flightList = new ArrayList<String>();
	
	
	
	public FlightQueryTask(String airline,String origin, String destination) {
		super("["+airline+"]");
		this.origin = origin;
		this.destination = destination;
	}



	@Override
	public void run() {
		System.out.println(getName()+"-query from "+origin+" to "+destination);
		int randomVal = ThreadLocalRandom.current().nextInt(10);
		try {
			TimeUnit.SECONDS.sleep(randomVal);
			this.flightList.add(getName()+"-"+randomVal);
			System.out.println("the flight:"+getName()+" list query successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	@Override
	public List<String> getFlight() {
		return this.flightList;
	}
	
	

}
