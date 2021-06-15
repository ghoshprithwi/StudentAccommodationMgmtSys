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
 * Servlet implementation class UpdateRoomHandler
 */
@WebServlet("/UpdateRoomHandler")
public class UpdateRoomHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateRoomHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		int roomId = Integer.parseInt(request.getParameter("roomNum"));
		String roomLocation = request.getParameter("roomLoc");
		String roomType = request.getParameter("roomType");
		double roomCharges = Double.parseDouble(request.getParameter("monthlyCharge"));

		HttpSession session = request.getSession();
		ArrayList<Room> rooms = (ArrayList<Room>) session.getAttribute("roomList");

		Room updatedRoom = new Room(roomId, roomType, roomLocation, roomCharges);

		for (int roomIndex = 0; roomIndex < rooms.size(); roomIndex++) {
			if (rooms.get(roomIndex).getRoomId() == roomId) {
				rooms.set(roomIndex, updatedRoom);
			}
		}

		String currentUser = (String) session.getAttribute("user");

		if (currentUser.equals("admin")) {
			RequestDispatcher rd = request.getRequestDispatcher("AdminResponse.jsp");
			rd.include(request, response);
		} else if (currentUser.equals("student")) {
			RequestDispatcher rd = request.getRequestDispatcher("StudentResponse.jsp");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
