package com.nay.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Title: CommonResult</p>
 * 作用：
 * 时间：2020/4/8 14:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

	private Integer 	code;
	private String 		message;
	private T 			data;

	/**
	 * 防止 data 为null
	 */
	public CommonResult(Integer code ,String message){
		this(code,message,null);
	}
}