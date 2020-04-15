package com.nay.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
/**
 * <p>Title: OrderMain201</p>
 * Description：
 * date：2020/4/15 14:20
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private Long id;
	private Long userId;
	private Long productId;
	private Integer count;
	private BigDecimal money;
	/**
	 * 订单状态：0：创建中 1：已完成
	 */
	private Integer status;
}
