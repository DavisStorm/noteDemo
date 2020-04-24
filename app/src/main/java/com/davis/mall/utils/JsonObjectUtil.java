package com.davis.mall.utils;

import com.davis.mall.network.NetClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author 王阳
 * @time 2019/12/24  0:19
 * @desc
 */
public class JsonObjectUtil {

    public static JSONObject getJsonObject(String whereleft,String wheremiddle,String whereright,String model_name,String s_name){
        JSONObject jsonObject = new JSONObject();
        try {
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray2 = new JSONArray();
            jsonArray.put(whereleft);
            jsonArray.put(wheremiddle);
            jsonArray.put(whereright);
            jsonArray2.put(jsonArray);
            jsonObject.put("where",jsonArray2);
            jsonObject.put("s",s_name);
            jsonObject.put("app_key", NetClient.app_key);
            jsonObject.put("model_name",model_name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
    public static JSONObject getNormalJsonObject(String model_name,String s_name,String data){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("data",data);
            jsonObject.put("s",s_name);
            jsonObject.put("app_key", NetClient.app_key);
            jsonObject.put("model_name",model_name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
