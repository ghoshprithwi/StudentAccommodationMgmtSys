<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Add New Room</title>
  <link rel="stylesheet" href="./styles/login.css" />
  <link rel="stylesheet" href="./styles/add_room.css" />
</head>

<body>
  <div id="wrapper">
    <div id="form-container">
      <h1>Create New Room</h1>
      <form action="CreateRoomHandler">
        <label for="roomNum">Room Number</label>
        <input type="number" name="roomNum" id="roomNum" min="0" required>
        
        <label for="roomType">Room Type</label>
        <select name="roomType" id="roomType" required>
          <option value="Normal">Normal</option>
          <option value="Deluxe">Deluxe</option>
          <option value="Super Deluxe">Super Deluxe</option>
        </select>
        
        <label for="roomLoc">Location</label>
        <select name="roomLoc" id="roomLoc" required>
          <option value="East Wing">East Wing</option>
          <option value="West Wing">West Wing</option>
          <option value="North Wing">North Wing</option>
          <option value="South Wing">South Wing</option>
        </select>
        
        <label for="monthlyCharge">Monthly Charge</label>
        <input type="number" name="monthlyCharge" id="monthlyCharge">
        <button type="submit">Create Room</button>
      </form>
    </div>
  </div>
</body>

</html>