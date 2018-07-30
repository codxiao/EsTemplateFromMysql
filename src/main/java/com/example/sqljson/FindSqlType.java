package com.example.sqljson;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSqlType {
    String mysql=null;
    HashMap<String,String> types=new HashMap<>();

    public FindSqlType(String sql) {
        this.mysql = sql;
    }
    public HashMap<String, String> find(){
        String driver = "com.mysql.jdbc.Driver";

//这里我的数据库名字是Person，改成你自己的数据库名

        String url = "jdbc:mysql://localhost:3306/test1";
        String user = "root";
        String pwd = "pp123456`";
        List<String> columnTypes=null;
        Statement stet;
        Connection con;
        ResultSet rs;
        try {
            Class.forName(driver);
             con =   DriverManager.getConnection(url,user,pwd);
             stet = con.createStatement();

//我的数据库Person中的表student，改成你自己的表

            String sql = "select * from "+mysql;
            columnTypes=new ArrayList<>();
             rs = stet.executeQuery(sql);
            ResultSetMetaData metaData =  rs.getMetaData();
            int columnCount= metaData.getColumnCount();
            for(int i=1;i<=columnCount;i++){
                types.put(metaData.getColumnName(i),metaData.getColumnTypeName(i));
            }


        } catch (Exception e) {

            e.printStackTrace();
        }
// finally {
//            if (rs==null){
//                rs.close();
//            }
//            if(stet==null){
//                stet.close();
//            }
//            if (con==null){
//                con.close();
//            }
//        }
        return types;
    }
}
