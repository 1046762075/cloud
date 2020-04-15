package com.nay.springcloud.entity;

import lombok.Data;
/**
 * <p>Title: Storage</p>
 * Description：
 * date：2020/4/15 19:16
 */
@Data
public class Storage {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
