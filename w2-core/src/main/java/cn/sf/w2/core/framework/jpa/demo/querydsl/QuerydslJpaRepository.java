package cn.sf.w2.core.framework.jpa.demo.querydsl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * from io.github.openfeign.querydsl.jpa.spring.repository
 *
 * @author https://github.com/OpenFeign/querydsl
 */

@NoRepositoryBean
public interface QuerydslJpaRepository<T, ID> extends JPQLRepository<T, ID>, JpaRepository<T, ID> {
}
