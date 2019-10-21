package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author huangyi
 * @date 2019/10/22 0:08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LyUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyUploadApplication.class, args);
    }
}
