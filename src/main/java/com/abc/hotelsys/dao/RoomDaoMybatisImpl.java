package com.abc.hotelsys.dao;

import com.abc.hotelsys.domain.Room;
import com.abc.hotelsys.service.RoomQueryHelper;
import com.abc.hotelsys.utils.MyBatisUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomDaoMybatisImpl implements RoomDao{

    @Override
    public void addRoom(Room room) {
        SqlSession session = MyBatisUtils.getSession();
        session.insert("com.abc.hotelsys.dao.RoomDao.addRoom",room);
        session.commit();
        MyBatisUtils.closeSession(session);
    }

    @Override
    public List<Room> loadRooms() {
        return null;
    }

    @Override
    public List<Room> loadRooms(RoomQueryHelper helper) {
        return null;
    }

    @Override
    public void delRoom(int roomId) {
        SqlSession session = MyBatisUtils.getSession();
        session.delete("com.abc.hotelsys.dao.RoomDao.delRoom",roomId);
        session.commit();
        MyBatisUtils.closeSession(session);
    }

    @Override
    public Room getRoomById(int roomId) {
        SqlSession session = MyBatisUtils.getSession();
        Room room = session.selectOne("com.abc.hotelsys.dao.RoomDao.getRoomById", roomId);
        session.commit();
        MyBatisUtils.closeSession(session);
        return room;
    }

    @Override
    public void updateRoom(Room room) {
        SqlSession session = MyBatisUtils.getSession();
        session.update("com.abc.hotelsys.dao.RoomDao.updateRoom", room);
        session.commit();
        MyBatisUtils.closeSession(session);
    }

    @Override
    public long cntRoomsByCondition(RoomQueryHelper helper) {
        SqlSession session = MyBatisUtils.getSession();
        long cnt = session.selectOne("com.abc.hotelsys.dao.RoomDao.cntRoomsByCondition", helper);
        session.commit();
        MyBatisUtils.closeSession(session);
        return cnt;
    }

    @Override
    public List<Room> loadScopedRooms(@Param("helper") RoomQueryHelper helper,
                                      @Param("start") int startIdx,
                                      @Param("size") int fetchSize) {
        SqlSession session = MyBatisUtils.getSession();

        Map<String,Object> params = new HashMap<>();
        params.put("helper",helper);
        params.put("start",toString());
        params.put("size",fetchSize);

        List<Room> roomList = session.selectList("com.abc.hotelsys.dao.RoomDao.loadScopedRooms",params);
        session.commit();
        MyBatisUtils.closeSession(session);
        return  roomList;
    }

}
