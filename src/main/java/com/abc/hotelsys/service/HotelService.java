package com.abc.hotelsys.service;

import java.util.List;

import com.abc.hotelsys.domain.Hotel;

public interface HotelService {
	
	void createHotel(Hotel hotel);
	List<Hotel> loadHotels();
	void removeHotel(int hotelId);
	Hotel loadHotelById(int hotelId);
	void updateHotel(Hotel hotel);
	byte[] loadPicById(int hotelId);

}
