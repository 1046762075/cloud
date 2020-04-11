package com.nay.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: GateWayConfig</p>
 * 作用：配置转发到指定网站
 * 时间：2020/4/11 17:11
 */
@Configuration
public class GateWayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
		RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
		//				http://127.0.0.1:627/toplist	转发到: 	https://wallhaven.cc/toplist
		routes.route("path_route_nay_1",r -> r.path("/toplist").uri("https://wallhaven.cc/toplist")).build();

		return routes.build();
	}
}
