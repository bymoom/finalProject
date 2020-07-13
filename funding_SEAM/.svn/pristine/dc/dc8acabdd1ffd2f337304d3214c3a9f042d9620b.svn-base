package com.funding.controller.admin;

import java.io.File;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.funding.dto.PopupVO;
import com.funding.request.PopupModifyRequest;
import com.funding.request.PopupRegistRequest;
import com.funding.request.SearchCriteria;
import com.funding.service.admin.PopupService;

@Controller
public class PopupController {
	
	@Autowired
	private PopupService popService;
	
	@RequestMapping("admin/popup/list")
	public ModelAndView popupList(SearchCriteria cri,ModelAndView model)throws Exception{
		String url="popup/list.admin_page";
		
		Map<String, Object> dataMap = popService.selectPopupList(cri);
		model.addAllObjects(dataMap);
		model.setViewName(url);
		return model;
	}
	
	@RequestMapping(value="admin/popup/regist",method=RequestMethod.GET)
	public String regist()throws Exception{
		String url="popup/regist.admin_open";
		
		return url;
	}
	
	@Resource(name="popupPath")
	private String popupPath;
	 
	@RequestMapping(value="admin/popup/regist",method=RequestMethod.POST)
	public String registPOST(PopupRegistRequest registReq)throws Exception{
		String url="popup/regist_success";
		String p_filename = UUID.randomUUID().toString().replace("-", "")+"^^"+registReq.getUploadFile().getOriginalFilename();
//		String p_filepath = "c:/popup/";
		
		File file = new File(popupPath,p_filename);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		
				
		PopupVO popup = registReq.toPopupVO();
		popup.setP_filename(p_filename);
		popup.setP_filetype(p_filename.substring(p_filename.lastIndexOf(".")+1));
		popup.setP_uploadpath(popupPath);
		try {
			popService.registPopup(popup);
			registReq.getUploadFile().transferTo(file);
		}catch(SQLException e) {
			e.printStackTrace();
			url="popup/regist_fail";
		}
		
		return url;
	}
	
	@RequestMapping("/admin/popup/delete")
	public String deletePopup(int p_num)throws Exception{
		String url="popup/delete_success";
		
		popService.deletePopup(p_num);
		
		return url;
	}
	
	@RequestMapping("/admin/popup/disabled")
	public String disabledPopup(int p_num)throws Exception{
		String url="popup/disabled_success";
		
		popService.popupDisabled(p_num);
		
		return url;
	}
	
	@RequestMapping("/admin/popup/enabled")
	public String enabledPopup(int p_num)throws Exception{
		String url="popup/enabled_success";
		
		popService.popupEnabled(p_num);
		
		return url;
	}
	
	@RequestMapping(value="/admin/popup/modify",method=RequestMethod.GET)
	public ModelAndView modifyPopupGET(int p_num,ModelAndView model)throws Exception{
		String url="popup/modify.admin_open";
		
		PopupVO popup = popService.selectPopupListByNum(p_num);
		
		model.setViewName(url);
		model.addObject("popup",popup);
		
		return model;
	}
	@RequestMapping(value="/admin/popup/modify",method=RequestMethod.POST)
	public String modifyPopup(int p_num,PopupModifyRequest modifyReq)throws Exception{
		String url="popup/modify_success";
		
		PopupVO pop = popService.selectPopupListByNum(p_num);
		String oldFileName = pop.getP_filename();
		String oldFileType = pop.getP_filetype();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+oldFileType);
		String oldPath = pop.getP_uploadpath();
		
		if(!modifyReq.getUploadFile().getOriginalFilename().equals("")) {
			
			File oldFile = new File(oldPath,oldFileName);
			
			if(oldFile.exists()) {
				oldFile.delete();
			}
			String p_filename = UUID.randomUUID().toString().replace("-", "")+"^^"+modifyReq.getUploadFile().getOriginalFilename();
			String p_uploadpath = popupPath;
			
			String p_filetype = p_filename.substring(p_filename.lastIndexOf(".")+1); 
					
			File file = new File(p_uploadpath,p_filename);
			
						
			modifyReq.getUploadFile().transferTo(file);
			
			PopupVO popup = modifyReq.toPopupVO();
			
			popup.setP_filename(p_filename);
			popup.setP_filetype(p_filetype);
			popup.setP_uploadpath(p_uploadpath);
			popup.setP_num(p_num);
			
			popService.modifyPopup(popup);
			
		}else {
			
			PopupVO popup = modifyReq.toPopupVO();
			
			popup.setP_filename(oldFileName);
			popup.setP_filetype(oldFileType);
			popup.setP_uploadpath(oldPath);
			popup.setP_num(p_num);
			
			popService.modifyPopup(popup);
		}
		return url;
	}
}
