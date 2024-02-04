package cn.sf.w2.core.framework.jpa.demo.base;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

public class EnhanceJpaRepositoryImpl <T, ID> extends SimpleJpaRepository<T, ID> implements EnhanceJpaRepository<T, ID> {

    private final EntityManager em;

    private final JPAQueryFactory jpaQueryFactory;


    public EnhanceJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.em = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    public EnhanceJpaRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.em = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public JPAQueryFactory getQueryFactory() {
        return jpaQueryFactory;
    }
}
