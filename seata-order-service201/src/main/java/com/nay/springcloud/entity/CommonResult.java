package com.nay.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * <p>Title: OrderMain201</p>
 * Description：
 * date：2020/4/15 14:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

	private Integer code;
	private String message;
	private T       data;

	public CommonResult(Integer code, String message){
		this(code,message,null);
	}
}
