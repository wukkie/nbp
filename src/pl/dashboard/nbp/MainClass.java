package pl.dashboard.nbp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class MainClass {

	private static final CurrencyRates getCurrency(final String code, NBPExchangeRatesTable response) {
		return response.getRates().stream().filter(x -> code.equals(x.getCode())).findFirst()
				.orElseThrow(() -> new IllegalArgumentException(String.format("Nie znaleziono waluty %s", code)));
	}

	private static void printOutput(NBPExchangeRatesTable currencyTable) {
		System.out.println(String.format("Data: %s ",
				new SimpleDateFormat("yyyy-MM-dd").format(currencyTable.getEffectiveDate())));
		System.out.println("Waluta = kupno; sprzedaż");
		System.out.println(getCurrency("EUR", currencyTable));
		System.out.println(getCurrency("CHF", currencyTable));
		System.out.println(getCurrency("USD", currencyTable));
		System.out.println(getCurrency("GBP", currencyTable));
	}

	public static void main(String[] args) throws Exception {
		INBPApplication application = new NBPApplicationImpl(new NBPApplicationConfig(), new NBPRequestParser(),
				new NBPURLParser());
		try {
			printOutput(application.get(args));
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		} catch (FileNotFoundException fnf) {
			System.out.println(String.format("Dla podanego argumentu %s nie znaleziono danych", args[0]));
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
