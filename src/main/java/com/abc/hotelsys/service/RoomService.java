/**
 * 
 */
package com.abc.hotelsys.service;

import java.util.List;

import com.abc.hotelsys.domain.Room;
import com.abc.hotelsys.utils.Page;

/**
 * @author joeyang-ong
 *
 */
public interface RoomService {
	
	void createRoom(Room room);
	List<Room> loadRooms();
	List<Room> loadRooms(RoomQueryHelper helper);
	Page loadPagedRooms(RoomQueryHelper helper, Page page);
	void removeRoom(int roomId);
	Room getRoomById(int roomId);
	void updateRoom(Room room);

}
