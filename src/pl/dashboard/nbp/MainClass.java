package pl.dashboard.nbp;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import com.google.gson.Gson;

public class MainClass {

	static final INBPApplication application = new NBPApplicationImpl();
	
	private static final CurrencyRates getCurrency(final String code, NBPExchangeRatesTable response) {
		return response.getRates().stream()
				.filter(x -> code.equals(x.getCode()))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(String.format("Nie znaleziono waluty %s", code)));
	}

	private static void printOutput(NBPExchangeRatesTable currencyTable) {
        System.out.println(String.format("Data: %t", currencyTable.getEffectiveDate()));
        System.out.println("Waluta = kupno; sprzedaż");
        System.out.println(getCurrency("EUR", currencyTable));
        System.out.println(getCurrency("CHF", currencyTable));
        System.out.println(getCurrency("USD", currencyTable));
        System.out.println(getCurrency("GBP", currencyTable));		
	}	

	public static void main(String[] args) throws Exception {
		try {
			NBPRequest request = NBPRequestParser.parseArgs(args);
	        printOutput(application.getFromXML(request));
		} catch(IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} catch(FileNotFoundException fnf) {
			System.out.println(String.format("Dla podanego argumentu %s nie znaleziono danych", args[0]));			
		} 

	}
}
