/**
 * 
 */
package com.abc.hotelsys.service;

import com.abc.hotelsys.dao.UserDao;
import com.abc.hotelsys.dao.UserDaoJDBCImpl;
import com.abc.hotelsys.dao.UserDaoMyBatisImpl;
import com.abc.hotelsys.domain.User;
import com.abc.hotelsys.exception.HotelSysException;

/**
 * @author joeyang-ong
 *
 */
public class UserServiceImpl implements UserService {
	

	/* (non-Javadoc)
	 * @see com.abc.hotelsys.service.UserService#checkUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User checkUser(String userNo, String userPwd) {
		
		UserDao userDao = new UserDaoMyBatisImpl();
		
		User user = userDao.getUserByNo(userNo);
		
		if(!user.getUserPwd().equals(userPwd))
			throw new HotelSysException("用户找到，但密码不正确，请检查!");
		
		
		return user;
	}

}
