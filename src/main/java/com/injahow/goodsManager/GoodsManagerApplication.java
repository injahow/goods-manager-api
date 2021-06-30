package com.injahow.goodsManager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.injahow.goodsManager.dao")
public class GoodsManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodsManagerApplication.class, args);
	}

}
