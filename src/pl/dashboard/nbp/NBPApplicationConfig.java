package pl.dashboard.nbp;

public class NBPApplicationConfig {

	/* NBP API Request Parameters */
	public static class tableTypes {
		public static final String TABLE_TYPE_A = "A";
		public static final String TABLE_TYPE_B = "B";
		public static final String TABLE_TYPE_C = "C";		
	}

	public static class format {
		public static final String JSON = "json";
		public static final String XML = "xml";
	}

	public static class type {
		public static final String EXCHANGE_TABLES = "exchangerates/tables";
	}

	/* NBP API Request Parameters */
	public static final String ARG_DATE_FORMAT = "yyyy-MM-dd";
	public final static String  NBPURL = "http://api.nbp.pl/api/";	
}
