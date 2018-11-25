package pl.dashboard.nbp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
public class ArrayOfExchangeRatesTable
{

    private NBPExchangeRatesTable exchangeRatesTable;

    public NBPExchangeRatesTable getExchangeRatesTable (){
        return exchangeRatesTable;
    }
    
	@XmlElement(name="ExchangeRatesTable")
    public void setExchangeRatesTable (NBPExchangeRatesTable ExchangeRatesTable){
        this.exchangeRatesTable = ExchangeRatesTable;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ExchangeRatesTable = "+exchangeRatesTable+"]";
    }
}
			