package cn.sf.w2.demo.nacos.discovery.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "提供者模块")
@RestController
@RequestMapping("/provider")
@RefreshScope
public class ProviderController {

	@Value("${useLocalCache:false}")
	private boolean useLocalCache;

	@Value("${test:1}")
	private String test;

	@ApiOperation(value = "测试")
	@RequestMapping("/get")
	public boolean get() {
		return useLocalCache;
	}

	@ApiOperation(value = "测试1")
	@RequestMapping("/get1")
	public String get1() {
		return test;
	}
}
