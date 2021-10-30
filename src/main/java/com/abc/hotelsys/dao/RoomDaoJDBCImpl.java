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

import com.abc.hotelsys.domain.Room;
import com.abc.hotelsys.service.RoomQueryHelper;
import com.abc.hotelsys.utils.DBUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author joeyang-ong
 *
 */
public class RoomDaoJDBCImpl implements RoomDao {
	
	private static final String SQL_ADD_ROOM 
      = "insert into tbl_rooms(room_no,room_type,room_equip,room_status,room_memo,hotel_id) values(?,?,?,?,?,?)";
	private static final String SQL_LOAD_ROOMS
	  = "select * from tbl_rooms order by room_id desc";
	private static final String SQL_DEL_ROOM 
	  = "delete from tbl_rooms where room_id=?";
	private static final String SQL_GET_ROOM_BYID
	  = "select * from tbl_rooms where room_id=?";
	private static final String SQL_UPDATE_ROOM
	  = "update tbl_rooms set room_no=?,room_type=?,room_equip=?,room_status=?,room_memo=?,hotel_id=? where room_id=?";

	/* (non-Javadoc)
	 * @see com.abc.hotelsys.dao.RoomDao#addRoom(com.abc.hotelsys.domain.Room)
	 */
	@Override
	public void addRoom(Room room) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_ADD_ROOM);
			pstmt.setString(1, room.getRoomNo());
			pstmt.setString(2, room.getRoomType());
			
			//["a","b","d"]  -> "a|b|d"
			StringBuilder  sb = new StringBuilder();
			for(String equip:room.getRoomEquip())
				sb.append(equip).append("|");
		    if(sb.length()>0)
		    	sb.deleteCharAt(sb.length()-1);
		    pstmt.setString(3, sb.toString());
		    
		    pstmt.setString(4, room.getRoomStatus());
		    pstmt.setString(5, room.getRoomMemo());
		    pstmt.setInt(6, room.getHotel().getHotelId());
		    
		    pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, null);
		}
		

	}

	@Override
	public List<Room> loadRooms() {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Room> roomList = new ArrayList<>();
		
		try {
			
			pstmt = conn.prepareStatement(SQL_LOAD_ROOMS);
			rset = pstmt.executeQuery();
			
			HotelDao hotelDao = new HotelDaoJDBCImpl();
			
			while(rset.next()){
				
				Room room = new Room();
				room.setRoomId(rset.getInt("room_id"));
				room.setRoomNo(rset.getString("room_no"));
				room.setRoomStatus(rset.getString("room_status"));
				room.setRoomType(rset.getString("room_type"));
				room.setRoomMemo(rset.getString("room_memo"));
				room.setRoomEquip(rset.getString("room_equip").split("\\|"));
				room.setHotel(hotelDao.getHotelById(rset.getInt("hotel_id")));
				
				roomList.add(room);
				
			}
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}
		
		return roomList;
	}

	@Override
	public void delRoom(int roomId) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_DEL_ROOM);
			pstmt.setInt(1, roomId);
		    pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, null);
		}		
		
	}

	@Override
	public Room getRoomById(int roomId) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Room room = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_GET_ROOM_BYID);
			pstmt.setInt(1, roomId);
			rset = pstmt.executeQuery();
			
			HotelDao hotelDao = new HotelDaoJDBCImpl();
			
			if(rset.next()){
				
				room = new Room();
				room.setRoomId(rset.getInt("room_id"));
				room.setRoomNo(rset.getString("room_no"));
				room.setRoomStatus(rset.getString("room_status"));
				room.setRoomType(rset.getString("room_type"));
				room.setRoomMemo(rset.getString("room_memo"));
				room.setRoomEquip(rset.getString("room_equip").split("\\|"));
				room.setHotel(hotelDao.getHotelById(rset.getInt("hotel_id")));
				
			}
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}
		
		return room;
	}

	@Override
	public void updateRoom(Room room) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_UPDATE_ROOM);
			pstmt.setString(1, room.getRoomNo());
			pstmt.setString(2, room.getRoomType());
			
			//["a","b","d"]  -> "a|b|d"
			StringBuilder  sb = new StringBuilder();
			for(String equip:room.getRoomEquip())
				sb.append(equip).append("|");
		    if(sb.length()>0)
		    	sb.deleteCharAt(sb.length()-1);
		    pstmt.setString(3, sb.toString());
		    
		    pstmt.setString(4, room.getRoomStatus());
		    pstmt.setString(5, room.getRoomMemo());
		    pstmt.setInt(6, room.getHotel().getHotelId());
		    pstmt.setInt(7, room.getRoomId());
		    
		    pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, null);
		}				
		
	}

	@Override
	public List<Room> loadRooms(RoomQueryHelper helper) {
		
		String sql = this.genSQLByHelper(helper);
		System.out.println("loadrooms:"+sql);
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Room> roomList = new ArrayList<>();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			HotelDao hotelDao = new HotelDaoJDBCImpl();
			
			while(rset.next()){
				
				Room room = new Room();
				room.setRoomId(rset.getInt("room_id"));
				room.setRoomNo(rset.getString("room_no"));
				room.setRoomStatus(rset.getString("room_status"));
				room.setRoomType(rset.getString("room_type"));
				room.setRoomMemo(rset.getString("room_memo"));
				room.setRoomEquip(rset.getString("room_equip").split("\\|"));
				room.setHotel(hotelDao.getHotelById(rset.getInt("hotel_id")));
				
				roomList.add(room);
				
			}
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}
		
		return roomList;		
		
	}
	
	/**
	 * 根据查询条件来自动生成对应的SQL语句
	 * @param helper
	 * @return
	 */
	private String genSQLByHelper(RoomQueryHelper helper){
		
		String sql = "select * from tbl_rooms where 1=1"; 
		
		if(helper.getQryHotelNo()!=null)
			 sql += " and hotel_id="+helper.getQryHotelNo();
		
		if(StringUtils.isNotEmpty(helper.getQryRoomStatus()))
			 sql += " and room_status='"+helper.getQryRoomStatus()+"'";
		
		if(StringUtils.isNotEmpty(helper.getQryRoomType()))
			 sql += " and room_type='"+helper.getQryRoomType()+"'";
		
		sql += " order by room_id desc";
		
		return sql;
		
	}

	@Override
	public long cntRoomsByCondition(RoomQueryHelper helper) {
		//select count(*) as totalrec from tbl_rooms where .... order by ...
		String sql = this.genSQLByHelper(helper);
		sql = sql.replace("*", " count(*) as totalrec ");
		sql = sql.substring(0,sql.indexOf("order"));
		
		System.out.println("count sql:"+sql);
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int roomCnt = 0;		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				roomCnt = rset.getInt("totalrec");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}			
		
		return roomCnt;	
	}

	@Override
	public List<Room> loadScopedRooms(RoomQueryHelper helper, int startIdx, int fetchSize) {
		
		String sql = this.genSQLByHelper(helper);
		sql +=" limit ?,?";
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Room> roomList = new ArrayList<>();
		HotelDao hotelDao = new HotelDaoJDBCImpl();
		
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startIdx);
			pstmt.setInt(2, fetchSize);
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				
				Room room = new Room();
				
				room.setRoomId(rset.getInt("room_id"));
				room.setRoomNo(rset.getString("room_no"));
				room.setRoomEquip(rset.getString("room_equip").split("\\|"));
				room.setRoomStatus(rset.getString("room_status"));
				room.setRoomMemo(rset.getString("room_memo"));
				room.setRoomType(rset.getString("room_type"));
			
				room.setHotel(hotelDao.getHotelById(rset.getInt("hotel_id")));
				
				roomList.add(room);
							
			}		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}	
		
		return roomList;			

	}	

}
