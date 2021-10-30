/**
 * 
 */
package com.abc.hotelsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abc.hotelsys.domain.User;
import com.abc.hotelsys.exception.DataAccessException;
import com.abc.hotelsys.utils.DBUtils;

/**
 * @author joeyang ong
 *
 */
public class UserDaoJDBCImpl implements UserDao {
	
	private static final String SQL_LOAD_BYNO = "select * from tbl_users where user_no=?";

	/* (non-Javadoc)
	 * @see com.abc.hotelsys.dao.UserDao#getUserByNo(java.lang.String)
	 */
	@Override
	public User getUserByNo(String userNo) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		User user=null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_LOAD_BYNO);
			pstmt.setString(1, userNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				user = new User();
				user.setUserNo(rset.getString("user_no"));
				user.setUserName(rset.getString("user_name"));
				user.setUserPwd(rset.getString("user_pwd"));
			}
			else
			    throw new DataAccessException("编号为"+userNo+"的用户不存在，请检查!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}	
		
		return user;
	}

}
