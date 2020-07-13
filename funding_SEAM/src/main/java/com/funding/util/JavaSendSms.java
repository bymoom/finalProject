package com.funding.util;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;


public class JavaSendSms {
	
	public void sendsms(String to, String content) {
		
		//System.out.println("to : " + to + " content : " + content + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		String api_key = "NCSXRGQGN4XMISJR";
		String api_secret = "WYW5TATRHWMWNSXZCNPHF12IZ0FQTET3";
		Message coolsms = new Message(api_key, api_secret);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", to);
		params.put("from", "01090657177");
		params.put("type", "LMS");
		params.put("text", content);
		//params.put("app_version", "test app 1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
		
	}
	
}
