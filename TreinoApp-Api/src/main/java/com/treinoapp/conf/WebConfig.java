package com.treinoapp.conf;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.treinoapp" })
@EnableJpaRepositories("com.treinoapp")
public class WebConfig extends WebMvcConfigurerAdapter {

	// public void configureViewResolvers(ViewResolverRegistry registry) {
	// MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
	// jsonView.setPrettyPrint(true);
	// registry.enableContentNegotiation(jsonView);
	// }

	/*
	 * Here we register the Hibernate4Module into an ObjectMapper, then set this
	 * custom-configured ObjectMapper to the MessageConverter and return it to
	 * be added to the HttpMessageConverters of our application
	 */
	public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

		ObjectMapper mapper = new ObjectMapper();
		// Registering Hibernate4Module to support lazy objects
		mapper.registerModule(new Hibernate4Module());
		messageConverter.setObjectMapper(mapper);
		return messageConverter;

	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// Here we add our custom-configured HttpMessageConverter
		converters.add(jacksonMessageConverter());
		super.configureMessageConverters(converters);
	}


}
