package com.abc.hotelsys.dao;

import com.abc.hotelsys.domain.Hotel;
import com.abc.hotelsys.exception.HotelSysException;
import com.abc.hotelsys.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class HotelDaoMybatisImpl implements HotelDao {

    @Override
    public void addHotel(Hotel hotel) {
        SqlSession session = MyBatisUtils.getSession();
        session.insert("com.abc.hotelsys.dao.HotelDao.addHotel",hotel);
        session.commit();
        MyBatisUtils.closeSession(session);
    }

    @Override
    public List<Hotel> loadHotels() {

        SqlSession session = MyBatisUtils.getSession();
        List<Hotel> hotelList = session.selectList("com.abc.hotelsys.dao.HotelDao.loadHotels");
        session.commit();
        MyBatisUtils.closeSession(session);

        return hotelList;

    }

    @Override
    public void delHotel(int hotelId) {
        SqlSession session = null;
        try {
            session = MyBatisUtils.getSession();
            session.delete("com.abc.hotelsys.dao.HotelDao.delHotel", hotelId);
            session.commit();
        }
        catch (Exception e) {
                e.printStackTrace();
                if(e.getMessage().contains("parent row")){
                    Hotel hotel = this.getHotelById(hotelId);
                    String msg = String.format("%s hotel has %d rooms!!", hotel.getHotelName(),hotel.getHotelRoomCount());
                    throw new HotelSysException(msg);
                }
        }finally{
                MyBatisUtils.closeSession(session);
        }
    }

    @Override
    public Hotel getHotelById(int hotelId) {
        SqlSession session = MyBatisUtils.getSession();
        Hotel hotel = session.selectOne("com.abc.hotelsys.dao.HotelDao.getHotelById",hotelId);
        session.commit();
        MyBatisUtils.closeSession(session);

        return hotel;
    }

    @Override
    public void updateHotel(Hotel hotel) {

        SqlSession session = MyBatisUtils.getSession();
        session.update("com.abc.hotelsys.dao.HotelDao.updateHotel",hotel);
        session.commit();
        MyBatisUtils.closeSession(session);

    }

    @Override
    public byte[] getHotelPicById(int hotelId) {

        SqlSession session = MyBatisUtils.getSession();
        Map dataMap = session.selectOne("com.abc.hotelsys.dao.HotelDao.getPicByHotelId",hotelId);
        session.commit();
        MyBatisUtils.closeSession(session);

        if(dataMap!=null)
           return (byte[])dataMap.get("imgBytes");
        else
           return null;
    }
}
