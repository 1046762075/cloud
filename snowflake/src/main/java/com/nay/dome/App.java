package com.nay.dome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>Title: App</p>
 * Description：	代表5个线程
 * 			http://127.0.0.1:666/snowflake/5
 * date：2020/4/16 0:08
 */
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class,args);
	}
}
