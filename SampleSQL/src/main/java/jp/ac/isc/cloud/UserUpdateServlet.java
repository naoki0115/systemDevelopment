package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection users = null;
		try {
			request.setCharacterEncoding("utf-8");
			users = DBConnection.openConnection();
			String id = request.getParameter("updateId");
			String name = request.getParameter("updateName");
			
			Statement state = users.createStatement();
			
			state.executeUpdate("UPDATE user_table SET name='" + name +"' WHERE id ='"+ id +"'");
			DBConnection.closeConnection(users,state);
			response.sendRedirect("/select");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
