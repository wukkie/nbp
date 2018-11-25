package pl.dashboard.nbp;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class NBPRequestParser {

	private static void validate(String[] args) throws IllegalArgumentException {
		if(args == null || args.length <= 0) throw new IllegalArgumentException("Nie podano argumentów.");
	}
	
	private static SimpleDateFormat getSimpleDateFormat() {
	    SimpleDateFormat date = new SimpleDateFormat(NBPApplicationConfig.ARG_DATE_FORMAT);
	    date.setLenient(false);
	    return date;
	}

	private static Date parseDate(String date) throws IllegalArgumentException {
		Date validDate; 
	    try {
	    	validDate = getSimpleDateFormat().parse(date.trim());
	    } catch (ParseException pe) {
	    	throw new IllegalArgumentException(String.format("Format daty '%s' jest błędny. Prawidłowy format to %s", date, NBPApplicationConfig.ARG_DATE_FORMAT));
	    }
	    return validDate;
	}
	
	private static String getTable(String arg) {
		return NBPApplicationConfig.tableTypes.TABLE_TYPE_C;
	}
	
	private static String getTableType(String arg) {
		return NBPApplicationConfig.type.EXCHANGE_TABLES;
	}	
	
	private static String getType(String arg) {
		return NBPApplicationConfig.type.EXCHANGE_TABLES;
	}	
	
	private static String getFormat(String arg) {
		return NBPApplicationConfig.format.XML;
	}	

	public static NBPRequest parseArgs(String[] args) throws IllegalArgumentException {
		validate(args);
		return new NBPRequestBuilder()
				.setTable(getTable(null))
				.setType(getType(null))
				.setFormat(getFormat(null))
				.setDate(parseDate(args[0]))
				.build();
	}
}
