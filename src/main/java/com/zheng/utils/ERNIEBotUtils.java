package com.zheng.utils;


//import okhttp3.MediaType.Companion.toMediaType
//import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import sun.rmi.runtime.Log;


//import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ERNIEBotUtils {
//    static final OkHttpClient client = new OkHttpClient().newBuilder().build();
    private static String API_Key = "j8a6isKhFP8ADBKFRA0WYoLQ";
    private static String Secret_Key = "wnPks6scewIebP8SGLVd3zY3Vtwv0Fkl";
    private static String get_access_token_url = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=" + API_Key + "&client_secret=" + Secret_Key;

    public static String getERNIEBotResault(String param_content) throws IOException {
        System.out.println("getERNIEBotResault");
        String access_token_String = HttpURLConnectionUtil.doGet(get_access_token_url);
        JSONObject parse = (JSONObject) JSON.parse(access_token_String);
        Object access_token = parse.get("access_token");
        JSONObject param = new JSONObject();
        JSONObject param_totle = new JSONObject();
        param.put("role", "user");
        param.put("content", param_content);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(param);
        param_totle.put("messages", jsonArray);

        MediaType mediaType = MediaType.parse("application/json");
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
        // 创建请求体
        RequestBody body = RequestBody.create(mediaType, String.valueOf(param_totle));
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions?access_token=" + access_token)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .post(body)
                .build();
        String response = client.newCall(request).execute().body().string();

        JSONObject response_json = (JSONObject) JSON.parse(response);
        String result = (String) response_json.get("result");
        return result;
    }


    public static void main(String[] args) throws IOException {
        String ernieBotResault = getERNIEBotResault("给一个英语句子长难句，考研或者6级难度，并对句子进行从句解析、语法分析与翻译");
        System.out.println(ernieBotResault);
    }
}
