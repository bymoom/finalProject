package com.funding.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.funding.dto.EmailVO;
import com.funding.util.JavaSendSms;

@Controller
public class SendController {

	@Autowired
	public EmailSender mailSender;
	
	@Autowired
	public EmailVO email;
	
	/**
	 * 문자 발송
	 */
	@RequestMapping(value="sendSMSForm", method=RequestMethod.GET)
	public ModelAndView sendSMSForm(ModelAndView mnv, String mem_name, String mem_phone, String content) throws SQLException {
		String url = "admin/sendSMS.admin_open";		
		
		mnv.addObject("mem_name", mem_name);
		mnv.addObject("mem_phone", mem_phone);
		mnv.addObject("content", content);

		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="sendSMS", method=RequestMethod.POST)
	public ResponseEntity<String> sendSMS(String mem_phone, String content) throws SQLException {
		ResponseEntity<String> result = null;
		
		try {
			JavaSendSms javaSendSms = new JavaSendSms();
			javaSendSms.sendsms(mem_phone, content);
			
			result = new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			result = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	@RequestMapping(value="sendEmailForm", method=RequestMethod.GET)
	public ModelAndView sendEmailForm(ModelAndView mnv, String mem_name, String mem_email, String content) throws SQLException {
		String url = "admin/sendEmail.admin_open";		
		
		mnv.addObject("mem_name", mem_name);
		mnv.addObject("mem_email", mem_email);
		mnv.addObject("content", content);

		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="sendEmail", method=RequestMethod.POST)
	public ResponseEntity<String> sendEmail(String mem_email, String title, String content) throws SQLException {
		ResponseEntity<String> result = null;
		
		//System.out.println("content : " + content + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		email.setReceiver(mem_email);	//수신자 메일주소
		email.setContent("<img src=\"http://localhost/resources/images/funseamding2.png\" style='width:250px;'><br/>" + content);
		email.setSubject(title);
		
		try {
			mailSender.SendEmail(email);
			result = new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
}
