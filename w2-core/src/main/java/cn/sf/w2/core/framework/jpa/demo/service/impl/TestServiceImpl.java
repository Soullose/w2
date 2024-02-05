package cn.sf.w2.core.framework.jpa.demo.service.impl;

import cn.sf.w2.core.framework.jpa.demo.model.QTest;
import cn.sf.w2.core.framework.jpa.demo.model.Test;
import cn.sf.w2.core.framework.jpa.demo.repository.TestRepository;
import cn.sf.w2.core.framework.jpa.demo.service.TestService;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static cn.sf.w2.core.framework.jpa.demo.model.QTest.test;
import static com.querydsl.core.types.Projections.bean;

@Slf4j
@Service
public class TestServiceImpl implements TestService {

	final QBean<Test> testQBean = bean(Test.class, test.id, test.name);

	@PersistenceContext(name = "event-log")
	private EntityManager entityManager;
	// @Autowired
	private final TestRepository testRepository;

	public TestServiceImpl(TestRepository testRepository) {
		this.testRepository = testRepository;
	}

	@Override
	public void findAll() {
		// List<Test> tests =
		// testRepository.getQueryFactory().select(testQBean).from(test).fetch();
		List<Test> tests = testRepository.select(testQBean).from(test).fetch();
		log.info("findAll-tests:{}", tests);
	}

	@Override
	public void findOne() {
		QTest qTest = test;
		Test test = testRepository.selectFrom(qTest).where(qTest.id.eq("2")).fetchOne();
		// Test test =
		// testRepository.getQueryFactory().selectFrom(qTest).where(qTest.id.eq("2")).fetchOne();
		log.info("findOne-test:{}", test);
	}

	@Transactional
	@Override
	public void add() {
		Predicate predicate = null;
		QTest qTest = test;
		Test t = new Test();
		t.setId("10");
		t.setName("xxxxxx");


		// JPQLQueryFactory queryFactory = new JPAQueryFactory(entityManager);
		/// org.hibernate.hql.internal.ast.QuerySyntaxException: unexpected token: test
		/// near line 2, column 1 [insert into Test (id, name)
		// queryFactory.insert(test).set(test.id, "10").set(test.name,
		// "xxxx").execute();
		// testRepository.getQueryFactory().update(qTest).set(qTest.name,"test1").where(qTest.id.eq("1")).execute();
		// Test test = testRepository.getQueryFactory().selectFrom(qTest).fetchOne();
		// System.out.println(test);
		/// querydsl insert not work
//		testRepository.insert(qTest).columns(qTest.id, qTest.name).values("10").values("xxxx").set(qTest.id, "10")
//				.set(qTest.name, "xxxx").execute();
		testRepository.save(t);
	}

	@Transactional
	@Override
	public void update() {
		QTest qTest = test;
		// testRepository.getQueryFactory().update(qTest).set(qTest.name,
		// "test1").where(qTest.id.eq("1")).execute();
		testRepository.update(qTest).set(qTest.name, "test1").where(qTest.id.eq("1")).execute();
	}

	@Transactional
	@Override
	public void delete() {
		QTest qTest = test;
		// testRepository.getQueryFactory().delete(qTest).where(qTest.name.eq("test1")).execute();
		testRepository.delete(qTest).where(qTest.name.eq("test1")).execute();
	}
}
