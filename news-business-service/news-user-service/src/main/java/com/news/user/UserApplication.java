package com.news.user;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhangkai
 * @date 2019/7/28 11:41
 */
@SpringCloudApplication
@EnableHystrixDashboard
@EnableFeignClients
@ComponentScan(basePackages = "com.news")
public class UserApplication {

    public static void main(String [] args){
        SpringApplication.run(UserApplication.class,args);
    }
}
