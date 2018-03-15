package scc.hibernate.surge.dto;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Java UUID Using Constructor
 *
 */
public class UUIDgenerator {

	public static UUID Generate() {
		long msb = System.currentTimeMillis();
		Random ran = new Random();
		int n = ran.nextInt(9) + 1;
		
		try {
			TimeUnit.MILLISECONDS.sleep(n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long lsb = System.currentTimeMillis() + n;
		//initialize uuid
		UUID uuid = new UUID(msb, lsb);
		//System.out.println(n);
		//System.out.println("msb: " + msb);
		//System.out.println("lsb: " + lsb);
		return uuid;
	}

}