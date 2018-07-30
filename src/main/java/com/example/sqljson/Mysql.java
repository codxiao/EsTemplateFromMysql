package com.example.sqljson;


import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.ResultSetMetaData;
        import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
        import org.json.JSONObject;

public class Mysql {
    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";

//这里我的数据库名字是Person，改成你自己的数据库名

        String url = "jdbc:mysql://localhost:3306/test1";
        String user = "root";
        String pwd = "pp123456`";
        try {
            Class.forName(driver);
            Connection con =   DriverManager.getConnection(url,user,pwd);
            Statement stet = con.createStatement();

//我的数据库Person中的表student，改成你自己的表

            String sql = "select * from test2";
            List<String> columnTypes=new ArrayList<>();
            ResultSet rs = stet.executeQuery(sql);
            ResultSetMetaData metaData =  rs.getMetaData();
            int columnCount= metaData.getColumnCount();
            for(int i=0;i<columnCount;i++){
                columnTypes.add(metaData.getColumnTypeName(i+1));
            }


        } catch (Exception e) {

            e.printStackTrace();// TODO: handle exception
        }
    }
}