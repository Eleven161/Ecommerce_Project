package com.ecommerce.project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

	@RequestMapping("/orderFallBack")
	public Mono<String> orderServiceFallaBack(){
		return Mono.just("order service is taking too long to respond or is down.Please try again later");
	}
	@RequestMapping("/paymentFallBack")
	public Mono<String> paymentServiceFallBack(){
		return Mono.just("payment service is taking too long to respond or is down.Please try again later");
	}
}
