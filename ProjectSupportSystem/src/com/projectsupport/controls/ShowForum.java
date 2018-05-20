package com.projectsupport.controls;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.projectsupport.models.User;
import com.projectsupport.services.MyUtils;

/**
 * Servlet implementation class ShowForum
 */
@WebServlet("/ShowForum")
public class ShowForum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowForum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		com.projectsupport.models.User loginedUser =  MyUtils.getLoginedUser(session);
		
		
		if(loginedUser.getPosition().equals("student")){
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/student/forum.jsp");
			dispatcher.forward(request, response);
			
		}
		
		else if(loginedUser.getPosition().equals("project")){
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/projectcoordinator/forum.jsp");
			dispatcher.forward(request, response);
		}
		else if(loginedUser.getPosition().equals("supervisor")){
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/supervisor/forum.jsp");
			dispatcher.forward(request, response);
		}
		
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
