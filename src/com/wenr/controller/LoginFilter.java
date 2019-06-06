package com.wenr.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		final String projectName = "StudentAchievementManagementSystem"; 
		String url = request.getRequestURL().toString();
		int index = url.indexOf(projectName) + projectName.length();
		String subUrl = url.substring(index);
		
		if (subUrl.indexOf("admin") != -1) {
			if (session.getAttribute("admin") != null) {
				arg2.doFilter(arg0, arg1);
			} else {
				response.sendRedirect("index.jsp");
			}
		} else if (subUrl.indexOf("student") != -1) {
			if (session.getAttribute("student") != null) {
				arg2.doFilter(arg0, arg1);
			} else {
				response.sendRedirect("index.jsp");
			}
		} else {
			arg2.doFilter(arg0, arg1);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
