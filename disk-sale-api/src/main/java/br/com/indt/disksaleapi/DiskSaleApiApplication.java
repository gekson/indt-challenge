package br.com.indt.disksaleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class DiskSaleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiskSaleApiApplication.class, args);
	}

}
