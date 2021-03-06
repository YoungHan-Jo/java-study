package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/member/logout.jsp", "/member/changePasswd.jsp", "/member/modifyMember.jsp",
		"/member/removeMember.jsp" })
public class LoginCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request; // 다운캐스팅
		HttpServletResponse res = (HttpServletResponse) response;

		// 요청 사용자의 세션 가져오기
		HttpSession session = req.getSession();

		String id = (String) session.getAttribute("id");

		//로그인 세션값 없으면, login.jsp로 이동
		if (id == null) {
			res.sendRedirect("/member/login.jsp");
			return;
		}
		
		chain.doFilter(request, response);
	}//doFilter

}
