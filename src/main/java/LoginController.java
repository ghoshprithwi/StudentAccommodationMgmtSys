

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import roomdata.Room;


/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "Handles login data", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Room> roomsList = new ArrayList<>();
	ArrayList<Room> studentRoomList = new ArrayList<>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	   	PrintWriter out = response.getWriter();
	   	
	   	//getting parameters from login form
	   	String username = request.getParameter("username");
	   	String password = request.getParameter("pwd");
	   	String loginRole = request.getParameter("loginRole");	
	   	
	   	//Setting parameters in Model
	   	LoginBean bean = new LoginBean();
	   	bean.setUserName(username);
	   	bean.setPassword(password);
	   	
	   	HttpSession session = request.getSession();
	   	request.setAttribute("bean", bean);
	   	session.setAttribute("roomList", roomsList);
	   	session.setAttribute("studentRoomList", studentRoomList);
	   	session.setAttribute("user", loginRole);
	   	
	   	//validating if user is Admin
	   	if(loginRole.equals("admin")) {
	   		if(bean.isUserAdmin()) {
	   			RequestDispatcher rd = request.getRequestDispatcher("AdminResponse.jsp");
	   			rd.include(request, response);
	   		} else {
	   			RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
	   			String errorMessage = "Wrong Credentials. Try Again!";
	   			out.println("<script type='text/javascript'>");
	   			out.println("alert(" + "'" + errorMessage + "'" + ");</script>");
	   			out.println("</head><body></body></html>");
	   		}
	   	}
	   	
	  //validating if user is Student
	   	if(loginRole.equals("student")) {
	   		if(bean.isUserStudent()) {
	   			RequestDispatcher rd = request.getRequestDispatcher("StudentResponse.jsp");
	   			rd.forward(request, response);
	   		} else {
	   			RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
	   			String errorMessage = "Wrong Credentials. Try Again!";
	   			out.println("<script type='text/javascript'>");
	   			out.println("alert(" + "'" + errorMessage + "'" + ");</script>");
	   			out.println("</head><body></body></html>");
	   		}
	   	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
