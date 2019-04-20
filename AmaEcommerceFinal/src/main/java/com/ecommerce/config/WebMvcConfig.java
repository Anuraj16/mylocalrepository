package com.ecommerce.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	private static final Charset UTF8 = Charset.forName("UTF-8");

	// Config UTF-8 Encoding.
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
		//stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text/html", "plain", UTF8)));
		stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "html", UTF8),new MediaType("text", "plain", UTF8)));
		converters.add(stringConverter);

		// Add other converters ...
	}


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/styles/**") //
		.addResourceLocations("/WEB-INF/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/fonts/**") //
		.addResourceLocations("/WEB-INF/fonts/").setCachePeriod(31556926);
		registry.addResourceHandler("/script/**") //
		.addResourceLocations("/WEB-INF/js/").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**") //
		.addResourceLocations("/WEB-INF/images/").setCachePeriod(31556926);
		registry.addResourceHandler("/scss/**") //
		.addResourceLocations("/WEB-INF/scss/").setCachePeriod(31556926);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
