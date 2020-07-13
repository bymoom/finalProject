package com.funding.controller.mypage;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.funding.request.MainSearchCriteria;
import com.funding.service.member.PointService;
import com.funding.service.project.ProjectService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	private PointService pointService;
	
	@Autowired
	private ProjectService projectService;

	
	@RequestMapping("/main")
	public String mypageMain(int mem_num,Model model)throws Exception{
		String url="mypage/mypageMain.mypage";
		int point = pointService.getPointByMemNum(mem_num);
		
		model.addAttribute("point",point);
		
		return url;
	}
	
	@RequestMapping("/getlist")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> projectList(MainSearchCriteria mainCri,int mem_num)throws Exception{
		
		ResponseEntity<Map<String,Object>> entity =null;
		try {
			Map<String,Object> dataMap = projectService.getPjtPayList(mainCri, mem_num);
			
			entity = new ResponseEntity<Map<String,Object>>(dataMap,HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
}
