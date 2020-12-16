package com.abc.dao.util;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class DBUtilTest {

    @Test
    public void getConnection() throws Exception {

        Connection con1 = DBUtil.getConnection();
        System.out.println(DBUtil.getDs());
        System.out.println(con1);
        System.out.println("***********************************");

        Connection con2 = DBUtil.getConnection();
        System.out.println(DBUtil.getDs());
        System.out.println(con2);
    }
}