package cn.sf.w2.core.framework.jpa.demo.querydsl.support;

import cn.sf.w2.core.framework.jpa.demo.querydsl.JPQLRepository;
import com.querydsl.core.Tuple;
import com.querydsl.core.dml.DeleteClause;
import com.querydsl.core.dml.InsertClause;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.repository.core.EntityInformation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;

/**
 * from io.github.openfeign.querydsl.jpa.spring.repository
 *
 * @author https://github.com/OpenFeign/querydsl
 */
@Transactional(readOnly = true)
public class QuerydslJpaRepositoryImpl<T, ID> implements JPQLRepository<T, ID> {
	private final EntityInformation<T, ?> entityInformation;
	private final EntityManager entityManager;
	private final JPAQueryFactory jpaQueryFactory;

	public QuerydslJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		Assert.notNull(entityManager, "entityManager must not be null!");
		this.entityInformation = entityInformation;
		this.entityManager = entityManager;
		this.jpaQueryFactory = new JPAQueryFactory(entityManager);
	}

	public DeleteClause<?> delete(EntityPath<T> path) {
		return this.jpaQueryFactory.delete(path);
	}

	public <U> JPQLQuery<U> select(Expression<U> expr) {
		return this.jpaQueryFactory.select(expr);
	}

	public JPQLQuery<Tuple> select(Expression<?>... exprs) {
		return this.jpaQueryFactory.select(exprs);
	}

	public <U> JPQLQuery<U> selectDistinct(Expression<U> expr) {
		return this.jpaQueryFactory.selectDistinct(expr);
	}

	public JPQLQuery<Tuple> selectDistinct(Expression<?>... exprs) {
		return this.jpaQueryFactory.selectDistinct(exprs);
	}

	public JPQLQuery<Integer> selectOne() {
		return this.jpaQueryFactory.selectOne();
	}

	public JPQLQuery<Integer> selectZero() {
		return this.jpaQueryFactory.selectZero();
	}

	public <U> JPQLQuery<U> selectFrom(EntityPath<U> from) {
		return this.jpaQueryFactory.selectFrom(from);
	}

	public UpdateClause<?> update(EntityPath<T> path) {
		return this.jpaQueryFactory.update(path);
	}

	public InsertClause<?> insert(EntityPath<T> path) {
		return this.jpaQueryFactory.insert(path);
	}
}
