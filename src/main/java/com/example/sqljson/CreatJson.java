package com.example.sqljson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public  class CreatJson {
//    List columTypes;
//
//    public CreatJson(List columTypes) {
//        this.columTypes = columTypes;
//    }

    public static JSONObject creatJson(HashMap<String,String> columTypes){


        JSONObject template = new JSONObject();
        template.put("template", "testJson");
        JSONObject settings = new JSONObject();
        JSONObject mappings = new JSONObject();
        JSONObject doc = new JSONObject();
        JSONObject properties = new JSONObject();
        JSONObject analysis = new JSONObject();

        JSONObject analyzer = new JSONObject();
        JSONObject tokenizer = new JSONObject();
        JSONObject my_tokenizer = new JSONObject();

        JSONObject my_analyzer = new JSONObject();

        analysis.put("analyzer",analyzer);
        analysis.put("tokenizer",tokenizer);

        analyzer.put("my_analyzer",my_analyzer);
        my_analyzer.put("tokenizer","my_tokenizer");

        tokenizer.put("my_tokenizer",my_tokenizer);

        my_tokenizer.put("type", "ngram");
        my_tokenizer.put("min_gram", "1");
        my_tokenizer.put("max_gram", "2");

        JSONObject result = new JSONObject();
        result.put("template","testJson");
        result.put("settings",settings);
        result.put("mappings",mappings);

        settings.put("analysis",analysis);
        mappings.put("doc",doc);
        doc.put("properties",properties);
        for (String key : columTypes.keySet()){
            JSONObject typeBody = new JSONObject();
            System.out.println(key+"为key，值为"+columTypes.get(key));
            switch (columTypes.get(key)){
                case "VARCHAR":
                    typeBody.put("type","text");
                    typeBody.put("analyzer","my_analyzer");
                    break;
                default:
                    typeBody.put("type","text");
            }
            properties.put(key,typeBody);

        }




        //result是一个json对象
        return result;

    }
}
