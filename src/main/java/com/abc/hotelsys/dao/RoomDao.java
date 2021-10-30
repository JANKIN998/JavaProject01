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
	 * ��ѯ��ĳ�ֲ�ѯ�����µõ��ķ��������
	 * @param helper
	 * @return
	 */
	long cntRoomsByCondition(RoomQueryHelper helper);
	
	/**
	 * ���ĳ��ѯ�����µ�ĳ��Χ�ļ�¼��Ϣ
	 * @param helper      ��ѯ����
	 * @param startIdx    ��ʼ��Χ
	 * @param fetchSize   ȡ������
	 * @return
	 */
	List<Room> loadScopedRooms(@Param("helper") RoomQueryHelper helper,
							   @Param("start") int startIdx,
							   @Param("size") int fetchSize);

}
