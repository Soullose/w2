package cn.sf.w2.core.framework.jpa.demo.querydsl;

import com.querydsl.core.Tuple;
import com.querydsl.core.dml.DeleteClause;
import com.querydsl.core.dml.InsertClause;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * from io.github.openfeign.querydsl.jpa.spring.repository
 *
 * @author https://github.com/OpenFeign/querydsl
 */

@NoRepositoryBean
public interface JPQLRepository<T, ID> extends Repository<T, ID> {
    DeleteClause<?> delete(EntityPath<T> var1);

    <U> JPQLQuery<U> select(Expression<U> var1);

    JPQLQuery<Tuple> select(Expression<?>... var1);

    <U> JPQLQuery<U> selectDistinct(Expression<U> var1);

    JPQLQuery<Tuple> selectDistinct(Expression<?>... var1);

    JPQLQuery<Integer> selectOne();

    JPQLQuery<Integer> selectZero();

    <U> JPQLQuery<U> selectFrom(EntityPath<U> var1);

    UpdateClause<?> update(EntityPath<T> var1);

    InsertClause<?> insert(EntityPath<T> var1);
}
