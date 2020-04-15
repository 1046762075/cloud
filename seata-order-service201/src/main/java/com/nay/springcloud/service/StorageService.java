package com.nay.springcloud.service;

import com.nay.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>Title: StorageService</p>
 * Description：
 * date：2020/4/15 15:51
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

	@PostMapping(value = "/storage/decrease")
	CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}