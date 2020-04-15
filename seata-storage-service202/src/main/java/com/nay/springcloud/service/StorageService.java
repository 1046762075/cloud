package com.nay.springcloud.service;

/**
 * <p>Title: StorageService</p>
 * Description：
 * date：2020/4/15 19:03
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
