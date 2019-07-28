package com.news.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author zhangkai
 * @date 2019/7/28 11:25
 */
@SpringCloudApplication
public class GatewayApplication {

    public static void main(String [] args){
        SpringApplication.run(GatewayApplication.class,args);
    }
}
