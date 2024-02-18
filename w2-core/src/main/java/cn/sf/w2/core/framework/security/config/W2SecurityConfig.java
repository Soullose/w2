package cn.sf.w2.core.framework.security.config;

import static org.springframework.security.config.Customizer.withDefaults;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import cn.sf.w2.core.framework.security.handler.login.LoginFailureHandler;
import cn.sf.w2.core.framework.security.handler.login.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class W2SecurityConfig {

	@Value("${jwt.public.key}")
	RSAPublicKey key;

	@Value("${jwt.private.key}")
	RSAPrivateKey priv;

//	@Autowired
//	private LoginSuccessHandler loginSuccessHandler;

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests((authorize) -> authorize
//						.anyRequest().authenticated()
//				.antMatchers("/doc.html", "/webjars/**", "/v2/api-docs", "/swagger-resources/**", "/favicon.ico").permitAll()
//				.anyRequest().authenticated())
//				.httpBasic(Customizer.withDefaults())
//				.formLogin(Customizer.withDefaults())
//
//		;
//
//		return http.build();
//
//	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http
				.authorizeHttpRequests((authorize) -> authorize
//						.anyRequest().authenticated()
						.antMatchers("/login", "/doc.html", "/webjars/**", "/v2/api-docs", "/swagger-resources/**", "/favicon.ico").permitAll()
						.antMatchers("/**").authenticated()
								//.and().authenticationManager()
				)
//				.formLogin()
//				.loginProcessingUrl("/login")
				.csrf((csrf) -> csrf.ignoringAntMatchers("/login"))
//
//				.httpBasic(withDefaults())
//
				.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
				.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//				.exceptionHandling((exceptions) -> exceptions
//						.authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
//						.accessDeniedHandler(new BearerTokenAccessDeniedHandler())
//				)
				.formLogin(withDefaults())
				.formLogin().successHandler(loginSuccessHandler()).failureHandler(loginFailureHandler())
//				.httpBasic(withDefaults())

		;
		// @formatter:on
		return http.build();
	}



	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler(jwtEncoder());
	}

	@Bean
	public AuthenticationFailureHandler loginFailureHandler() {
		return new LoginFailureHandler();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails adminUserDetails = User.withUsername("admin").password("{noop}123456").roles("ADMIN","Manager").build();
		UserDetails testUserDetails = User.withUsername("test").password("{noop}123456").roles("Test","Manager").build();
		return new InMemoryUserDetailsManager(adminUserDetails,testUserDetails);
	}

	@Bean
	JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withPublicKey(this.key).build();
	}

	@Bean
	JwtEncoder jwtEncoder() {
		JWK jwk = new RSAKey.Builder(this.key).privateKey(this.priv).build();
		JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
		return new NimbusJwtEncoder(jwks);
	}

}
