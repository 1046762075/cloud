package com.nay.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: MySelfRule</p>
 * 作用：默认是轮询
 * 时间：2020/4/9 21:33
 */
@Configuration
public class MySelfRule {

	@Bean
	public IRule myRule(){
		// 随机类型的 Rule
		return new RandomRule();
	}
}
