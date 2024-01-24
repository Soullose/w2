package cn.sf.w2.quartz.test;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QuartzJobProvider implements ApplicationListener<ContextRefreshedEvent>, Ordered {

    private final ConfigurableListableBeanFactory beanFactory;

    public QuartzJobProvider(ConfigurableListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.debug("QuartzJobProvider");
        String[] quartzJobs = beanFactory.getBeanNamesForType(Job.class);
        log.debug("quartzJobs:{}", quartzJobs);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
