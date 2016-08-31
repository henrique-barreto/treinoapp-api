package com.treinoapp.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.treinoapp")
public class WebConfig extends WebMvcConfigurerAdapter {

	// @Bean
	// public InternalResourceViewResolver internalResourceViewResolver() {
	// InternalResourceViewResolver resolver = new
	// InternalResourceViewResolver();
	// resolver.setPrefix("/WEB-INF/views/");
	// resolver.setSuffix(".jsp");
	// return resolver;
	// }

	public void configureViewResolvers(ViewResolverRegistry registry) {
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		jsonView.setPrettyPrint(true);
		registry.enableContentNegotiation(jsonView);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//registry.addMapping("/**").allowedOrigins("*");
	}

//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//	}

}
