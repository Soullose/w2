package cn.sf.w2.core.framework.security.handler.login;

import java.io.IOException;
import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;


public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	JwtEncoder encoder;

	public LoginSuccessHandler(JwtEncoder encoder) {
		this.encoder = encoder;
	}

	/**
	 * 当用户已成功通过身份验证时调用。
	 *
	 * @param request        导致身份验证成功的请求
	 * @param response       响应
	 * @param authentication the <tt>Authentication</tt> object which was created
	 *                       during
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		response.setContentType("application/json;charset=utf-8");
		Instant now = Instant.now();
		long expiry = 36000L;
		// @formatter:off
		String scope = authentication.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(" "));
		JwtClaimsSet claims = JwtClaimsSet.builder()
				.issuer("self")
				.issuedAt(now)
				.expiresAt(now.plusSeconds(expiry))
				.subject(authentication.getName())
				.claim("scope", scope)
				.build();
		String tokenValue = this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
		StringBuilder wwwAuthenticate = new StringBuilder();
		wwwAuthenticate.append("Bearer");
		wwwAuthenticate.append(" ");
		wwwAuthenticate.append(tokenValue);
		response.addHeader(HttpHeaders.WWW_AUTHENTICATE, wwwAuthenticate.toString());
		response.setStatus(HttpStatus.OK.value());
	}

	private static String computeWWWAuthenticateHeaderValue(Map<String, String> parameters) {
		StringBuilder wwwAuthenticate = new StringBuilder();
		wwwAuthenticate.append("Bearer");
		if (!parameters.isEmpty()) {
			wwwAuthenticate.append(" ");
			int i = 0;
			for (Map.Entry<String, String> entry : parameters.entrySet()) {
				wwwAuthenticate.append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
				if (i != parameters.size() - 1) {
					wwwAuthenticate.append(", ");
				}
				i++;
			}
		}
		return wwwAuthenticate.toString();
	}
}
