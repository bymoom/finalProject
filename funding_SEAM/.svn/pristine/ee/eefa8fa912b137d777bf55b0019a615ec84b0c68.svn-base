package com.funding.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.funding.request.MainSearchCriteria;
import com.funding.request.PjtSearchCriteria;
import com.funding.service.project.ProjectService;

@Controller
public class MainController {
	
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value="/commons/popUp",method=RequestMethod.GET)
	public String popUp() throws Exception{
		String url="popup/popup.open";
		
		return url;
	}
	
	@RequestMapping("/getlist")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> projectList(MainSearchCriteria mainCri)throws Exception{
		
		ResponseEntity<Map<String,Object>> entity =null;
		try {
			Map<String,Object> dataMap = projectService.getMainProjectList(mainCri);
			
			entity = new ResponseEntity<Map<String,Object>>(dataMap,HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
}
