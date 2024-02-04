package cn.sf.w2.core.framework.jpa.demo.controller;

import cn.sf.w2.core.framework.jpa.demo.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "测试")
@RestController
@RequestMapping(value = "/v1/w2/core/demo/test")
public class TestController {

//    @Autowired
    private TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @ApiOperation(value = "测试")
    @GetMapping("/feign/feignTest")
    public String test() {
        testService.add();
        return "测试";
    }
}
