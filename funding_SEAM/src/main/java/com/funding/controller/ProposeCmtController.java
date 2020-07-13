package com.funding.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.funding.dto.ProjectProposeCmtVO;
import com.funding.request.ProposeCmtModifyRequest;
import com.funding.service.ProposeCmtService;

@Controller
public class ProposeCmtController {
	
	@Autowired
	private ProposeCmtService proposeCmtService;
	public void setProposeCmtService(ProposeCmtService proposeCmtService) {
		this.proposeCmtService = proposeCmtService;
	}
	
	@RequestMapping(value="/replies/propose/list/{pjtprp_num}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> list(@PathVariable("pjtprp_num") int pjtprp_num) throws Exception {
		ResponseEntity<Map<String, Object>> result = null;
		Map<String, Object> dataMap = new HashMap<>();

		try {
			List<ProjectProposeCmtVO> CmtsList = proposeCmtService.selectReplyList(pjtprp_num);
			dataMap.put("proposeCmtsList", CmtsList);
			result = new ResponseEntity<>(dataMap, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	@RequestMapping(value="/replies/propose/regist", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> regist(@RequestBody ProjectProposeCmtVO proposeCmt) throws Exception {
		ResponseEntity<String> entity = null;
		System.out.println(proposeCmt.toString());
		try {
			proposeCmtService.regist(proposeCmt);
			entity = new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
	
	/*@RequestMapping(value="modify/{free_cmts_num}", method= {RequestMethod.PUT, RequestMethod.PATCH})
	@ResponseBody
	public ResponseEntity<String> modify(@PathVariable("free_cmts_num") int free_cmts_num, @RequestBody FreeBoardCmtsVO freeBoardCmts) throws Exception {
		ResponseEntity<String> entity = null;
		
		System.out.println(freeBoardCmts.toString());
		freeBoardCmts.setFree_cmts_num(free_cmts_num);
		
		try {
			freeBoardCmtsproposeCmtService.modify(freeBoardCmts);
			entity = new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping(value="remove/{free_cmts_num}", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> remove(@PathVariable("free_cmts_num") int free_cmts_num) throws Exception {
		ResponseEntity<String> entity = null;
		
		try {
			freeBoardCmtsproposeCmtService.remove(free_cmts_num);
			entity = new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}*/
	
	@RequestMapping("/propose/cmt/disabled")
	@ResponseBody
	public ResponseEntity<String> checkedDisabled(@RequestBody Map<String,List<Integer>> jsonn)throws Exception{
		ResponseEntity<String> entity = null;
		List<Integer> tnum = (List<Integer>) jsonn.get("trueChecked");
		List<Integer> fnum = (List<Integer>) jsonn.get("falseChecked");
		
		try {
			for(int i=0; i<tnum.size(); i++) {
				int pjtprp_cmts_num = tnum.get(i); 
				proposeCmtService.disabledProposeCmt(pjtprp_cmts_num);
			}
			for(int i=0; i<fnum.size(); i++) {
				int pjtprp_cmts_num = fnum.get(i); 
				proposeCmtService.enabledProposeCmt(pjtprp_cmts_num);
			}
			entity = new ResponseEntity<>(HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
	@RequestMapping("/propose/cmt/enabled")
	@ResponseBody
	public ResponseEntity<String> checkedEnabled(@RequestBody Map<String,List<Integer>> jsonn)throws Exception{
		ResponseEntity<String> entity = null;
		List<Integer> num = (List<Integer>) jsonn.get("falseChecked");
		
		try {
			for(int i=0; i<num.size(); i++) {
				int pjtprp_cmts_num = num.get(i); 
				proposeCmtService.enabledProposeCmt(pjtprp_cmts_num);
				entity = new ResponseEntity<>(HttpStatus.OK);
				System.out.println("성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공");
			}
		}catch(SQLException e) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
	@RequestMapping(value="/propose/cmt/modify/{pjtprp_cmts_num}",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<String> modifyCmt(@RequestBody Map<String, String> dataJson,@PathVariable("pjtprp_cmts_num") int pjtprp_cmts_num)throws Exception{
		ResponseEntity<String> entity = null;
		String pjtprp_cmts_contents = dataJson.get("pjtprp_cmts_contents");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@"+pjtprp_cmts_contents);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+pjtprp_cmts_num);
		
		ProposeCmtModifyRequest modifyReq = new ProposeCmtModifyRequest();
		
		modifyReq.setPjtprp_cmts_contents(pjtprp_cmts_contents);
		modifyReq.setPjtprp_cmts_num(pjtprp_cmts_num);
		try {
			ProjectProposeCmtVO cmtVO = modifyReq.toProposeCmtVO();
			proposeCmtService.modifyCmt(cmtVO);
			entity = new ResponseEntity<>(HttpStatus.OK);
			
		}catch(SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/propose/cmt/delete/{pjtprp_cmts_num}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteCmt(@PathVariable("pjtprp_cmts_num")int pjtprp_cmts_num)throws Exception{
		ResponseEntity<String> entity = null;
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + pjtprp_cmts_num);
			try {
				proposeCmtService.deleteCmt(pjtprp_cmts_num);
				entity = new ResponseEntity<>(HttpStatus.OK);				
			}catch(SQLException e) {
				e.printStackTrace();
				entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		return entity;
	}
	
	@RequestMapping("/propose/cmt/allEnabled")
	@ResponseBody
	public ResponseEntity<String> checkedAllEnabled(@RequestBody Map<String,List<Integer>> jsonn)throws Exception{
		ResponseEntity<String> entity = null;
		List<Integer> num = (List<Integer>) jsonn.get("trueChecked");
		
		try {
			for(int i=0; i<num.size(); i++) {
				int pjtprp_cmts_num = num.get(i); 
				proposeCmtService.enabledProposeCmt(pjtprp_cmts_num);
				entity = new ResponseEntity<>(HttpStatus.OK);
				System.out.println("성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공");
			}
		}catch(SQLException e) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
	@RequestMapping("/propose/cmt/allDisabled")
	@ResponseBody
	public ResponseEntity<String> checkedAllDisabled(@RequestBody Map<String,List<Integer>> jsonn)throws Exception{
		ResponseEntity<String> entity = null;
		List<Integer> num = (List<Integer>) jsonn.get("trueChecked");
		
		try {
			for(int i=0; i<num.size(); i++) {
				int pjtprp_cmts_num = num.get(i); 
				proposeCmtService.disabledProposeCmt(pjtprp_cmts_num);
				entity = new ResponseEntity<>(HttpStatus.OK);
				System.out.println("성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공");
			}
		}catch(SQLException e) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
}
