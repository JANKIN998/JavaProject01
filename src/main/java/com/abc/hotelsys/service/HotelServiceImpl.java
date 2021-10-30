/**
 * 
 */
package com.abc.hotelsys.service;

import java.util.List;

import com.abc.hotelsys.dao.HotelDao;
import com.abc.hotelsys.dao.HotelDaoJDBCImpl;
import com.abc.hotelsys.dao.HotelDaoMybatisImpl;
import com.abc.hotelsys.domain.Hotel;

/**
 * @author joeyang-ong
 *
 */
public class HotelServiceImpl implements HotelService {

	/* (non-Javadoc)
	 * @see com.abc.hotelsys.service.HotelService#createHotel(com.abc.hotelsys.domain.Hotel)
	 */
	@Override
	public void createHotel(Hotel hotel) {
		
		HotelDao hotelDao = new HotelDaoMybatisImpl();
		hotelDao.addHotel(hotel);

	}

	@Override
	public List<Hotel> loadHotels() {
		HotelDao hotelDao = new HotelDaoMybatisImpl();
		return hotelDao.loadHotels();
	}

	@Override
	public void removeHotel(int hotelId) {
		HotelDao hotelDao = new HotelDaoMybatisImpl();
		hotelDao.delHotel(hotelId);
	}

	@Override
	public Hotel loadHotelById(int hotelId) {
		HotelDao hotelDao = new HotelDaoMybatisImpl();
		return hotelDao.getHotelById(hotelId);
	}

	@Override
	public void updateHotel(Hotel hotel) {
		HotelDao hotelDao = new HotelDaoMybatisImpl();
		hotelDao.updateHotel(hotel);
	}

	@Override
	public byte[] loadPicById(int hotelId) {
		HotelDao hotelDao = new HotelDaoMybatisImpl();
		return hotelDao.getHotelPicById(hotelId);
	}

}
