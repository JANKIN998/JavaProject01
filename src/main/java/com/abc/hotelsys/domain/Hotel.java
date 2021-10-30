/**
 * 
 */
package com.abc.hotelsys.domain;

/**
 * @author joeyang ong
 *
 */
public class Hotel extends ValueObject {
	
	/** �ֵ�ı�� */
	private int hotelId;
	
	/** �ֵ������ */
	private String hotelName;
	
	/** �ֵ�ĵ�ַ */
	private String hotelAddr;
	
	/** �ֵ�ĵ绰 */
	private String hotelPhone;
	
	/** �ֵ�ķ�������*/
	private int hotelRoomCount;
	
	/** �ֵ��ͼƬ */
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
