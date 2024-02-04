package cn.sf.w2.core.framework.jpa.demo.service.impl;

import cn.sf.w2.core.framework.jpa.demo.model.QTest;
import cn.sf.w2.core.framework.jpa.demo.model.Test;
import cn.sf.w2.core.framework.jpa.demo.repository.TestRepository;
import cn.sf.w2.core.framework.jpa.demo.service.TestService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements TestService {

//	@Autowired
	private final TestRepository testRepository;

	public TestServiceImpl (TestRepository testRepository) {
		this.testRepository = testRepository;
	}

	@Transactional
	@Override
	public void add() {
		Predicate predicate = null;
		QTest qTest = QTest.test;
		/// org.hibernate.hql.internal.ast.QuerySyntaxException: unexpected token: test near line 2, column 1 [insert into Test (id, name)
		testRepository.getQueryFactory().insert(qTest).set(qTest.id,"2").set(qTest.name,"xxxx").execute();
//		testRepository.getQueryFactory().update(qTest).set(qTest.name,"test1").where(qTest.id.eq("1")).execute();
//		Test test = testRepository.getQueryFactory().selectFrom(qTest).fetchOne();
//		System.out.println(test);
	}

	@Override
	public void update() {

	}
}
