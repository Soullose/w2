//package cn.sf.w2.core.framework.jpa.demo.base;
//
//import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
//import org.springframework.data.repository.Repository;
//import org.springframework.data.repository.core.support.RepositoryFactorySupport;
//
//import javax.persistence.EntityManager;
//
//public class CustomRepositoryFactoryBean<T extends BaseRepository<S, I>, S, I>
//        extends JpaRepositoryFactoryBean<T, S, I> {
//
//    public CustomRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
//        super(repositoryInterface);
//    }
//
//    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
//        return new CustomRepositoryFactory(entityManager);
//    }
//}
