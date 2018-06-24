package com.mcd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mcd.service.Service;
import com.mcd.vo.Member;

public class JoinController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");

		if (id.isEmpty() || passwd.isEmpty() || name.isEmpty() || phoneNumber.isEmpty()) {
			request.setAttribute("error", "모든 항목을 입력하십시오.");
			HttpUtil.forward(request, response, "join.jsp");
			return;
		}

		Service service = Service.getInstanse();
		String dbPassword = service.login(id);
		if (dbPassword != null) {
			request.setAttribute("error", "이미 사용중인 아이디입니다.");
			HttpUtil.forward(request, response, "join.jsp");
			return;
		} else {
			Member m = new Member(id, passwd, name, phoneNumber);
			service.join(m);
			request.setAttribute("error", id + " 님 회원가입이 완료되었습니다.");
			HttpUtil.forward(request, response, "home.jsp");
		}
	}
}
