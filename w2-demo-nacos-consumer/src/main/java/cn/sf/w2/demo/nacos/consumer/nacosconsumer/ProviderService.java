package cn.sf.w2.demo.nacos.consumer.nacosconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("w2-demo-discovery") // 指向服务提供者应用
public interface ProviderService {

    @GetMapping("/provider/get1")
    String test();
}
