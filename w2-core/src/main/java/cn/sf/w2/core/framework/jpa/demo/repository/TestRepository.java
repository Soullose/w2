package cn.sf.w2.core.framework.jpa.demo.repository;

import cn.sf.w2.core.framework.jpa.demo.base.BaseRepository;
import cn.sf.w2.core.framework.jpa.demo.model.Test;
import org.springframework.stereotype.Repository;


@Repository
public interface TestRepository extends BaseRepository<Test, String>{
}
