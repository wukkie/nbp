package pl.dashboard.nbp;

import java.net.URL;

public interface INBPTableReader {
	public NBPExchangeRatesTable get(URL url);
}
