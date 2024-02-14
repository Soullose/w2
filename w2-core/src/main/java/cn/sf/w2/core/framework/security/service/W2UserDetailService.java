package cn.sf.w2.core.framework.security.service;

import cn.sf.w2.core.domain.user.W2UserService;
import cn.sf.w2.core.framework.security.model.W2UserDetail;
import cn.sf.w2.core.infrastructure.entities.W2User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class W2UserDetailService implements UserDetailsService {

    private final W2UserService service;

    public W2UserDetailService(W2UserService userService) {
        this.service = userService;
    }

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        W2User w2User = service.loadW2UserByEmail(username);
        if (w2User.equals(null)) {
            return null;
        } else {
            return new W2UserDetail(w2User);
        }
    }
}
