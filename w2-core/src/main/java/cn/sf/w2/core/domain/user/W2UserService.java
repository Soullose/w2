package cn.sf.w2.core.domain.user;

import cn.sf.w2.core.infrastructure.entities.W2User;

public interface W2UserService {

    /**
     * 注册用户
     * @return
     */
    public W2User register();

    public W2User loadW2UserByEmail(String email);
}
