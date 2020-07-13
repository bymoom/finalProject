package com.funding.controller.mypage.interest;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.funding.dto.Interest_pjtVO;
import com.funding.request.PjtSearchCriteria;
import com.funding.service.member.ComMemberService;
import com.funding.service.project.Interest_pjtService;
import com.funding.service.project.Pjt_bank_sum_attachService;
import com.funding.service.project.ProjectService;
import com.funding.service.project.Project_type_codeService;

@Controller
@RequestMapping("/mypage/interest")
public class MypageInterestPjtController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ComMemberService ComMemberService;
	
	@Autowired
	public Pjt_bank_sum_attachService pjt_bank_sum_attachService;
	
	@Autowired
	public Project_type_codeService project_type_codeService;
	
	@Autowired
	public Interest_pjtService interest_pjtService;
	
	@RequestMapping("/interestList")
	public ModelAndView projectProgressList(PjtSearchCriteria pjtCri, ModelAndView mav, int mem_num)throws Exception{
		String url="mypage/interest/interestPjtList.page";
		
		mav.addAllObjects(projectService.getInterestProjectList(pjtCri, mem_num));
		mav.setViewName(url);
		
		return mav;
	}
	
	@RequestMapping("/getlist")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> projectList(PjtSearchCriteria pjtCri, int mem_num)throws Exception{
		
		ResponseEntity<Map<String,Object>> entity =null;
		try {
			Map<String,Object> dataMap = projectService.getInterestProjectList(pjtCri, mem_num);
			
			entity = new ResponseEntity<Map<String,Object>>(dataMap,HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity=new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
	@RequestMapping("/interestCancle")
	@ResponseBody
	public ResponseEntity<String> interestPjtCancle(@RequestBody Interest_pjtVO interest_pjt)throws Exception{
		ResponseEntity<String> entity=null;
		
		try {
			interest_pjtService.interestPjtCancleByIntPjtNum(interest_pjt);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}

}
