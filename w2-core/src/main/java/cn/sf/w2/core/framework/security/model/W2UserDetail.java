package cn.sf.w2.core.framework.security.model;

import java.util.Collection;

import cn.sf.w2.core.infrastructure.entities.W2User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class W2UserDetail implements UserDetails {

	private final W2User w2User;

	public W2UserDetail(W2User w2User) {
		this.w2User = w2User;
	}

	public W2User getW2User() {
		return this.w2User;
	}

	/**
	 * 返回授予用户的权限。无法返回 null。
	 *
	 * @return 权限，按自然键排序（从不<code>为空<code>）
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	/**
	 * 返回用于对用户进行身份验证的密码。
	 *
	 * @return 密码
	 */
	@Override
	public String getPassword() {
		return w2User.getPassword();
	}

	/**
	 * 返回用于对用户进行身份验证的用户名。无法返回
	 *
	 * @return 用户名
	 */
	@Override
	public String getUsername() {
		return w2User.getEmail();
	}

	/**
	 * 指示用户的帐户是否已过期。过期的帐户无法进行身份验证
	 *
	 * @return 如果用户的帐户有效（即未过期），则为 true， false 如果不再有效（即已过期）
	 */
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	/**
	 * 指示用户是已锁定还是已解锁。无法对锁定的用户进行身份验证。
	 *
	 * @return 如果用户未锁定，则为 true，如果用户未锁定，则为 false
	 */
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	/**
	 * 指示用户的凭据（密码）是否已过期。过期的凭据会阻止身份验证。
	 *
	 * @return 如果用户的凭据有效（即未过期），则为 true，如果不再有效（即已过期），则为 false。
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	/**
	 * 指示用户是启用还是禁用。无法对已禁用的用户进行身份验证。
	 *
	 * @return 如果用户已启用，则为 true，否则为 false。
	 */
	@Override
	public boolean isEnabled() {
		return false;
	}
}
