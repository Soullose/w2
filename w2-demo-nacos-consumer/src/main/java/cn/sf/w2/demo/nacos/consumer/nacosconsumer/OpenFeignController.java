package cn.sf.w2.demo.nacos.consumer.nacosconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenFeignController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/feign/feignTest")
    public String feignTest() {
        return providerService.test();
    }
}
