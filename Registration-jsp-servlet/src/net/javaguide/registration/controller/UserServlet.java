package net.javaguide.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguide.registration.dao.UserDao;
import net.javaguide.registration.model.User;

@WebServlet("/register")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDao userDao = new UserDao();
    
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/UserRegister.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserName(userName);
		user.setPassword(password);
		user.setAddress(address);
		user.setContact(contact);
		
		try {
			userDao.registerUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/UserDetail.jsp");
		dispatcher.forward(request, response);
	}

}
