package com.funding.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.funding.dto.PointManageVO;
import com.funding.service.admin.AdminPointManageService;

@Controller
@RequestMapping("/admin/point/*")
public class PointController {
	
	@Autowired
	private AdminPointManageService adminPointService;
	
	@RequestMapping("main")
	public String main(Model model)throws Exception{
		String url="pay&point/main.admin_page";
		
		PointManageVO attend = adminPointService.checkAttendPoint();
		PointManageVO join = adminPointService.checkJoinPoint();
		
		model.addAttribute("attend",attend);
		model.addAttribute("join",join);
		return url;
	}
}
