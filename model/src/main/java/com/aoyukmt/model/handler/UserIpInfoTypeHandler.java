package com.aoyukmt.model.handler;

/**
 * @ClassName：UserIpInfoTypeHandler
 * @Author: aoyu
 * @Date: 2025-04-19 14:24
 * @Description: 处理json类型的用户ip信息转换为实体
 */

import com.aoyukmt.model.entity.UserIpInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(UserIpInfo.class)
public class UserIpInfoTypeHandler extends BaseTypeHandler<UserIpInfo> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, UserIpInfo parameter, JdbcType jdbcType) throws SQLException {
        try {
            // 将 UserIpInfo 序列化为 JSON 字符串
            String json = objectMapper.writeValueAsString(parameter);
            ps.setString(i, json);
        } catch (Exception e) {
            throw new SQLException("Error serializing UserIpInfo to JSON", e);
        }
    }

    @Override
    public UserIpInfo getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String json = rs.getString(columnName);
        return jsonToUserIpInfo(json);
    }

    @Override
    public UserIpInfo getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String json = rs.getString(columnIndex);
        return jsonToUserIpInfo(json);
    }

    @Override
    public UserIpInfo getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String json = cs.getString(columnIndex);
        return jsonToUserIpInfo(json);
    }

    private UserIpInfo jsonToUserIpInfo(String json) throws SQLException {
        if (json == null || json.isEmpty()) {
            return null;
        }
        try {
            // 将 JSON 字符串反序列化为 UserIpInfo
            return objectMapper.readValue(json, UserIpInfo.class);
        } catch (Exception e) {
            throw new SQLException("Error deserializing JSON to UserIpInfo", e);
        }
    }
}
