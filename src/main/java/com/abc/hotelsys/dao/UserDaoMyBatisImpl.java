package com.abc.hotelsys.dao;

import com.abc.hotelsys.domain.User;
import com.abc.hotelsys.exception.DataAccessException;
import com.abc.hotelsys.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserDaoMyBatisImpl implements UserDao{

    @Override
    public User getUserByNo(String userNo) {

        SqlSession session = MyBatisUtils.getSession();
        User user  = session.selectOne("com.abc.domain.User.getUserByNo",userNo);

        try {
            if (user == null)
                throw new DataAccessException("编号为" + userNo + "的用户不存在，请检查!");
        }finally{
            MyBatisUtils.closeSession(session);
        }

        return user;

    }


}
