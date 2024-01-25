package cn.sf.w2.quartz.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/quartz/test")
public class QuartzTestController {

    @Autowired
    private W2NacosConfigTest  nacosConfigTest;

    @GetMapping("/w2NacosConfigTest")
    private W2NacosConfigTest getNacosConfigTest() {
        log.debug("nacosConfigTest:{}",nacosConfigTest);
        return  nacosConfigTest;
    }

}
