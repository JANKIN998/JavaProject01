/**
 * 
 */
package com.abc.hotelsys.dao;

import java.util.List;
import java.util.Map;

import com.abc.hotelsys.domain.Hotel;

/**
 * @author joeyang-ong
 *
 */
public interface HotelDao {
	
	void addHotel(Hotel hotel);
	List<Hotel> loadHotels();
	void delHotel(int hotelId);
	Hotel getHotelById(int hotelId);
	void updateHotel(Hotel hotel);
	byte[] getHotelPicById(int hotelId);
	
}
