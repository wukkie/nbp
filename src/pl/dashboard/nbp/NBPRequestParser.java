package pl.dashboard.nbp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class NBPRequestParser {
	
	private static Date parseDate(String date) throws IllegalArgumentException {
		Date validaDate; 
	    SimpleDateFormat dateFormat = new SimpleDateFormat(NBPApplicationConfig.ARG_DATE_FORMAT);
	    dateFormat.setLenient(false);
	    try {
	    	validaDate = dateFormat.parse(date.trim());
	    } catch (ParseException pe) {
	    	throw new IllegalArgumentException(String.format("Format daty '%s' jest błędny. Prawidłowy format to %s", date, NBPApplicationConfig.ARG_DATE_FORMAT));
	    }
	    return validaDate;
	}
	
	private static void validate(String[] args) throws  IllegalArgumentException {
		if(args == null || args.length <= 0) throw new IllegalArgumentException("Nie podano argumentów.");
	}
	
	public static NBPRequest parseArgs(String[] args) throws IllegalArgumentException {
		validate(args);
		return new NBPRequestBuilder()
				.setTable(NBPApplicationConfig.tableTypes.TABLE_TYPE_C)
				.setType(NBPApplicationConfig.type.EXCHANGE_TABLES)
				.setFormat(NBPApplicationConfig.format.XML)
				.setDate(parseDate(args[0]))
				.build();
	}
}
