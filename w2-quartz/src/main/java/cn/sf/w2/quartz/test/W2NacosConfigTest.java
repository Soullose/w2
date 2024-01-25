package cn.sf.w2.quartz.test;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "quartztest")
public class W2NacosConfigTest {
    private String a;
    private String b;
    private String c;

}
