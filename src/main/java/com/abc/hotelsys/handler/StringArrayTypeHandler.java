package com.abc.hotelsys.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringArrayTypeHandler extends BaseTypeHandler<String[]> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {

        StringBuilder sb = new StringBuilder();

        for(String str:parameter)
            sb.append(str).append("|");

        if(sb.length()>0) sb.deleteCharAt(sb.length()-1);

        ps.setString(i, sb.toString());

        System.out.println("setok!");

    }

    @Override
    public String[] getNullableResult(ResultSet rs, String columnName) throws SQLException {

        System.out.println("getok!");
        String data = rs.getString(columnName);
        return data.split("\\|");

    }

    @Override
    public String[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String data = rs.getString(columnIndex);
        return data.split("\\|");
    }

    @Override
    public String[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String data = cs.getString(columnIndex);
        return data.split("\\|");
    }

}
