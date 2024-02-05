package cn.sf.w2.core.framework.jpa.demo.querydsl.support;

import cn.sf.w2.core.framework.jpa.demo.querydsl.JPQLRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryComposition;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;


/**
 * from io.github.openfeign.querydsl.jpa.spring.repository
 *
 * @author https://github.com/OpenFeign/querydsl
 */
public class QuerydslJpaRepositoryFactoryBean<T extends JPQLRepository<S, ID>, S, ID>
		extends
			JpaRepositoryFactoryBean<T, S, ID> {

	public QuerydslJpaRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
		super(repositoryInterface);
	}

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new QuerydslRepositoryFactory<T, ID>(entityManager);
	}
	private static class QuerydslRepositoryFactory<T, ID> extends JpaRepositoryFactory {

		private final EntityManager entityManager;

		public QuerydslRepositoryFactory(EntityManager entityManager) {

			super(entityManager);

			this.entityManager = entityManager;
		}

		@Override
		protected RepositoryComposition.RepositoryFragments getRepositoryFragments(RepositoryMetadata metadata) {

			Object fragmentImplementation = instantiateClass( //
					QuerydslJpaRepositoryImpl.class, //
					getEntityInformation(metadata.getDomainType()), //
					entityManager //
			);

			return RepositoryComposition.RepositoryFragments //
					.just(fragmentImplementation) //
					.append(super.getRepositoryFragments(metadata));
		}
	}
}
