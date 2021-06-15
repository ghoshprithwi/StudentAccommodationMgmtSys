<%@page import="roomdata.Room"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Dashboard</title>
<link rel="stylesheet" href="./styles/response.css" />
</head>

<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store ,must-revalidate");
	%>

	<nav>
		<ul>
			<li><a href="CheckIn.jsp"><button class="checkin-button">&rarrhk;
						CHECK IN</button></a></li>
			<li><a href="login.html"><button id="logout-button">Logout</button></a></li>
		</ul>
	</nav>
	<h1>Checked In Rooms</h1>
	<%
		ArrayList<Room> rooms = (ArrayList<Room>) session.getAttribute("studentRoomList");
		if (rooms.isEmpty()) {
	%>
	<p
		style="color: red; font-weight: bold; font-size: 1.5em; text-align: center;">No
		Check-Ins</p>
	<%
		} else {
	%>
	<table>
		<tr>
			<th>Room No.</th>
			<th><b>Room Type</b></th>
			<th><b>Room Location</b></th>
			<th><b>Room Charges</b></th>
			<th><b>Actions</b></th>
		</tr>

		<%
			for (Room room : rooms) {
		%>
		<tr>
			<td><%=room.getRoomId()%></td>
			<td><%=room.getRoomType()%></td>
			<td><%=room.getRoomLocation()%></td>
			<td><%=room.getRoomCharges()%></td>
			<td>
				<form action="CheckOutHandler">
					<input type="hidden" name="roomId" value="<%=room.getRoomId()%>" />
					<button type="submit" class="checkout-button">&larrhk;
						CHECK OUT</button>
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
	%>
</body>

</html>