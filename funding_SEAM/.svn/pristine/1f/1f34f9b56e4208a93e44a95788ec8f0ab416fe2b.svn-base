package com.funding.controller.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.funding.dto.ComMemberVO;
import com.funding.dto.ComMember_State_CodeVO;
import com.funding.dto.Mem_state_codeVO;
import com.funding.dto.MemberVO;
import com.funding.request.AdminComMemberDetailRequest;
import com.funding.request.AdminDetailForProjectPageMaker;
import com.funding.request.AdminDetailPageMaker;
import com.funding.request.AdminMemberDetailRequest;
import com.funding.request.AdminMemberSearchCriteria;
import com.funding.service.admin.AdminComMemberManageService;
import com.funding.service.admin.AdminMemberManageService;
import com.funding.service.member.PointService;

@Controller
@RequestMapping("admin/comMember/*")
public class AdminComMemberManageController {

	@Autowired
	private AdminMemberManageService adminMemberManageService;
	
	@Autowired
	private AdminComMemberManageService adminComMemberManageService;
	
	@Autowired
	private PointService pointService;
	
	@RequestMapping(value="list")
	public ModelAndView comMemberList(AdminMemberSearchCriteria cri, ModelAndView mnv) throws Exception{
		String url="admin/comMember/list.admin_page";
		  
		try {
			Map<String, Object> dataMap = adminComMemberManageService.getSearchComMemberList(cri);
			List<Mem_state_codeVO> memStateCodeList = adminMemberManageService.getMemStateCode();
			int roleComHoldTotalCount = adminComMemberManageService.getRoleComHoldTotalCount();
			
			dataMap.put("memStateCodeList", memStateCodeList);
			dataMap.put("roleComHoldTotalCount", roleComHoldTotalCount);
			
			List<AdminComMemberDetailRequest> comMemberListForDownload = adminComMemberManageService.selectSearchComMemberListForDownload(cri);
			dataMap.put("comMemberListForDownload", comMemberListForDownload);
			
			mnv.addAllObjects(dataMap);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView comMemberDetail(AdminDetailPageMaker projectPayPageMaker, AdminDetailForProjectPageMaker detailForProjectPageMaker, int mem_num, ModelAndView mnv) throws Exception{
		String url = "admin/comMember/detail.admin_open";
		
		Map<String, Object> dataMap = new HashMap<>();
		
		try {
			AdminComMemberDetailRequest comMember = adminComMemberManageService.getComMemberByMemNum(mem_num);
			int point = pointService.getPointByMemNum(mem_num);
			List<AdminMemberDetailRequest> comMemberProjectPayList = adminMemberManageService.getMemberDetailForProjectPay(projectPayPageMaker, mem_num);
			List<AdminComMemberDetailRequest> comMemberProjectList = adminComMemberManageService.getMemberDetailForProject(detailForProjectPageMaker, mem_num);
			List<ComMember_State_CodeVO> comStateCodeList = adminComMemberManageService.getComStateCode();
			List<Mem_state_codeVO> memStateCodeList = adminMemberManageService.getMemStateCode();
			
			dataMap.put("comMember", comMember);
			dataMap.put("point", point);
			dataMap.put("comMemberProjectPayList", comMemberProjectPayList);
			dataMap.put("comMemberProjectList", comMemberProjectList);
			dataMap.put("comStateCodeList", comStateCodeList);
			dataMap.put("memStateCodeList", memStateCodeList);

			//결제 내역 전용 페이지네이션
			int projectPayTotalCount = adminMemberManageService.selectMemberDetailForProjectPayTotalCount(mem_num);
			projectPayPageMaker.setTotalCount(projectPayTotalCount);
			dataMap.put("projectPayPageMaker", projectPayPageMaker);
			
			//등록한 프로젝트 리스트 전용 페이지네이션
			int projectTotalCount = adminComMemberManageService.selectMemberDetailForProjectTotalCount(mem_num);
			detailForProjectPageMaker.setDetail_pjt_totalCount(projectTotalCount);
			dataMap.put("detailForProjectPageMaker", detailForProjectPageMaker);
			
			mnv.addAllObjects(dataMap);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mnv.setViewName(url);
		
		return mnv;
		
	}
	
	/**
	 * 회원 상태 코드 수정
	 */
	@RequestMapping(value="modifyComStateCode", method=RequestMethod.POST)
	public ResponseEntity<String> modifyComStateCode(ComMemberVO comMember) throws SQLException {
		ResponseEntity<String> result = null;
		
		try {
			if(comMember.getCom_state_code() == 1) { //가입 승인한 경우
				//승인으로 세팅
				adminComMemberManageService.modifyComStateCode(comMember);
				
				//활동중, Role_Com으로 세팅
				MemberVO member = new MemberVO();
				member.setCode_state_num(1);
				member.setMem_num(comMember.getMem_num());
				
				adminComMemberManageService.modifyMemStateCodeForComMem(member);
			}else { //가입 보류한 경우
				adminComMemberManageService.modifyComStateCode(comMember);
			}
		
			result = new ResponseEntity<>(HttpStatus.OK);

		} catch(Exception e) {
			e.printStackTrace();
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	@Resource(name = "memberAtcPath")
	private String memberAtcPath;
	
	@RequestMapping("/receiveDoc")
	@ResponseBody
	public ResponseEntity<byte[]> receiveDoc(String fileName, String id) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		HttpHeaders headers = new HttpHeaders();
		
		try {
			in = new FileInputStream(memberAtcPath + File.separator + id + File.separator + fileName);
			
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment;filename=\"" + new String(fileName.getBytes("utf-8"), "ISO-8859-1") + "\"");
			
			entity = new ResponseEntity<>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		}catch(IOException e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}finally {
			if(in != null)
			in.close();
		}
		return entity;
	}
	
}
