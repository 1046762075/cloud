package com.nay.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>Title: Payment</p>
 * 作用：
 * 时间：2020/4/8 14:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

	private long id;
	private String serial;
}
