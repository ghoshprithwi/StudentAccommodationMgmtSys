<%@page import="roomdata.Room"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Available Rooms</title>
  <link rel="stylesheet" href="./styles/response.css" />
</head>

<body>
  <%response.setHeader("Cache-Control", "no-cache, no-store ,must-revalidate"); %>
  <nav>
     <ul>
       <li><a href="StudentResponse.jsp"><button id="logout-button">&xlarr; Back to Student Dashboard</button></a></li>
     </ul>
  </nav>
  <h1>Available Rooms to Check In</h1>
  <table>
    <tr>
      <th>Room No.</th>
      <th><b>Room Type</b></th>
      <th><b>Room Location</b></th>
      <th><b>Room Charges</b></th>
      <th><b>Actions</b></th>
    </tr>

    <%ArrayList<Room> rooms = (ArrayList<Room>)session.getAttribute("roomList");
  
        for(Room room:rooms){
        	if(room.getRoomStatus().equals("Available")) {%>
			    <tr>
			      <td><%=room.getRoomId() %></td>
			      <td><%=room.getRoomType()%></td>
			      <td><%=room.getRoomLocation()%></td>
			      <td><%=room.getRoomCharges() %></td>
			      <td>
			      	<form action="CheckInHandler">
			           <input type="hidden" name="roomId" value="<%= room.getRoomId() %>" />
			           <button type="submit" id="invokesToastMessage" class="checkin-button">CHECK IN</button>
			        </form>
			      </td>
			    </tr>
		    <%}%>
		 <%}%>
  </table>
</body>

</html>