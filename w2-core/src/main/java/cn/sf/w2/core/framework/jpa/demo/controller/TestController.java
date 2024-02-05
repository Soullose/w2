package cn.sf.w2.core.framework.jpa.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.sf.w2.core.framework.jpa.demo.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags = "测试")
@RestController
@RequestMapping(value = "/v1/w2/core/demo/test")
public class TestController {

//    @Autowired
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @ApiOperation(value = "findAll")
    @GetMapping("/findAll")
    public String findAll() {
        testService.findAll();
        return "findAll";
    }

    @ApiOperation(value = "findOne")
    @GetMapping("/findOne")
    public String findOne() {
        testService.findOne();
        return "findOne";
    }

    @ApiOperation(value = "update")
    @GetMapping("/update")
    public String update() {
        testService.update();
        return "update";
    }

    @ApiOperation(value = "delete")
    @GetMapping("/delete")
    public String delete() {
        testService.delete();
        return "delete";
    }

    @ApiOperation(value = "测试")
    @GetMapping("/test")
    public String test() {
        testService.add();
        return "测试";
    }
}
