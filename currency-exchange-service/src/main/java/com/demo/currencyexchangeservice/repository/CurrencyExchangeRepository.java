package com.demo.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.currencyexchangeservice.model.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	public CurrencyExchange findByFromAndTo(String from, String to);
	
}
