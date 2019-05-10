package org.demo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */
@Slf4j
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "org.demo" })
public class SpringBootDemoApp {
	@RestController
	public class HelloWorldRest {
		@GetMapping("/")
		public String HelloIndex() {
			return "hello,world";
		}
	}

	@Bean
	protected ServletContextListener listener() {
		return new ServletContextListener() {

			@Override
			public void contextInitialized(ServletContextEvent sce) {
				log.info("ServletContext initialized");
			}

			@Override
			public void contextDestroyed(ServletContextEvent sce) {
				log.info("ServletContext destroyed");
			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApp.class, args);
	}
}
