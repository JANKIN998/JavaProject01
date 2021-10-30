/**
 * 
 */
package com.abc.hotelsys.domain;

/**
 * @author joeyang ong
 *
 */
public class Room extends ValueObject {
	
	private Integer roomId;
	private String roomNo;
	private String roomType;
	private String[] roomEquip; // 屋内设置
	private String roomStatus;
	private String roomMemo;
	private Hotel hotel; // 房间所属的分店	
	
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String[] getRoomEquip() {
		return roomEquip;
	}
	public void setRoomEquip(String[] roomEquip) {
		this.roomEquip = roomEquip;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public String getRoomMemo() {
		return roomMemo;
	}
	public void setRoomMemo(String roomMemo) {
		this.roomMemo = roomMemo;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
			

}
