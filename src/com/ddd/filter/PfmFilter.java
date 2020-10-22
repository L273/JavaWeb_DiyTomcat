package com.ddd.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PfmFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		
		String url = request.getRequestURL().toString();
		long start = System.currentTimeMillis();
		
		//����
		filterChain.doFilter(servletRequest,servletResponse);
		
		long end= System.currentTimeMillis();
		
		System.out.println((end-start) + "ms elapsed on url:" + url);
		
	}

	@Override
	public void init(FilterConfig filterConfig) 
			throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("PrmFilter �ĳ�ʼ��������");
		Enumeration<String> enumeration = filterConfig.getInitParameterNames();
		
		while(enumeration.hasMoreElements()){
			String name = enumeration.nextElement();
			String value = filterConfig.getInitParameter(name);
			
			System.out.println("name:" + name);
			System.out.println("value:" + value);
		}
	}
	
	
	
}
