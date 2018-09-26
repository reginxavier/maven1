package com.serve;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
	String s=request.getParameter("uname");
		String t=request.getParameter("pwd");
		HttpSession session=request.getSession();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","admin");
			Statement st=con.createStatement();
			String sql="select * from shop where uname='"+s+"'and pwd='"+t+"'";
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
				response.sendRedirect("welcome.jsp");
			}
			else
			{
				session.setAttribute("aa", "invalid");
			}
		con.close();
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
		doGet(request, response);
	}

}
