package cn.sf.w2.core.domain.user.impl;

import cn.sf.w2.core.framework.jpa.demo.model.Test;
import com.querydsl.core.types.QBean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cn.sf.w2.core.domain.user.W2UserService;
import cn.sf.w2.core.infrastructure.entities.W2User;
import cn.sf.w2.core.infrastructure.repository.W2UserRepository;
import lombok.extern.slf4j.Slf4j;

import static cn.sf.w2.core.infrastructure.entities.QW2User.w2User;
import static com.querydsl.core.types.Projections.bean;

/**
 * 用户业务逻辑
 */

@Slf4j
@Service
public class W2UserServiceImpl implements W2UserService {
	///
	final QBean<W2User> w2UserQBean = bean(W2User.class, w2User.Id, w2User.email, w2User.password);

	private final W2UserRepository repository;

	public W2UserServiceImpl(W2UserRepository w2UserRepository) {
		this.repository = w2UserRepository;
	}

	/**
	 * 注册用户
	 *
	 * @return
	 */
	@Override
	public W2User register() {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String encode = passwordEncoder.encode("123456");
		W2User w2User = new W2User();
		w2User.setEmail("sf@w2.cn");
		w2User.setPassword(encode);
		W2User user = repository.save(w2User);
		log.info("user:{}", user);
		return user;
	}

	@Override
	public W2User loadW2UserByEmail(String email) {
		return repository.selectFrom(w2User).where(w2User.email.eq(email)).fetchOne();
	}
}
