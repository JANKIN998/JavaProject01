/**
 * 
 */
package com.abc.hotelsys.domain;

/**
 * @author joeyang ong
 *
 */
public class Hotel extends ValueObject {
	
	/** 分店的编号 */
	private int hotelId;
	
	/** 分店的名称 */
	private String hotelName;
	
	/** 分店的地址 */
	private String hotelAddr;
	
	/** 分店的电话 */
	private String hotelPhone;
	
	/** 分店的房间数量*/
	private int hotelRoomCount;
	
	/** 分店的图片 */
	private byte[] hotelPic;

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelAddr() {
		return hotelAddr;
	}

	public void setHotelAddr(String hotelAddr) {
		this.hotelAddr = hotelAddr;
	}

	public String getHotelPhone() {
		return hotelPhone;
	}

	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}

	public int getHotelRoomCount() {
		return hotelRoomCount;
	}

	public void setHotelRoomCount(int hotelRoomCount) {
		this.hotelRoomCount = hotelRoomCount;
	}

	public byte[] getHotelPic() {
		return hotelPic;
	}

	public void setHotelPic(byte[] hotelPic) {
		this.hotelPic = hotelPic;
	}
		

}
