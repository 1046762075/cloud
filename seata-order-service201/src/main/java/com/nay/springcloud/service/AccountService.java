package com.nay.springcloud.service;

import com.nay.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * <p>Title: AccountService</p>
 * Description：
 * date：2020/4/15 15:50
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

	@PostMapping(value = "/account/decrease")
	CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("count") BigDecimal money);
}
