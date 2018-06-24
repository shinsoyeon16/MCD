package com.mcd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mcd.service.Service;

public class LoginController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");

		Service service = Service.getInstanse();
		String dbPassword = service.login(id);
		if (id.isEmpty() || passwd.isEmpty()) {
			request.setAttribute("error", "모든 항목을 입력하십시오.");
			HttpUtil.forward(request, response, "/home.jsp");
			return;
		}
		if(id.equals("admin")&&passwd.equals("12345")) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", id);
			HttpUtil.forward(request, response, "/admin/index.jsp");
			return;
		}
		if (dbPassword == null) {
			request.setAttribute("error", "존재하지 않는 아이디 입니다.");
			HttpUtil.forward(request, response, "home.jsp");
			return;
		} else {
			if (!dbPassword.equals(passwd)) {
				request.setAttribute("error", "비밀번호가 다릅니다.");
				HttpUtil.forward(request, response, "home.jsp");
				return;
			} else if (dbPassword.equals(passwd)) {
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				HttpUtil.forward(request, response, "index.jsp");
				return;
			}

		}
	}

}