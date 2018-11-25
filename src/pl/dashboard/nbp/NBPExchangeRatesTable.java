package pl.dashboard.nbp;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="ExchangeRatesTable")
public class NBPExchangeRatesTable {

	private String Table; 
	private String no; 
	private Date tradingDate;
	private Date effectiveDate;
	private List<CurrencyRates> rates;
	
	public String getTable() {
		return Table;
	}
	
	@XmlElement(name="Table")
	public void setTable(String table) {
		this.Table = table;
	}
	public String getNo() {
		return no;
	}
	@XmlElement(name="No")
	public void setNo(String no) {
		this.no = no;
	}
	public Date getTradingDate() {
		return tradingDate;
	}
	@XmlElement(name="TradingDate")
	public void setTradingDate(Date tradingDate) {
		this.tradingDate = tradingDate;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	@XmlElement(name="EffectiveDate")
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public List<CurrencyRates> getRates() {
		return rates;
	}
	
	@XmlElementWrapper(name="Rates")
	@XmlElement(name="Rate")
	public void setRates(List<CurrencyRates> rates) {
		this.rates = rates;
	}
	@Override
	public String toString() {
		return "ExchangeRatesTable [table=" + Table + ", no=" + no + ", tradingDate=" + tradingDate + ", effectiveDate="
				+ effectiveDate + ", rates=" + rates + "]";
	}

	
}
