package pl.dashboard.nbp;

import java.io.File;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Currency;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.google.gson.Gson;

public class NBPApplicationImpl implements INBPApplication{
	

	public static URL buildURL(NBPRequest request) throws MalformedURLException, URISyntaxException {
		String url = NBPApplicationConfig.NBPURL; 
		url = url + request.getType() + "/";
		url = url + request.getTable() + "/";
		url = url + new SimpleDateFormat(NBPApplicationConfig.ARG_DATE_FORMAT).format(request.getDate()) + "/";
		/* url = url + request.getEndDate() + "/"; */
		url = url + "?format=" + request.getFormat();
		return new URL(url);
	}
	

	
	@Override
	public NBPExchangeRatesTable getFromJSON(NBPRequest request) throws Exception{
		try {
	        InputStreamReader reader = new InputStreamReader(buildURL(request).openStream());
	        return new Gson().fromJson(reader, NBPExchangeRatesTable[].class)[0];
		} catch (Exception exception) {
			throw exception;
		}

	}

	public NBPExchangeRatesTable getFromXML(NBPRequest request) throws Exception{
		
        // marshal object to file input stream

		ArrayOfExchangeRatesTable st = JAXB.unmarshal(buildURL(request), ArrayOfExchangeRatesTable.class);

        // prints
        System.out.println(st);

//	      try {
//	          documentbuilderfactory f = 
//	                  documentbuilderfactory.newinstance();
//	          documentbuilder b = f.newdocumentbuilder();
//	          document doc = b.parse(buildurl(request).tostring());
//
//	          doc.getdocumentelement().normalize();
//	          system.out.println ("root element: " + 
//	                      doc.getdocumentelement().getnodename());
//
//	            } catch (exception e) {
//	                e.printstacktrace();
//	            }
		return null;

	}

}
