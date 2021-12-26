package com.demo.currencyconversionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.currencyconversionservice.model.CurrencyConversion;

//@FeignClient(name="currency-exchange1232", url="localhost:8000")
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion getExchangeValue(
			@PathVariable String from,
			@PathVariable String to);
}
