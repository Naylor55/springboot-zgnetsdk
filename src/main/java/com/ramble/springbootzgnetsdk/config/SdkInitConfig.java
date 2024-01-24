package com.ramble.springbootzgnetsdk.config;

import com.ramble.springbootzgnetsdk.support.ZgSupport;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project     springboot-zgnetsdk
 * Package     com.ramble.springbootzgnetsdk.config
 * Class       SdkInitConfig
 * date        2024/1/24 10:17
 * author      cml
 * Email       liangchen_beijing@163.com
 * Description
 */


@Configuration
@ConditionalOnProperty(value = "sdk.enable", havingValue = "true")
public class SdkInitConfig {


    @Bean
    @ConditionalOnMissingBean
    ZgSupport initZgSdk() {
        return new ZgSupport();
    }


}
