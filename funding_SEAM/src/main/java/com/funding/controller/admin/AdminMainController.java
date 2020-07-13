package com.funding.controller.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.funding.dao.admin.AdminProjectManageDAO;
import com.funding.service.admin.AdminComMemberManageService;
import com.funding.service.admin.AdminMainService;

@Controller
@RequestMapping("admin/*")
public class AdminMainController {
	
	@Autowired
	private AdminMainService adminMainService;
	
	@Autowired
	private AdminProjectManageDAO adminProjectManageDAO;
	
	@Autowired
	private AdminComMemberManageService adminComMemberManageService;
	
	@RequestMapping(value="main", method=RequestMethod.GET)
	public ModelAndView main(ModelAndView mnv) throws Exception{
		String url="admin/main.admin_page";
		
		Map<String, Object> dataMap = adminMainService.getMainData();

		//가입 승인 대기자(소상공인) 수
		int roleComHoldTotalCount = adminComMemberManageService.getRoleComHoldTotalCount();
		dataMap.put("roleComHoldTotalCount", roleComHoldTotalCount);
		
		//프로젝트 등록 승인 대기 수
		int stateStandByTotalCount = adminProjectManageDAO.selectStateToStandByTotalCount();
		dataMap.put("stateStandByTotalCount", stateStandByTotalCount);
		
		//프로젝트 정산 대기 수
		int calcStandByTotalCount = adminProjectManageDAO.selectCalcToStandByTotalCount();
		dataMap.put("calcStandByTotalCount", calcStandByTotalCount);
		
		mnv.addAllObjects(dataMap);
		mnv.setViewName(url);
		
		return mnv;
	}
	
}
