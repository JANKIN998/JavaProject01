/**
 * 
 */
package com.abc.hotelsys.service;

import java.util.List;

import com.abc.hotelsys.dao.*;
import com.abc.hotelsys.domain.Hotel;
import com.abc.hotelsys.domain.Room;
import com.abc.hotelsys.utils.Page;

/**
 * @author joeyang-ong
 *
 */
public class RoomServiceImpl implements RoomService {

	/* (non-Javadoc)
	 * @see com.abc.hotelsys.service.RoomService#createRoom(com.abc.hotelsys.domain.Room)
	 */
	@Override
	public void createRoom(Room room) {
		
		RoomDao roomDao = new RoomDaoMybatisImpl();
		HotelDao hotelDao = new HotelDaoMybatisImpl();
		
		Hotel hotel = hotelDao.getHotelById(room.getHotel().getHotelId());
		
		roomDao.addRoom(room);
		
		hotel.setHotelRoomCount(hotel.getHotelRoomCount()+1);
		hotelDao.updateHotel(hotel);
		

	}

	@Override
	public List<Room> loadRooms() {
		RoomDao roomDao = new RoomDaoJDBCImpl();
		return roomDao.loadRooms();
	}

	@Override
	public void removeRoom(int roomId) {
		
		RoomDao roomDao = new RoomDaoMybatisImpl();
		HotelDao hotelDao = new HotelDaoMybatisImpl();
		
		Hotel hotel = roomDao.getRoomById(roomId).getHotel();
		hotel.setHotelPic(hotelDao.getHotelPicById(hotel.getHotelId()));
		roomDao.delRoom(roomId);
		
		hotel.setHotelRoomCount(hotel.getHotelRoomCount()-1);
		hotelDao.updateHotel(hotel);
		
	}

	@Override
	public Room getRoomById(int roomId) {
		RoomDao roomDao = new RoomDaoMybatisImpl();
		return roomDao.getRoomById(roomId);
	}

	@Override
	public void updateRoom(Room room) {
		
		RoomDao roomDao = new RoomDaoMybatisImpl();
		HotelDao hotelDao = new HotelDaoMybatisImpl();
		
		Hotel oldHotel = this.getRoomById(room.getRoomId()).getHotel();
		oldHotel.setHotelPic(hotelDao.getHotelPicById(oldHotel.getHotelId()));
		Hotel newHotel = hotelDao.getHotelById(room.getHotel().getHotelId());
		newHotel.setHotelPic(hotelDao.getHotelPicById(newHotel.getHotelId()));
		
		roomDao.updateRoom(room);
		
		if(oldHotel.getHotelId()!=newHotel.getHotelId()){
			System.out.println("发现换分店！");
			
			newHotel.setHotelRoomCount(newHotel.getHotelRoomCount()+1);
			oldHotel.setHotelRoomCount(oldHotel.getHotelRoomCount()-1);
			
			hotelDao.updateHotel(newHotel); 
			hotelDao.updateHotel(oldHotel);
		}
		else
			System.out.println("没有换分店！");

	}

	@Override
	public List<Room> loadRooms(RoomQueryHelper helper) {
		RoomDao roomDao = new RoomDaoJDBCImpl();
		return roomDao.loadRooms(helper);
	}

	@Override
	public Page loadPagedRooms(RoomQueryHelper helper, Page page) {
		
		RoomDao roomDao = new RoomDaoMybatisImpl();
		
		page.setTotalRecNum(roomDao.cntRoomsByCondition(helper));
		page.setPageContent(roomDao.loadScopedRooms(helper, page.getStartIndex(), page.getPageSize()));
		
		return page;
	}

}
