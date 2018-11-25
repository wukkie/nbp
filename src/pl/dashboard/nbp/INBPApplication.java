package pl.dashboard.nbp;

import java.io.IOException;

public interface INBPApplication {
	public NBPExchangeRatesTable get(NBPRequest request) throws Exception;
	public NBPExchangeRatesTable get(String[] args) throws Exception;
}
