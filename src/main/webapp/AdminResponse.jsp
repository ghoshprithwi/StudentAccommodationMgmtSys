<%@page import="roomdata.Room"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Admin Dashboard</title>
   <link rel="stylesheet" href="./styles/response.css" />
  </head>
  <body>
  	  <nav>
	      <ul>
	        <li>
	        	<a href="AddRoom.jsp">
	        		<button class="checkin-button">&plus; ADD ROOM</button>
	        	</a>
	        </li>
	        <li><a href="login.html"><button id="logout-button">Logout</button></a></li>
	      </ul>
      </nav>
      <h1>All Rooms</h1>
      <%ArrayList<Room> rooms = (ArrayList<Room>)session.getAttribute("roomList");
      if(rooms.isEmpty()) {%>
        <p style="color: red;font-weight: bold;font-size: 1.5em;text-align:center;"> No Records </p>
        <%} else {%>
      <table>
         <tr>
          <th>Room No.</th>
          <th><b>Room Type</b></th>
          <th><b>Room Location</b></th>
          <th><b>Room Status</b></th>
          <th><b>Payment Status</b></th>
          <th><b>Room Charges</b></th>
          <th colspan="2"><b>Actions</b></th>
         </tr>
        

        <%for(Room room:rooms){%>
            <tr>
            	<td><%=room.getRoomId() %></td>
                <td><%=room.getRoomType()%></td>
                <td><%=room.getRoomLocation()%></td>
                <td><%=room.getRoomStatus()%></td>
                <td><%=room.getPaymentStatus() %></td>
                <td><%=room.getRoomCharges() %></td>
                <td>
                	<form action="UpdateRoom.jsp">
                		<input type="hidden" name="updateRoomId" value="<%= room.getRoomId() %>" />
                		<button type="submit" class="update-button">UPDATE</button>
                	</form>
                </td>
                <td>
                	<form action="DeleteRoomHandler">
                		<input type="hidden" name="roomId" value="<%= room.getRoomId() %>" />
                		<button type="submit" class="checkout-button">DELETE</button>
                	</form>
                </td>
            </tr>
            <%}%>
        </table>
        <%}%>
    </body>
</html>