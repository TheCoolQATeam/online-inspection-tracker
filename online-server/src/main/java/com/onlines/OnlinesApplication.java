package com.onlines;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.onlines.mapper")
@SpringBootApplication//(exclude={DataSourceAutoConfiguration.class})

public class OnlinesApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlinesApplication.class, args);
	}

}
