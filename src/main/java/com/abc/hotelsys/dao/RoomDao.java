/**
 * 
 */
package com.abc.hotelsys.dao;

import java.util.List;

import com.abc.hotelsys.domain.Room;
import com.abc.hotelsys.service.RoomQueryHelper;
import org.apache.ibatis.annotations.Param;

/**
 * @author joeyang-ong
 *
 */
public interface RoomDao {
	
	void addRoom(Room room);
	List<Room> loadRooms();
	List<Room> loadRooms(RoomQueryHelper helper);
	void delRoom(int roomId);
	Room getRoomById(int roomId);
	void updateRoom(Room room);
	
	/**
	 * 查询在某种查询条件下得到的房间的数量
	 * @param helper
	 * @return
	 */
	long cntRoomsByCondition(RoomQueryHelper helper);
	
	/**
	 * 获得某查询条件下的某范围的记录信息
	 * @param helper      查询条件
	 * @param startIdx    开始范围
	 * @param fetchSize   取的条数
	 * @return
	 */
	List<Room> loadScopedRooms(@Param("helper") RoomQueryHelper helper,
							   @Param("start") int startIdx,
							   @Param("size") int fetchSize);

}
