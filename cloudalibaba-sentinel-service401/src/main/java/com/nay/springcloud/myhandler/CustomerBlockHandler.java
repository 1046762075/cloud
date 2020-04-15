package com.nay.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.nay.springcloud.entities.CommonResult;

/**
 * <p>Title: CustomerBlockHandler</p>
 * Description：
 * date：2020/4/14 20:30
 */

public class CustomerBlockHandler {

	public static CommonResult handlerException(BlockException ex){
		return new CommonResult(444,"按照客户自定义,global handlerException---------1");
	}

	public static CommonResult handlerException_bk(BlockException ex){
		return new CommonResult(444,"按照客户自定义,global handlerException---------2");
	}
}
