package com.mcd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mcd.service.Service;

public class RegisterMoneyController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String money = request.getParameter("money");
	if (money.isEmpty()) {
		request.setAttribute("error", "모든 항목을 입력하십시오.");
		HttpUtil.forward(request, response, "mypage.jsp");
		return;
	}
	Service service = Service.getInstanse();
	HttpSession s = request.getSession();
	String id = (String) s.getAttribute("id");
	service.registerMoney(id, money);
	request.setAttribute("error", money+"원 충전 완료되었습니다.");
	HttpUtil.forward(request, response, "mypage.jsp");
	return;
	}
}
