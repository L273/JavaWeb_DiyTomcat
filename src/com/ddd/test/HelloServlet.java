package com.ddd.test;

import java.io.IOException;
import java.nio.charset.CoderMalfunctionError;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	public HelloServlet() {
		// TODO Auto-generated constructor stub
		//构造方法时运行
		System.out.println(this + " 的构造方法");
	}
	
	public void init(ServletConfig servletConfig){
		//初始化的时候运行
		String author = servletConfig.getInitParameter("author");
		String site = servletConfig.getInitParameter("site");
		
		System.out.println(this + " 的初始化方法 init");
        System.out.println("获取到了参数 author:" + author);
        System.out.println("获取到了参数 site:" + site);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		
		resp.getWriter().println("<h1>第一次修改@"+this+"</h1>");

		try {
			Class clazz = Class.forName("com.mysql.jdbc.Driver");
			resp.getWriter().println("<h1>clazz:"+clazz+"</h1>");
			resp.getWriter().println("<h1>ClassLoader:"+clazz.getClassLoader()+"</h1>");
			
			//resp.getWriter().println(req.getAttribute("test"));
			
			
			//头部的信息打印
			String userAgent = req.getHeader("User-Agent");
            resp.getWriter().println("User-Agent的值是：\t"+userAgent);
            
            resp.getWriter().println("URL的值是："+req.getRequestURL());
            
          
	
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//设置cookie
		//测试服务器的response运行情况
//		try{
//			Cookie c = new Cookie("name","TestCookie");
//			
//			//设置的单位是秒，60s*60*24即24小时
//			c.setMaxAge(60*24*60);
//			c.setPath("/");
//			
//			resp.addCookie(c);
//			resp.getWriter().println("set cookie successful");
//			
//		}catch(Exception exception){
//			exception.printStackTrace();
//		}
//		
		//测试request的cookies
		try {
			resp.getWriter().println(req.getSession().getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//resp.sendRedirect("a.jsp");
		
		req.setAttribute("name", "刘世辉");
		req.getRequestDispatcher("/a.jsp").forward(req, resp);
		
	}
	
	public void destroy() {
		//销毁的时候，运行
		System.out.println(this + "被销毁");
	}
}
