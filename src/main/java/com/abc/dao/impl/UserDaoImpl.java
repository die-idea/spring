package com.abc.dao.impl;

import com.abc.dao.entity.User;
import com.abc.dao.idao.IUserDao;
import com.abc.dao.util.DBUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
    @Override
    public int exist(String username) throws Exception{
        Connection con = DBUtil.getConnection();
        String sql = "select count(1) from user where username=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,username);
        ResultSet rs = ps.executeQuery();
        int flag = 0;
        if(rs.next()){
            flag = rs.getInt(1);
        }
        DBUtil.close(rs,ps,con);
        return flag;
    }

    @Override
    public User login(User user) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "select id,username,password,pri from user where username=? and password=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,user.getUsername());
        ps.setString(2,user.getPassword());
        ResultSet rs = ps.executeQuery();
        User result =  null;
        if(rs.next()){
            result = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
        }
        DBUtil.close(rs,ps,con);
        return result;
    }
}
