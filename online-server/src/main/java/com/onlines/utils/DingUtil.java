package com.onlines.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import org.testng.ITestResult;

public class DingUtil {
    public static String access_token = "access_token=1d00ec8c27240627e606679912de12e01ada7024f5523d3da4460bd4afcb6ab5";

//
    public static String setMsgContent(ITestResult result){
        String caseDescription = result.getMethod().getDescription();
        Object[] caseParameters = result.getParameters();
        String msgContent = "";
        msgContent = msgContent + "提醒：线上巡检有报警！";
        if (!caseDescription.isEmpty()){
            msgContent = msgContent + "\n" +  "测试描述：" + caseDescription;
        }
        msgContent = msgContent + "\n" + "测试类和方法：" + result.getMethod().toString();
        if (caseParameters.length != 0){
            msgContent = msgContent + "\n" + "测试用例：";
            for (int i = 0; i < result.getParameters().length; i++){
                msgContent = msgContent + result.getParameters()[i].toString() + "；";
            }
        }
        msgContent = msgContent + "\n" + "详细请查看https://www.baidu.com/";
        return msgContent;
    }

    public static String sendDingMsg(ITestResult result){

        String msgContent = setMsgContent(result);
        String url = "https://oapi.dingtalk.com/robot/send?" + access_token;
        String body = "{\n" +
                "    \"at\": {" +
                "\"atMobiles\":[\"15321556636\"]" + "},\n" +
//                "\"atMobiles\":[\"" + atMobiles + "\"]" + "},\n" +
                "    \"msgtype\": \"text\", \n" +
                "    \"text\": {\n" +
                "        \"content\": \"" + msgContent + "\"" +
                "}\n" +
                "\n" +
                "}";
        HttpResponse DingResponse = HttpRequest.post(url).header("Content-Type", "application/json").body(body).execute();
        System.out.println(DingResponse.body());
        return DingResponse.body();
    }

    public static String setMsgContentPic(String testUrl, int id,String datum, String title){
        String msgContent = "";
        msgContent = msgContent + "提醒：线上巡检有报警！";
        msgContent = msgContent + "测试描述" + "\n" + title;
        msgContent = msgContent + "\n" + "图片像素对比异常url地址：" + "\n" + testUrl;
        msgContent = msgContent + "\n" + "图片异常地址" + "\n" + datum;
        msgContent = msgContent + "\n" + "详细请查看https://www.baidu.com/";
        return msgContent;
    }

    public static String sendDingMsgPic(String testUrl, int id, String datum, String title){

        String msgContent = setMsgContentPic(testUrl,id,datum,title);
        String url = "https://oapi.dingtalk.com/robot/send?" + access_token;
        String body = "{\n" +
                "    \"at\": {" +
                "\"atMobiles\":[\"15321556636\"]" + "},\n" +
//                "\"atMobiles\":[\"" + atMobiles + "\"]" + "},\n" +
                "    \"msgtype\": \"text\", \n" +
                "    \"text\": {\n" +
                "        \"content\": \"" + msgContent + "\"" +
                "}\n" +
                "\n" +
                "}";
        HttpResponse DingResponse = HttpRequest.post(url).header("Content-Type", "application/json").body(body).execute();
        System.out.println(DingResponse.body());
        return DingResponse.body();
    }

}
