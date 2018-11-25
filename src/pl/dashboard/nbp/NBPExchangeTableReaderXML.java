package pl.dashboard.nbp;

import java.net.URL;

import javax.xml.bind.JAXB;
import javax.xml.bind.UnmarshalException;

public class NBPExchangeTableReaderXML implements INBPTableReader{

	@Override
	public NBPExchangeRatesTable get(URL url) {
		return JAXB.unmarshal(url, ArrayOfExchangeRatesTable.class).getExchangeRatesTable();
	}

}
