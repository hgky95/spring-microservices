package com.demo.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping("/sample-api")
	//@Retry(name = "sample-api", fallbackMethod = "handleFallback")
	//@CircuitBreaker(name = "sample-api", fallbackMethod = "handleFallback")
	//@RateLimiter(name="default")
	@Bulkhead(name="sample-api")
	public String sampleAPI() {
		//simulate the service is downed
		logger.info("====== Calling /sample-api ======");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-api", String.class);
//		return forEntity.getBody();
		return "sample-api";
	}
	
	private String handleFallback(Exception e) {
		return "fall back value";
	}
}
