package pl.dashboard.nbp;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.junit.Test;

public class NBPRequestParserTest {

	private Date getDate(String date)  {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Test
	public void twoArguments() {
		NBPRequest request = NBPRequestParser.parseArgs(new String[] {"2018-10-10", "FakeArg"} );
		assertEquals(request.getDate(), getDate("2018-10-10") );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void wrongDate() {
		NBPRequestParser.parseArgs(new String[] {"2018-13-10"} );
	}	

	@Test(expected = IllegalArgumentException.class)
	public void argsAreNull() {
		 NBPRequestParser.parseArgs(null);
	}	
	
	@Test
	public void rightDate() {
		NBPRequest request = NBPRequestParser.parseArgs(new String[] {"2018-10-10"} );
		assertEquals(request.getDate(), getDate("2018-10-10") );
	}	

}
