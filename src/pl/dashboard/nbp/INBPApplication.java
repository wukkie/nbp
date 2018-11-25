package pl.dashboard.nbp;

import java.io.IOException;

public interface INBPApplication {
	public NBPExchangeRatesTable getFromJSON(NBPRequest request) throws Exception;
	public NBPExchangeRatesTable getFromXML(NBPRequest request) throws Exception;
}
