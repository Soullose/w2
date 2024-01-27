package cn.sf.w2.demo.nacos.consumer.nacosconsumer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "消费模块")
@RestController
public class OpenFeignController {

    @Autowired
    private ProviderService providerService;

    @ApiOperation(value = "测试FEIGN")
    @GetMapping("/feign/feignTest")
    public String feignTest() {
        return providerService.test();
    }
}
