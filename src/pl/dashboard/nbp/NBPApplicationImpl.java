package pl.dashboard.nbp;

import java.io.File;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.HashMap;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class NBPApplicationImpl implements INBPApplication {

	private NBPApplicationConfig config;
	private NBPRequestParser requestParser;
	private NBPURLParser urlParser;
	private HashMap<String, INBPTableReader> readers = new configReaders();

	private class configReaders extends HashMap<String, INBPTableReader> {
		configReaders() {
			super.put("xml", new NBPExchangeTableReaderXML());
		}
	}

	@Override
	public NBPExchangeRatesTable get(NBPRequest request) throws Exception {
		if (!readers.containsKey(request.getFormat())) {
			throw new IllegalArgumentException(String.format("Format %s nie jest obsługiwiany", request.getFormat()));
		}
		return readers.get(request.getFormat()).get(urlParser.getURI(config, request));
	}

	@Override
	public NBPExchangeRatesTable get(String[] args) throws IllegalArgumentException, Exception {
		return get(requestParser.parseArgs(args));
	}

	public NBPApplicationImpl(NBPApplicationConfig config, NBPRequestParser requestParser, NBPURLParser urlparser) {
		this.config = config;
		this.requestParser = requestParser;
		this.urlParser = urlparser;
	}

}
