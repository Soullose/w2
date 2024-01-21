package cn.sf.w2.demo.nacos.discovery.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
@RefreshScope
public class ProviderController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;


    @Value("${test:1}")
    private String test;

    @RequestMapping("/get")
    public boolean get() {
        return useLocalCache;
    }

    @RequestMapping("/get1")
    public String get1() {
        return test;
    }
}
