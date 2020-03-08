package com.zw.filter;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AuthorizedRequestFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		String auth = "admin:123456";
		byte[] encodeAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodeAuth);
		context.addZuulRequestHeader("Authorization", authHeader);
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
