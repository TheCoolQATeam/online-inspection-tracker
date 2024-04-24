package com.onlines.utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class JDBCUtil {
    public static QueryRunner queryRunner;
    private  static Connection con;
    static{
        queryRunner = new QueryRunner();
    }
    // 创建用于连接数据库的Connection对象

    public void getConnection() {
        String jdbc_url = "jdbc:mysql://localhost:3306/online_inspection_tracker";//数据库连接;
        String username = "root";//数据库账号
        String password = "123456";//数据库密码

        try {
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动
            con = DriverManager.getConnection(jdbc_url + "?user=" + username + "&password=" + password + "&useUnicode=true&characterEncoding=utf-8");// 创建数据连接
        } catch (Exception e) {
            System.out.println("数据库连接失败" + e.getMessage());
        }
    }

    public List<Map<String, Object>> queryForMapList(String sql, Object... params) {
        List<Map<String, Object>> result = null;
        try {
            result = queryRunner.query(con, sql, new MapListHandler(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(String sql, Object... params) {
        int result = 0;
        try {
            result = queryRunner.update(con, sql,  params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
