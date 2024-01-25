package cn.sf.w2.quartz.test;

import cn.sf.w2.quartz.test.W2NacosConfigTest;
import org.quartz.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component(value = "W2QuartzJobProvider")
public class W2QuartzJobProvider implements ApplicationListener<ContextRefreshedEvent>, Ordered {

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    @Autowired
    private W2NacosConfigTest nacosConfigTest;

    public W2QuartzJobProvider() {
        log.debug("QuartzJobProvider");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.debug("nacosConfigTest:{}",nacosConfigTest);
        log.debug("QuartzJobProvider");
        String[] quartzJobs = beanFactory.getBeanNamesForType(Job.class);
        log.debug("quartzJobs:{}", quartzJobs);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
