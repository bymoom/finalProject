package com.funding.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.funding.dto.MemberVO;
import com.funding.dto.NoticeVO;
import com.funding.dto.Notice_atcVO;
import com.funding.util.MediaUtils;
import com.funding.util.UploadFileUtils;

@Controller
public class AttachController {
	
	private static final Logger logger=
			LoggerFactory.getLogger(AttachController.class);
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Autowired
	private com.funding.service.NoticeService noticeService;
	
	
	@RequestMapping(value="upload",method=RequestMethod.POST,
			        produces="text/plain;charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> upload(MultipartFile file,HttpSession session)throws Exception{
		
		logger.info("originalName : "+file.getOriginalFilename());
		logger.info("size : "+file.getSize());
		logger.info("contentType : "+file.getContentType());
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		int loginUser_writer = loginUser.getMem_num();
		
		return new ResponseEntity<String>(UploadFileUtils.uploadFile(uploadPath, 
										  file.getOriginalFilename(), 
										  loginUser_writer,
				                          file.getBytes()),
					    			      HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="displayFile",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<byte[]> displayFile(String ntc_atc_fileName)throws Exception{
		InputStream in=null;
		ResponseEntity<byte[]> entity=null;
		logger.info("File name : "+ntc_atc_fileName);
		System.out.println("fileName! : " + ntc_atc_fileName ) ;
		
		try{
			
		String fileFormat=ntc_atc_fileName.substring(ntc_atc_fileName.lastIndexOf(".")+1);
		System.out.println("%%%%%%%%%%%%%%%%%"+fileFormat);
		MediaType media=MediaUtils.getMediaType(fileFormat);
		HttpHeaders headers=new HttpHeaders();
		
		ntc_atc_fileName=ntc_atc_fileName.replace('/', File.separatorChar);
		
		
			in=new FileInputStream(uploadPath+ntc_atc_fileName);
			System.out.println("so file name + uploadPath? :" + uploadPath+ntc_atc_fileName);
			
			if(media!=null){
				headers.setContentType(media);
			}else{
				ntc_atc_fileName=ntc_atc_fileName.substring(ntc_atc_fileName.indexOf("$$")+2);
				System.out.println("*******************"+ntc_atc_fileName);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition","attachment; fileName=\""           //fileName에
						+new String(ntc_atc_fileName.getBytes("utf-8"),"ISO-8859-1")  //<-요 fileName을 넣겠다고~
						+"\"");
			}
			entity=new ResponseEntity<byte[]>(IOUtils.toByteArray(in),
											headers,HttpStatus.CREATED);
		}catch(IOException e){
			e.printStackTrace();
			entity=new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			if(in!=null)in.close();
		}
		return entity;
		
	}
	
	@RequestMapping(value="/getAttach/{notice_num}",method=RequestMethod.GET)	
	@ResponseBody
	public List<Notice_atcVO> getAttach(@PathVariable("notice_num")int notice_num) throws Exception{
		NoticeVO notice=noticeService.getNotice(notice_num);
		List<Notice_atcVO> attachList=notice.getAttachList();
		System.out.println("@@@@@@@@@@@@@@attachList : " + attachList);
		
		return attachList;
	}
	
	@RequestMapping(value="deleteFile",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName) throws Exception{
		
		logger.info("delete fileName : "+fileName);
		
		String formatName=fileName.substring(fileName.lastIndexOf(".")+1);
		MediaType media=MediaUtils.getMediaType(formatName);
		
		if(media!=null){
			String front=fileName.substring(0, 12);
			String end=fileName.substring(14);
			new File(uploadPath+(front+end).replace('/', File.separatorChar))
				.delete();			
		}
		new File(uploadPath+fileName.replace('/', File.separatorChar)).delete();
		
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	
	@RequestMapping(value="deleteAllFiles",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> deleteFiles(@RequestParam(value="files[]",defaultValue="")String[] files,HttpSession session) throws Exception{
		
		logger.info("delete all files: "+files);
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		int loginUser_writer = loginUser.getMem_num();
		if(files==null || files.length==0){
			return new ResponseEntity<String>("deleted",HttpStatus.OK);
		}
		
		for(String fileName:files){
			
			String formatName=fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType media=MediaUtils.getMediaType(formatName);
			
			if(media!=null){
				String loginUserPath = "/"+loginUser_writer;
				
				String front=fileName.substring(0, 12+loginUserPath.length());
				String end=fileName.substring(14+loginUserPath.length());
				new File(uploadPath+(front+end).replace('/',File.separatorChar)).delete();				
			}
			
			new File(uploadPath+fileName.replace('/',File.separatorChar)).delete();
		}
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	
}
