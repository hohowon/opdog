package com.opdogkl.shop.snack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opdoghw.login.LoginDAO;
import com.opdogkl.shop.feed.FeedDAO;

import javax.servlet.annotation.WebServlet;

@WebServlet("/SnackC")
public class SnackC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 강아지 간식 전체 조회하는일
		SnackDAO.getAllSnack(request);
//		SnackDAO.paging(1, request);
		
		request.setAttribute("contentPage", "../2_shop/2_3_snack/snack.jsp");
		LoginDAO.loginCheck(request);
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
