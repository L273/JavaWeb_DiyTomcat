package com.ddd.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class URLFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("URLFilter 的 destroy()被调用");
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		
		String url = request.getRequestURL().toString();
		
		System.out.println("url filter:" + url);
		
		//放行
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig arg0) 
			throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
