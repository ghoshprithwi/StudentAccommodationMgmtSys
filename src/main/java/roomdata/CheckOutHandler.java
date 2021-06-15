package roomdata;

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

/**
 * Servlet implementation class CheckOutHandler
 */
@WebServlet("/CheckOutHandler")
public class CheckOutHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOutHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int checkOutId = Integer.parseInt(request.getParameter("roomId"));
		out.print(checkOutId);

		HttpSession session = request.getSession();
		ArrayList<Room> rooms = (ArrayList<Room>) session.getAttribute("roomList");
		ArrayList<Room> studentRooms = (ArrayList<Room>) session.getAttribute("studentRoomList");

		for (int roomIndex = 0; roomIndex < rooms.size(); roomIndex++) {
			if (rooms.get(roomIndex).getRoomId() == checkOutId) {
				rooms.get(roomIndex).setRoomStatus("Available");
				studentRooms.remove(rooms.get(roomIndex));
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("StudentResponse.jsp");
		rd.include(request, response);
		String message = "Successfully Checked Out";
		out.println("<script type='text/javascript'>");
		out.println("alert(" + "'" + message + "'" + ");</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
