package cn.sf.w2.core.framework.jpa.demo.base;

import org.springframework.data.repository.NoRepositoryBean;

import cn.sf.w2.core.framework.jpa.demo.querydsl.QuerydslJpaRepository;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends QuerydslJpaRepository<T, ID> {
}
