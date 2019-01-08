package me.junseok;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.mvcMatchers("/hi").authenticated()		// /hi 요청의 경우 인증
				.anyRequest().permitAll()				// 나머지 요청의 경우는 인증하지 않는다.
				.and()
				.formLogin()	// spring security가 제공하는 login page
				.and()
				.sessionManagement()
//				.sessionFixation()		// 세션 변조 방지 등등..
				.maximumSessions(1)		// 세션을 하나로 제한. (새로운 세션을 막는 것이 아니고 기존 세션을 만료)
				.maxSessionsPreventsLogin(true) // 새로 로그인하려는 세션을 막는다.
//				.expiredUrl("") // 세션만료된 경우 요청 url
				;
		
	}

}

