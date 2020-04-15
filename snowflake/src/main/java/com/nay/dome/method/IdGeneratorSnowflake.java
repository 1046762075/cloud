package com.nay.dome.method;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * <p>Title: service</p>
 * Description：获取机器码
 * date：2020/4/15 23:11
 */
@Slf4j
@Component
public class IdGeneratorSnowflake {
	private long workerId = 0;

	private long datacenterId = 1;
	/**
	 * datacenterId : 0 - 31
	 */
	private Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);

	/**
	 * 每次运行都会执行
	 */
	@PostConstruct
	public void init(){
		try {
			/**
			 * 得到本地的一个 workID
			 */
			workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
			log.info("当前机器的workerId：" + workerId);
		} catch (Exception e) {
			e.printStackTrace();
			log.warn("当前机器的workerId获取失败" + e);
			// 不能让这机器码空了
			workerId = NetUtil.getLocalhostStr().hashCode();
		}
	}

	/**
	 * 默认的方式
	 */
	public synchronized long snowflakeId(){
		return this.snowflake.nextId();
	}

	/**
	 * 自定义的方式
	 */
	public synchronized long snowflakeId(long workerId, long datacenterId){
		Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
		return snowflake.nextId();
	}

	/**
	 *	测试
	 */
	public static void main(String[] args) {
		System.out.println(new IdGeneratorSnowflake().snowflakeId());
		System.out.println("1250443979145740288".length());
	}
}
