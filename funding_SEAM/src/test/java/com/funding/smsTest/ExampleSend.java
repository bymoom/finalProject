package com.funding.smsTest;

import java.util.HashMap;
import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

/**
 * @class ExampleSend
 * @brief This sample code demonstrate how to send sms through CoolSMS Rest API PHP
 */
public class ExampleSend {
  public static void main(String[] args) {
    String api_key = "NCSXRGQGN4XMISJR";
    String api_secret = "WYW5TATRHWMWNSXZCNPHF12IZ0FQTET3";
    Message coolsms = new Message(api_key, api_secret);

    HashMap<String, String> params = new HashMap<String, String>();
    params.put("to", "01090657177"); // 수신번호
    params.put("from", "01090657177"); // 발신번호
    params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
    params.put("text", "Test Message"); // 문자내용    

    try {
      JSONObject obj = (JSONObject) coolsms.send(params);
      System.out.println(obj.toString());
    } catch (CoolsmsException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCode());
    }
  }
}
