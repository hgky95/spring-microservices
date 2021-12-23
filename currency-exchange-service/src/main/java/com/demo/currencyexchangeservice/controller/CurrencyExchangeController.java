package com.demo.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.currencyexchangeservice.model.CurrencyExchange;
import com.demo.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository repository;
	@Autowired
	private Environment env;

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getExchangeValue(
			@PathVariable String from,
			@PathVariable String to) {
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		if (null == currencyExchange) {
			throw new RuntimeException("Data not found");
		}
		currencyExchange.setEnvironment(env.getProperty("local.server.port"));
		return currencyExchange;
	}
}
