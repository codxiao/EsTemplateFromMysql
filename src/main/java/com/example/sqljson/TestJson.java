package com.example.sqljson;

import java.util.HashMap;

public class TestJson {
    public static void main(String[] args) {
        FindSqlType findSqlType=new FindSqlType("test2");
        HashMap<String,String> types=new HashMap<>();
        types=findSqlType.find();
        //应该输出json文件
        System.out.println(CreatJson.creatJson(types));
    }


}
