package com.opdogkl.shop.toy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opdoghw.login.LoginDAO;
@WebServlet("/ToyDetailC")
public class ToyDetailC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ToyDAO.getToy(request);
		request.setAttribute("contentPage", "../2_shop/2_4_toy/toyDetail.jsp");
		LoginDAO.loginCheck(request);
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
