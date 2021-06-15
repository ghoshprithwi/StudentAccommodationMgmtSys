<%@page import="roomdata.Room"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Update Room Details</title>
  <link rel="stylesheet" href="./styles/login.css" />
  <link rel="stylesheet" href="./styles/add_room.css" />
</head>

<%
	int updateRoomId = Integer.parseInt(request.getParameter("updateRoomId"));
	
	ArrayList<Room> rooms = (ArrayList<Room>)session.getAttribute("roomList");
	
	int indexToUpdate = 0;
	for(int roomIndex = 0; roomIndex < rooms.size(); roomIndex++) {
		if(rooms.get(roomIndex).getRoomId() == updateRoomId) {
			indexToUpdate = roomIndex;
		}
	}
%>

<body>
  <div id="wrapper">
    <div id="form-container">
      <h1>Update Existing Room</h1>
      <form action="UpdateRoomHandler">
        <label for="roomNum">Room Number</label>
        <input style="background-color: red" type="number" name="roomNum" id="roomNum" min="0" value=<%=updateRoomId%> readonly>
        
        <label for="roomType">Room Type</label>
        <input name="roomType" id="roomType" value="<%=rooms.get(indexToUpdate).getRoomType()%>" required>
          
        
        <label for="roomLoc">Location</label>
        <input name="roomLoc" id="roomLoc" value="<%=rooms.get(indexToUpdate).getRoomLocation()%>" required>
          
        <label for="monthlyCharge">Monthly Charge</label>
        <input type="number" name="monthlyCharge" id="monthlyCharge" value=<%=rooms.get(indexToUpdate).getRoomCharges()%> required>
        <button type="submit">Update Room</button>
      </form>
    </div>
  </div>
</body>

</html>