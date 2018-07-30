package com.example.sqljson;

import java.io.*;

public class updateConf {
    public static void replaceTxtByLineNo(String path,int lineNo,String newStr) {
        String temp = "";
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            // 保存该行前面的内容
            for (int j = 1; (temp = br.readLine()) != null; j++) {
                if(j==lineNo){
                    buf = buf.append(newStr);
                }else{
                    buf = buf.append(temp);
                }
                buf = buf.append(System.getProperty("line.separator"));
            }

            br.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String creatString(String sqlPath,String templateName){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("  jdbc {");
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("  jdbc_connection_string => \"jdbc:mysql://127.0.0.1:3306/test1\"");
        stringBuilder.append(System.getProperty("line.separator"));


        stringBuilder.append("  jdbc_password => \"pp123456`\"");
        stringBuilder.append(System.getProperty("line.separator"));

        stringBuilder.append("  jdbc_driver_library => \"D:\\logstash-6.2.4\\test\\mysql-connector-java-5.1.7-bin.jar\"");
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("  jdbc_driver_class => \"com.mysql.jdbc.Driver\"");
        stringBuilder.append(System.getProperty("line.separator"));

        stringBuilder.append("  jdbc_default_timezone => \"UTC\"");
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("  jdbc_paging_enabled => \"true\"");
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("  jdbc_page_size => \"50000\"");
        stringBuilder.append(System.getProperty("line.separator"));
        /*
        此行为变量
         */
        stringBuilder.append("  statement_filepath => ");
        stringBuilder.append("\""+sqlPath+"\"");

        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("  schedule => \"* * * * *\"");
        stringBuilder.append(System.getProperty("line.separator"));
        /*
        此行为变量
         */
        stringBuilder.append("  type => ");
        stringBuilder.append("\""+templateName+"\"");
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append("  }");
        stringBuilder.append(System.getProperty("line.separator"));
        return stringBuilder.toString();

    }
    public static void insert() {

        String insertString=creatString("","");//templateName最好使用数据库名

        replaceTxtByLineNo("D:\\multemp.conf",2,insertString);
    }

    public static void main(String[] args) {
        insert();
    }
}
