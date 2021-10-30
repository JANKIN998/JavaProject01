/**
 * 
 */
package com.abc.hotelsys.service;

import com.abc.hotelsys.domain.User;

/**
 * @author joeyang-ong
 *
 */
public interface UserService {
	
	User checkUser(String userNo, String userPwd);

}
