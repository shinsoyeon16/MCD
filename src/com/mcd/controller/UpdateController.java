package com.mcd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mcd.service.Service;
import com.mcd.vo.Member;

public class UpdateController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		String id = (String) s.getAttribute("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");

		Service service = Service.getInstanse();
		Member m = new Member(id, passwd, name, phoneNumber);
		service.update(m);
		request.setAttribute("error", "ȸ������ ������ �Ϸ�Ǿ����ϴ�.");
		HttpUtil.forward(request, response, "mypage.jsp");
	}
}
