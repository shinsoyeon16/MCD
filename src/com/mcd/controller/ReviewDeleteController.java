package com.mcd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mcd.service.Service;

public class ReviewDeleteController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		
		Service service = Service.getInstanse();
		service.reviewDelete(seq);
		HttpUtil.forward(request, response, "reviewList.jsp");
		return;
		
	}

}
