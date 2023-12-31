package com.opdoghw.naming;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opdoghw.login.LoginDAO;

@WebServlet("/NamingMainC")
public class NamingMainC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginDAO.loginCheck(request);
		request.setAttribute("contentPage", "../4_service/4_2_naming/namingYourDog.jsp");
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
