package cn.sf.w2.core.framework.jpa.demo.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cn.sf.w2.core.framework.jpa.demo.base.EnhanceJpaRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Order(value = -1)
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"cn.sf.w2.core.framework.jpa.demo.repository.**"},repositoryBaseClass = EnhanceJpaRepositoryImpl.class) // repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class,
public class TestJpaConfiguration {

    @PersistenceContext
    private EntityManager entityManager;
}
