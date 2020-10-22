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
		//���췽��ʱ����
		System.out.println(this + " �Ĺ��췽��");
	}
	
	public void init(ServletConfig servletConfig){
		//��ʼ����ʱ������
		String author = servletConfig.getInitParameter("author");
		String site = servletConfig.getInitParameter("site");
		
		System.out.println(this + " �ĳ�ʼ������ init");
        System.out.println("��ȡ���˲��� author:" + author);
        System.out.println("��ȡ���˲��� site:" + site);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		
		resp.getWriter().println("<h1>��һ���޸�@"+this+"</h1>");

		try {
			Class clazz = Class.forName("com.mysql.jdbc.Driver");
			resp.getWriter().println("<h1>clazz:"+clazz+"</h1>");
			resp.getWriter().println("<h1>ClassLoader:"+clazz.getClassLoader()+"</h1>");
			
			//resp.getWriter().println(req.getAttribute("test"));
			
			
			//ͷ������Ϣ��ӡ
			String userAgent = req.getHeader("User-Agent");
            resp.getWriter().println("User-Agent��ֵ�ǣ�\t"+userAgent);
            
            resp.getWriter().println("URL��ֵ�ǣ�"+req.getRequestURL());
            
          
	
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//����cookie
		//���Է�������response�������
//		try{
//			Cookie c = new Cookie("name","TestCookie");
//			
//			//���õĵ�λ���룬60s*60*24��24Сʱ
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
		//����request��cookies
		try {
			resp.getWriter().println(req.getSession().getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//resp.sendRedirect("a.jsp");
		
		req.setAttribute("name", "������");
		req.getRequestDispatcher("/a.jsp").forward(req, resp);
		
	}
	
	public void destroy() {
		//���ٵ�ʱ������
		System.out.println(this + "������");
	}
}
