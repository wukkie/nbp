package pl.dashboard.nbp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NBPApplicationImplTest {

	INBPApplication app;  
	
	@Before
	public void  prepare() {
		app =  new NBPApplicationImpl(new NBPApplicationConfig(), new NBPRequestParser(), new NBPURLParser());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void unsupportedFormatInRequest() throws Exception {
		app.get(new NBPRequestBuilder().setFormat("HTML").build());
	}

}
