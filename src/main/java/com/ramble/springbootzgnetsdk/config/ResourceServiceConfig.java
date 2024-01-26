package com.ramble.springbootzgnetsdk.config;

import com.ramble.springbootzgnetsdk.service.DiskResourceServiceImpl;
import com.ramble.springbootzgnetsdk.service.MinIoResourceServiceImpl;
import com.ramble.springbootzgnetsdk.service.ResourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Project     springboot-zgnetsdk
 * Package     com.ramble.springbootzgnetsdk.config
 * Class       ResourceServiceConfig
 * date        2024/1/26 10:49
 * author      cml
 * Email       liangchen_beijing@163.com
 * Description
 */


@Configuration
public class ResourceServiceConfig {

    @Profile("dev")
    @Bean
    public ResourceService initDiskResourceService() {
        return new DiskResourceServiceImpl();
    }


    @Profile("prod")
    @Bean
    public ResourceService initMinIoResourceService() {
        return new MinIoResourceServiceImpl();
    }
}
