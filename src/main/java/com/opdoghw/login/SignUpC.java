package com.opdoghw.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opdoghoho.doginfo.DoginfoDAO;

@WebServlet("/SignUpC")
public class SignUpC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("contentPage", "login/accountReg.jsp");
		LoginDAO.loginCheck(request);
		DoginfoDAO.sido(request); // 시/도 어트리뷰 세팅 메서드
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginDAO.regAccount(request);

		String pw = request.getParameter("pw");
		String pwck = request.getParameter("pwCheck");
		if (pw.equals(pwck)) {
			request.setAttribute("contentPage", "login/accountOK.jsp");
		} else {
			DoginfoDAO.sido(request);
			request.setAttribute("contentPage", "login/accountReg.jsp");

		}
		LoginDAO.loginCheck(request);
		request.getRequestDispatcher("0_main/contentPage.jsp").forward(request, response);

	}

}
