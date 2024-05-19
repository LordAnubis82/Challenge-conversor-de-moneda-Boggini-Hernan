package com.hernanboggini.convertor;

import java.util.Map;

public class Divisas {
Map<String, Double> conversion_rates;
public Divisas(Map<String, Double> conversion_rates){
this.conversion_rates = conversion_rates;
}
public Map<String, Double>getConversion_rates(){
return conversion_rates;
}
public void setConversion_rates(Map<String, Double> conversion_rates){
    this.conversion_rates = conversion_rates;

}

}
