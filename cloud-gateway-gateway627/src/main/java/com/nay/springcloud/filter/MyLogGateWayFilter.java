package com.nay.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>Title: MyLogGateWayFilter</p>
 * 作用：curl http://127.0.0.1:627/payment/lb?age=20 --cookie "username=nay" -H "ps_nay:123" -H "Host: lsl.nay.com"
 * 时间：2020/4/11 21:46
 */
@Order(0)
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
//		log.info("****come in MyLogGateWayFilter: " + LocalDateTime.of(2020, 05, 20, 5, 20));
		String date = LocalDateTime.now().format(dtf2);
		log.info("****come in MyLogGateWayFilter: " + date);
		String list = exchange.getRequest().getQueryParams().getFirst("age");
		if(list == null){
			log.info("用户名为空,非法用户,(o_o)");			// 拒绝访问
			exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			return exchange.getResponse().setComplete();
		}
		return chain.filter(exchange);
	}
}
