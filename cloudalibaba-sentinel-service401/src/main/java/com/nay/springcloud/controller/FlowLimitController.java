package com.nay.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * <p>Title: FlowLimitController</p>
 * 作用：监控A、B两个方法
 * 时间：2020/4/13 22:47
 */
@RestController
@Slf4j
public class FlowLimitController {

	@GetMapping("/testA")
	public String testA(){
		String msg = "----------------testA()<font color='red'>打卡成功,可以去访问 http://127.0.0.1:8080 了</font> 时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss"));
		log.info(msg);
		return msg;
	}

	@GetMapping("/testB")
	public String testB(){
		String msg = "----------------testB()<font color='red'>打卡成功,可以去访问 http://127.0.0.1:8080 了</font>时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss"));
		log.info(msg);
		return msg;
	}


	/**
	 * 当一秒钟进来的请求超过5个 每次我们在 Sentinel 中设置的是500毫秒内完成 而我们的请求完成需要1秒
	 * 		这样就会触发降级 提示：Blocked by Sentinel (flow limiting)
	 */
	@GetMapping("/testD")
	public String testD(){
		String msg = "测试降级 RT";
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {}
		log.info(msg);
		return msg;
	}

	@GetMapping("/testE")
	public String testE(){
		String msg = "----------------testE()测试异常数<font color='red'>打卡成功,可以去访问 http://127.0.0.1:8080 了</font>时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss"));
		int age = 20/0;
		log.info(msg);
		return msg;
	}

	/**
	 * deal_testHotKey : 兜底的方法
	 */
	@GetMapping("/testHotKey")
	@SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
	public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
							 @RequestParam(value = "p2",required = false) String p2){
		String msg = "testHotKey";
		if("128".equals(p1)){
			msg = "testHotKey ....p1为" + p1 + "限流提高";
		}
		log.info(msg);
		return msg;
	}
	public String deal_testHotKey(String p1, String p2, BlockException exception){
		return "---------------deal_testHotKey,o(╥﹏╥)o";
	}
}
