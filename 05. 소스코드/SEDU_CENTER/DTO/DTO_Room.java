package DTO;

public class DTO_Room {

	private String room_seq; // 강의실 번호(PK)
	private String roomName; // 강의실명
	
	public String getRoom_seq() {
		return room_seq;
	}
	public void setRoom_seq(String room_seq) {
		this.room_seq = room_seq;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	
	
}
