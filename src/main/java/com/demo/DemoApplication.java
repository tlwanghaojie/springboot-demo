package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wanghj
 * @description 主启动类
 * @createTime 2021/12/24 10:26
 */
@SpringBootApplication
@MapperScan(value = "com.demo.dao")
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
