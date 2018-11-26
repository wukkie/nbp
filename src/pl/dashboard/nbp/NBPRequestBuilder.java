package pl.dashboard.nbp;

import java.util.Date;

public class NBPRequestBuilder {
	private Date date;
	private Date endDate;
	private String table;
	private String format;
	private String type;

	public NBPRequestBuilder setFormat(String format) {
		this.format = format;
		return this;
	}

	public NBPRequestBuilder setTable(String table) {
		this.table = table;
		return this;
	}

	public NBPRequestBuilder setDate(Date date) {
		this.date = date;
		return this;
	}

	public NBPRequestBuilder setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}

	public NBPRequestBuilder setType(String type) {
		this.type = type;
		return this;
	}

	public NBPRequest build() {
		NBPRequest request = new NBPRequest();
		request.setType(type);
		request.setDate(date);
		request.setEndDate(endDate);
		request.setFormat(format);
		request.setTable(table);
		return request;
	}
}