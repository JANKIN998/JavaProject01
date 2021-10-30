package com.abc.hotelsys.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtils {

    //SQLSessionFactory的构建成本非常高，所以在整个程序中，我们只构建一个，是单例模式。
    private static SqlSessionFactory factory = null;

    static{
        Reader reader;

        try {
            reader = Resources.getResourceAsReader("db/mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("mybatis sqlsessionfactory is created ok!");
    }

    /**
     * 提供一个mybatis session
     * @return
     */
    public static SqlSession getSession(){
        return factory.openSession();
    }

    /**
     * 释放一个mybatis session
     * @param session
     */
    public static void closeSession(SqlSession session){
        session.close();
    }

}
