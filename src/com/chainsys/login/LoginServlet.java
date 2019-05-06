package com.chainsys.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.auth.Authentication;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("Email");
		String password=request.getParameter("Password");
		System.out.println(userName+" "+password);
		Authentication authentication=new Authentication();
		boolean success;
		try {
			success = authentication.isLogin(userName,password);
			if(success)
			{
				RequestDispatcher rs=request.getRequestDispatcher("success.html");
				rs.forward(request, response);
			}else
			{
				RequestDispatcher rs=request.getRequestDispatcher("Failure.html");
				rs.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
