/**
 * 
 */
package com.abc.hotelsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.abc.hotelsys.domain.Hotel;
import com.abc.hotelsys.exception.HotelSysException;
import com.abc.hotelsys.utils.DBUtils;

/**
 * @author joeyang-ong
 *
 */
public class HotelDaoJDBCImpl implements HotelDao {
	
	private static final String SQL_ADD_HOTEL 
	   = "insert into tbl_hotels(hotel_name,hotel_addr,hotel_phone,hotel_pic) values(?,?,?,?)";
	private static final String SQL_LOAD_ALL = "select * from tbl_hotels order by hotel_id desc";
	private static final String SQL_REMOVE = "delete from tbl_hotels where hotel_id=?";
	private static final String SQL_LOAD_HOTEL_BYID = "select * from tbl_hotels where hotel_id=?";
	private static final String SQL_UPDATE_HOTEL
	   = "update tbl_hotels set hotel_name=?,hotel_addr=?, hotel_phone=?,hotel_room_count=?,hotel_pic=? where hotel_id=?";
    private static final String SQL_LOAD_PIC_BYID
       = "select hotel_pic from tbl_hotels where hotel_id=?";
	
	/* (non-Javadoc)
	 * @see com.abc.hotelsys.dao.HotelDao#addHotel(com.abc.hotelsys.domain.Hotel)
	 */
	@Override
	public void addHotel(Hotel hotel) {
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_ADD_HOTEL);
			pstmt.setString(1, hotel.getHotelName());
			pstmt.setString(2, hotel.getHotelAddr());
			pstmt.setString(3, hotel.getHotelPhone());
			pstmt.setBytes(4, hotel.getHotelPic());
			pstmt.executeUpdate(); 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.releaseRes(conn, pstmt, null);
		}		

	}

	@Override
	public List<Hotel> loadHotels() {
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Hotel> hotelList = new ArrayList<>();
		
		try {
			
			pstmt = conn.prepareStatement(SQL_LOAD_ALL);
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				Hotel hotel = new Hotel();
				hotel.setHotelId(rset.getInt("hotel_id"));
				hotel.setHotelName(rset.getString("hotel_name"));
				hotel.setHotelPhone(rset.getString("hotel_phone"));
				hotel.setHotelAddr(rset.getString("hotel_addr"));
				hotel.setHotelRoomCount(rset.getInt("hotel_room_count"));
				hotelList.add(hotel);
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}			
		
		return hotelList;
	}

	@Override
	public void delHotel(int hotelId) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_REMOVE);
			pstmt.setInt(1, hotelId);
			pstmt.executeUpdate(); 
		}catch (SQLException e) {
			e.printStackTrace();
			if(e.getMessage().contains("parent row")){
				Hotel hotel = this.getHotelById(hotelId);
				String msg = String.format("%s hotel has %d rooms!!", hotel.getHotelName(),hotel.getHotelRoomCount());
				throw new HotelSysException(msg);
			}
		}finally{
			DBUtils.releaseRes(conn, pstmt, null);
		}	
		
		
	}

	@Override
	public Hotel getHotelById(int hotelId) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Hotel hotel = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_LOAD_HOTEL_BYID);
			pstmt.setInt(1, hotelId);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				hotel = new Hotel();
				hotel.setHotelId(rset.getInt("hotel_id"));
				hotel.setHotelName(rset.getString("hotel_name"));
				hotel.setHotelPhone(rset.getString("hotel_phone"));
				hotel.setHotelAddr(rset.getString("hotel_addr"));
				hotel.setHotelRoomCount(rset.getInt("hotel_room_count"));
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}			
		
		return hotel;
	}

	@Override
	public void updateHotel(Hotel hotel) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE_HOTEL);
			pstmt.setString(1, hotel.getHotelName());
			pstmt.setString(2, hotel.getHotelAddr());
			pstmt.setString(3, hotel.getHotelPhone());
			pstmt.setInt(4, hotel.getHotelRoomCount());
			pstmt.setBytes(5, hotel.getHotelPic());
			pstmt.setInt(6, hotel.getHotelId());
			pstmt.executeUpdate(); 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.releaseRes(conn, pstmt, null);
		}		
		
	}

	@Override
	public byte[] getHotelPicById(int hotelId) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		byte[] picData = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_LOAD_PIC_BYID);
			pstmt.setInt(1, hotelId);
			rset = pstmt.executeQuery(); 
			
			if(rset.next()){
				picData = rset.getBytes("hotel_pic");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}		
		
		return picData;	
		
		
	}

}
