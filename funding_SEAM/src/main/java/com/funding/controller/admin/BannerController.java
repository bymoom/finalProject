package com.funding.controller.admin;

import java.io.File;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.funding.dto.BannerVO;
import com.funding.request.BannerModifyRequest;
import com.funding.request.BannerRegistRequest;
import com.funding.request.SearchCriteria;
import com.funding.service.admin.BannerService;

@Controller
@RequestMapping("/admin/banner/*")
public class BannerController {

	@Autowired
	private BannerService bannerService;
	
	@Resource(name="bannerPath")
	private String bannerPath;
	
	@RequestMapping("list")
	public ModelAndView bannerList(SearchCriteria cri, ModelAndView model)throws Exception{
		String url="banner/list.admin_page";
		
		Map<String, Object> dataMap = bannerService.selectBannerList(cri);
		model.addAllObjects(dataMap);
		model.setViewName(url);
		return model;
	}
	
	@RequestMapping(value="regist",method=RequestMethod.GET)
	public String registGET()throws Exception{
		String url="banner/regist.admin_open";
		return url;
	}
	
	@RequestMapping(value="regist",method=RequestMethod.POST)
	public String registPOST(BannerRegistRequest registReq)throws Exception{
		
		String url="banner/regist_success";
		String b_filename = UUID.randomUUID().toString().replace("-", "")+"$$"+registReq.getB_uploadFile().getOriginalFilename();
//		String b_filepath = "c:/banner/";
		File file = null;
		if(registReq.getB_type().equals("파트너")) {
			file = new File(bannerPath+File.separator+"파트너",b_filename);
		}else if(registReq.getB_type().equals("메인")) {
			file = new File(bannerPath+File.separator+"메인",b_filename);
		}
//		File file = new File(bannerPath,b_filename);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
				
		BannerVO banner = registReq.toBannerVO();
		banner.setB_filename(b_filename);
		banner.setB_filetype(b_filename.substring(b_filename.lastIndexOf(".")+1));
		banner.setB_uploadpath(bannerPath);
		try {
			bannerService.registBanner(banner);
			registReq.getB_uploadFile().transferTo(file);
		}catch(SQLException e) {
			e.printStackTrace();
			url="banner/regist_fail";
		}
		
		return url;
	}
	
	@RequestMapping(value="modify",method=RequestMethod.GET)
	public ModelAndView modifyGET(ModelAndView model,int b_num)throws Exception{
		String url="banner/modify.admin_open";
		BannerVO banner= bannerService.selectBannerListByNum(b_num);
		
		model.addObject("banner",banner);
		model.setViewName(url);
		
		return model;
	}
	
	@RequestMapping(value="modify",method=RequestMethod.POST)
	public String modifyPOST(BannerModifyRequest modifyReq)throws Exception{
		String url="banner/modify_success";
		
		BannerVO bannerByNum = bannerService.selectBannerListByNum(modifyReq.getB_num());
		
		String oldPath=bannerByNum.getB_uploadpath();
		String oldFileName=bannerByNum.getB_filename();
		String oldFileType=bannerByNum.getB_filetype();
		BannerVO banner = modifyReq.toBannerVO();
		if(!modifyReq.getB_uploadFile().getOriginalFilename().equals("")) {
			String fileName=UUID.randomUUID().toString().replace("-", "")+"$$"+modifyReq.getB_uploadFile().getOriginalFilename();
			String b_filetype=fileName.substring(fileName.lastIndexOf(".")+1);
			
			
			File oldFile = new File(oldPath,oldFileName);
			
			if(oldFile.exists()) {
				oldFile.delete();
			}
			try {
				if(modifyReq.getB_type().equals("메인")) {
					File file=new File(bannerPath+File.separator+"메인",fileName);
					
					modifyReq.getB_uploadFile().transferTo(file);
					
					banner.setB_filename(fileName);
					banner.setB_filetype(b_filetype);
					banner.setB_uploadpath(bannerPath+File.separator+"메인");
					
				}else if(modifyReq.getB_type().equals("파트너")) {
					File file=new File(bannerPath+File.separator+"파트너",fileName);
					
					modifyReq.getB_uploadFile().transferTo(file);
					
					banner.setB_filename(fileName);
					banner.setB_filetype(b_filetype);
					banner.setB_uploadpath(bannerPath+File.separator+"파트너");
				}
				
				bannerService.modifyBanner(banner);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			banner.setB_filename(oldFileName);
			banner.setB_filetype(oldFileType);
			banner.setB_uploadpath(oldPath);
			bannerService.modifyBanner(banner);
		}
		
		
		return url;
	}
	
	@RequestMapping("delete")
	public String deleteBanner(int b_num)throws Exception{
		String url="banner/delete_success";
		try {
			bannerService.deleteBanner(b_num);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	@RequestMapping("disabled")
	public String disabledBanner(int b_num)throws Exception{
		String url="banner/disabled_success";
		
		bannerService.bannerDisabled(b_num);
		
		return url;
	}
	
	@RequestMapping("enabled")
	public String enabledBanner(int b_num)throws Exception{
		String url="banner/enabled_success";
		
		bannerService.bannerEnabled(b_num);
		
		return url;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
