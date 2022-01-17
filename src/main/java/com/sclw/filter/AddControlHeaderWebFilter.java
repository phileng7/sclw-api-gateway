package com.sclw.filter;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

@Component
public class AddControlHeaderWebFilter implements WebFilter{
	@Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.add("Access-Control-Allow-Headers", "*");
		parameters.add("Access-Control-Allow-Origin", "*");
		parameters.add("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		
        exchange.getResponse()
                .getHeaders()
                .addAll(parameters);
        return chain.filter(exchange);
    }
}
