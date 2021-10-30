/**
 * 
 */
package com.abc.hotelsys.dao;

import com.abc.hotelsys.domain.User;

/**
 * @author joeyang ong
 *
 */
public interface UserDao {
	
	/**
	 * 根据编号获得完整的用户信息
	 * @param userNo
	 * @return
	 */
	User getUserByNo(String userNo);

}
