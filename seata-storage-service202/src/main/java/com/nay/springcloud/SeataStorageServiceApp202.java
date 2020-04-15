package com.nay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>Title: SeataStorageServiceApp202</p>
 * Description：
 * date：2020/4/15 19:03
 */
@SpringBootApplication(/*exclude = DataSourceAutoConfiguration.class*/)
@EnableDiscoveryClient
@EnableFeignClients
public class SeataStorageServiceApp202
{
    public static void main(String[] args)
    {
        SpringApplication.run(SeataStorageServiceApp202.class, args);
    }
}
