//package cn.sf.w2.core.framework.jpa.demo.base;
//
//import com.querydsl.core.types.EntityPath;
//import com.querydsl.core.types.dsl.PathBuilder;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
//import org.springframework.data.jpa.repository.support.JpaEntityInformation;
//import org.springframework.data.jpa.repository.support.Querydsl;
//import org.springframework.data.jpa.repository.support.QuerydslJpaPredicateExecutor;
//import org.springframework.data.querydsl.EntityPathResolver;
//import org.springframework.data.querydsl.SimpleEntityPathResolver;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//
//@Transactional
//public class CustomQuerydslJpaRepositoryIml<T> extends QuerydslJpaPredicateExecutor<T> {
//
//	private static final EntityPathResolver simpleResolver = SimpleEntityPathResolver.INSTANCE;
//
//	private final EntityPath<T> path;
//	private final PathBuilder<T> builder;
//	private final Querydsl querydsl;
//	private final JPAQueryFactory queryFactory;
//
//	public CustomQuerydslJpaRepositoryIml(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager,
//			EntityPathResolver resolver, CrudMethodMetadata metadata) {
//		super(entityInformation, entityManager, simpleResolver, metadata);
//		this.path = simpleResolver.createPath(entityInformation.getJavaType());
//		this.builder = new PathBuilder<T>(path.getType(), path.getMetadata());
//		this.querydsl = new Querydsl(entityManager, builder);
//		this.queryFactory =  new JPAQueryFactory(entityManager);
//	}
//
////	@Override
////	public JPAQueryFactory getQueryFactory() {
////		return this.queryFactory;
////	}
//}
