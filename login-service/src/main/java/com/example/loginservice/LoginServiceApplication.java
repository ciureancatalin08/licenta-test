package com.example.loginservice;



import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class LoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}
		@Bean
		public DataSource dataSource() throws IOException {
			Properties dsProps = PropertiesLoaderUtils.loadAllProperties("datasource.properties");
			Properties hikariProps = PropertiesLoaderUtils.loadAllProperties("hikari.properties");
			hikariProps.put("dataSourceProperties", dsProps);
			return new HikariDataSource(new HikariConfig(hikariProps));
		}

	@Bean
	public PlatformTransactionManager transactionManager() throws IOException {
		return new DataSourceTransactionManager(dataSource());
	}

	//for swagger: http://localhost:8085/swagger-ui.html
		@Bean
		public Docket apiTest() {
			return new Docket(DocumentationType.SWAGGER_2).select()
					.apis(RequestHandlerSelectors.basePackage("com.techprimers.security.jwtsecurity"))
					.paths(PathSelectors.any())
					.build();

		}

	}

//	//for swagger: http://localhost:8085/swagger-ui.html
//	@Bean
//	public Docket apiTest() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.techprimers.security.jwtsecurity"))
//				.paths(PathSelectors.any())
//				.build();lodaspoiovid
//	}


