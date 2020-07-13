package com.funding.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.funding.dao.admin.AdminProjectManageDAO;
import com.funding.dao.admin.AdminProjectPayManageDAO;
import com.funding.dto.Pjt_pay_detailVO;
import com.funding.dto.PointVO;
import com.funding.request.AdminMemberDetailRequest;
import com.funding.request.AdminProjectPaySearchCriteria;
import com.funding.request.AdminProjectRequest;
import com.funding.service.admin.AdminProjectPayManageService;
import com.funding.service.member.PointService;

@Controller
@RequestMapping("admin/pay/*")
public class AdminProjectPayManageController {

	@Autowired
	private AdminProjectPayManageService adminProjectPayManageService;
	
	@Autowired
	private AdminProjectManageDAO adminProjectManageDAO;
	
	@Autowired
	private AdminProjectPayManageDAO adminProjectPayManageDAO;
	
	@Autowired
	private PointService pointService;
	
	@RequestMapping("list")
	public ModelAndView list(AdminProjectPaySearchCriteria cri, ModelAndView mnv) throws Exception {
		String url = "admin/pay/list.admin_page";
		
		try {
			Map<String, Object> dataMap = adminProjectPayManageService.getProjectPayList(cri);
			List<AdminProjectRequest> standByRepaymentList = adminProjectManageDAO.selectStandByToCalcList();
			dataMap.put("standByRepaymentList", standByRepaymentList);
			
			mnv.addAllObjects(dataMap);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping("detail")
	public ModelAndView detail(int pjt_pay_num, ModelAndView mnv) throws Exception {
		String url = "admin/pay/detail.admin_open";
		
		try {
			Map<String, Object> dataMap = adminProjectPayManageService.getProjectPayDetail(pjt_pay_num);
			List<AdminProjectRequest> standByRepaymentList = adminProjectManageDAO.selectStandByToCalcList();
			dataMap.put("standByRepaymentList", standByRepaymentList);
			
			mnv.addAllObjects(dataMap);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="refund", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> refund(@RequestBody Map<String, int[]> json) throws Exception {
		ResponseEntity<String> result = null;
		
		int[] checkedTrueArr = json.get("checkedTrueList");
		
		/*for(int i = 0; i < checkedTrueArr.length; i++) {
			System.out.println(i + "번쨰 checkedTrue : " + checkedTrueArr[i]);
		}*/
		
		try {
			for(int pjt_pay_num : checkedTrueArr) {
				adminProjectPayManageService.updateRefund(pjt_pay_num);
				
				//환불하면서 포인트 돌려주기
				Pjt_pay_detailVO pjtPayDetail = adminProjectPayManageDAO.selectPjtPayDetailByPjtPayNum(pjt_pay_num);
				PointVO point = new PointVO();
				point.setMem_num(pjtPayDetail.getMem_num());
				point.setPoint(pjtPayDetail.getPjt_pay_usepoint());
				
				pointService.savePoint(point);
			}
			
			result = new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
}
