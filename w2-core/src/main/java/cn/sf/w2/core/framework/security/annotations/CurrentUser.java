package cn.sf.w2.core.framework.security.annotations;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AuthenticationPrincipal
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentUser {
}
