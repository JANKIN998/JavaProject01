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
	 * ���ݱ�Ż���������û���Ϣ
	 * @param userNo
	 * @return
	 */
	User getUserByNo(String userNo);

}
