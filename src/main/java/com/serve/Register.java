package com.serve;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter pw=response.getWriter();
		String a=request.getParameter("name");
		String b=request.getParameter("uname");
		String c=request.getParameter("pwd");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","admin");
			Statement st=con.createStatement();
			String sql="insert into shop(name,uname,pwd)values('"+a+"','"+b+"','"+c+"')";
			int z=st.executeUpdate(sql);
			if(z==1)
			{
				response.sendRedirect("login.jsp");
			}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		doGet(request, response);
	}

}
