package roomdata;


public class Room {
	private String roomType, roomLocation, roomStatus, paymentStatus;
	private int roomId;
	private double roomCharges;
	
	public Room(int roomId, String roomType, String roomLocation, double roomCharges) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomLocation = roomLocation;
		setRoomStatus("Available");
		setPaymentStatus("Not Paid");
		this.roomCharges = roomCharges;
	}
	
	public int getRoomId() {
		return roomId;
	}
	
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomLocation() {
		return roomLocation;
	}
	public void setRoomLocation(String roomLocation) {
		this.roomLocation = roomLocation;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public double getRoomCharges() {
		return roomCharges;
	}
	public void setRoomCharges(double roomCharges) {
		this.roomCharges = roomCharges;
	}
}
