package cn.sf.w2.core.framework.jpa.demo.base;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends EnhanceJpaRepository<T, ID>, QuerydslPredicateExecutor<T> {
}
