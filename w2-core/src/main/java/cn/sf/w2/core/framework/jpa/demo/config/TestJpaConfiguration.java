package cn.sf.w2.core.framework.jpa.demo.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.sf.w2.core.framework.jpa.demo.querydsl.support.QuerydslJpaRepositoryFactoryBean;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"cn.sf.w2.core.framework.jpa.demo.repository.**" }, repositoryFactoryBeanClass = QuerydslJpaRepositoryFactoryBean.class)

public class TestJpaConfiguration {

	@PersistenceContext
	private EntityManager entityManager;
}
