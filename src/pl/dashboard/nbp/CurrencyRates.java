package pl.dashboard.nbp;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CurrencyRates {

	private String currency;
	private String code;
	private BigDecimal bid;
	private BigDecimal ask;

	public String getCurrency() {
		return currency;
	}

	@XmlElement(name = "Currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCode() {
		return code;
	}

	@XmlElement(name = "Code")
	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getBid() {
		return bid;
	}

	@XmlElement(name = "Bid")
	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}

	public BigDecimal getAsk() {
		return ask;
	}

	@XmlElement(name = "Ask")
	public void setAsk(BigDecimal ask) {
		this.ask = ask;
	}

	public String toString() {
		return String.format("%s = %s; %s", code, bid, ask);
	}
}
