package cn.sf.w2.core.infrastructure.repository;

import cn.sf.w2.core.framework.jpa.demo.base.BaseRepository;
import cn.sf.w2.core.infrastructure.entities.W2User;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface W2UserRepository extends BaseRepository<W2User, UUID> {
}
