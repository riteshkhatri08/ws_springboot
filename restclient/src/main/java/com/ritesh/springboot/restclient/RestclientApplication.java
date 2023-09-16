package com.ritesh.springboot.restclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.ritesh.springboot.restclient.services.AstroInterface;

@SpringBootApplication
public class RestclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestclientApplication.class, args);
	}

	@Bean
	AstroInterface getAstroInterface() {

		WebClient client = WebClient.create("http://api.open-notify.org");

		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
		return factory.createClient(AstroInterface.class);
	}

}
