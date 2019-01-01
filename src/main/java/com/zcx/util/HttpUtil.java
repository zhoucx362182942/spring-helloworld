package com.zcx.util;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * zhou
 */
public class HttpUtil {
    /**
     * 发送post请求
     * @param url
     * @param map
     * @param encoding
     * @return
     * @throws IOException
     */
    public static String doPost(String url, Map<String,String> map, String encoding)
            throws IOException {
        String body = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if(map!=null){
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        if(nvps.size() > 0){
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvps,encoding);
            httpPost.setEntity(entity);
        }
        HttpResponse response = client.execute(httpPost);
        if(response != null){
            HttpEntity resEntity = response.getEntity();
            if(resEntity != null){
                body = EntityUtils.toString(resEntity,encoding);
            }
        }
        return body;
    }

    public static void main(String[] args) {
        String url = "http://localhost:8080/springheloworld/postTest";
        Map<String, String> param = new HashMap<String, String>();
        param.put("name", "zcx");
        param.put("age", "29");
        param.put("sex", "male");
        try {
            String result = doPost(url, param, "utf-8");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
