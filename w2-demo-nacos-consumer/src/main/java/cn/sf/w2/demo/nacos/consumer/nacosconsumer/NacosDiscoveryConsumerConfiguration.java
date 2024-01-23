package cn.sf.w2.demo.nacos.consumer.nacosconsumer;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients // 激活 @FeignClient
public class NacosDiscoveryConsumerConfiguration {
}
