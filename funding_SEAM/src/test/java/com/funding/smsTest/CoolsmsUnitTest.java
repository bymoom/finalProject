package com.funding.smsTest;
import static org.junit.Assert.*;

import java.io.Reader;
import java.util.HashMap;

import net.nurigo.java_sdk.api.GroupMessage;
import net.nurigo.java_sdk.api.Image;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.api.SenderID;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Test;

public class CoolsmsUnitTest {
  String api_key = "NCSXRGQGN4XMISJR";
  String api_secret = "WYW5TATRHWMWNSXZCNPHF12IZ0FQTET3";

  Message message = new Message(api_key, api_secret);
  GroupMessage groupMessage = new GroupMessage(api_key, api_secret);
  Image image = new Image(api_key, api_secret);
  SenderID senderID;
  JSONObject result;
  JSONArray result_array;
  HashMap<String, String> params = new HashMap<String, String>();

  @Test
  public void MessageTest() {
    try {
      // send					
      params.put("to", "01090657177");
      params.put("from", "01090657177");
      params.put("type", "SMS");
      params.put("text", "Coolsms Testing Message!");
      params.put("mode", "test");
      result = message.send(params);
      assertNotNull(result.get("group_id"));

      // balance
      result = message.balance();
      assertNotNull(result.get("cash"));

      // sent
      params.clear();
      try {
        result = message.sent(params);
        assertNotNull(result.get("data"));
      } catch (Exception e) {
        result = (JSONObject) JSONValue.parse(e.getMessage());
        assertEquals(result.get("code"), "NoSuchMessage");
      }

      // status
      result = message.getStatus(params);
      assertNotNull(result.get("data"));

      // cancel
      params.put("mid", "MIDTEST");
      result = message.cancel(params);
      assertTrue(!result.isEmpty());
    } catch (Exception e) {
      fail(e.toString());
    }
  }

}
