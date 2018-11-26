package pl.dashboard.nbp;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

public class NBPURLParser {
	public static URL getURI(NBPApplicationConfig config, NBPRequest request) throws MalformedURLException {
		String url = config.NBPURL;
		url = url + request.getType() + "/";
		url = url + request.getTable() + "/";
		url = url + new SimpleDateFormat(config.ARG_DATE_FORMAT).format(request.getDate()) + "/";
		url = url + "?format=" + request.getFormat();
		return new URL(url);
	}
}
