package com.spean.servicecomb.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.spean.servicecomb.service.AuthenticationService;

/**
 * @author siping_huang
 * @Date 2019年7月22日 下午2:34:50
 * @Desc
 */
@Component
public class AuthFilter extends ZuulFilter {

	private static final String LOGIN_PATH = "/login";
	static final String TOKEN_PREFIX = "Bearer ";
	private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);
	@Autowired
	AuthenticationService authenticationService;

	@Override
	public boolean shouldFilter() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		if (request.getRequestURI().endsWith(LOGIN_PATH)) {
			return false;
		}
		return true;
	}

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();

		if (doesNotContainToken(context)) {
			logger.warn("No token found in request header");
			rejectRequest(context);
		} else {
			String token = token(context);
			ResponseEntity<String> responseEntity = authenticationService.validate(token);
			if (!responseEntity.getStatusCode().is2xxSuccessful()) {
				logger.warn("Unauthorized token {} and request rejected", token);
				rejectRequest(context);
			} else {
				logger.info("Token {} validated", token);
			}
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	private void rejectRequest(RequestContext context) {
		context.setResponseStatusCode(HttpStatus.SC_FORBIDDEN);
		context.setSendZuulResponse(false);
	}

	private boolean doesNotContainToken(RequestContext context) {
		return authorizationHeader(context) == null || !authorizationHeader(context).startsWith(TOKEN_PREFIX);
	}

	private String token(RequestContext context) {
		return authorizationHeader(context).replace(TOKEN_PREFIX, "");
	}

	private String authorizationHeader(RequestContext context) {
		return context.getRequest().getHeader(HttpHeaders.AUTHORIZATION);
	}
}
