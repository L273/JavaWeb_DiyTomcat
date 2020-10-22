package com.ddd.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		try{
			String name = req.getParameter("name");
			resp.getWriter().print("get name:" + name);
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		try{
			String name = req.getParameter("name");
			resp.getWriter().print("get name:" + name);
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
}