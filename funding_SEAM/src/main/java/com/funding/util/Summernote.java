package com.funding.util;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class Summernote {
	
	public ResponseEntity<String> uploadImg(MultipartFile file, HttpServletRequest request, String savePath, String where) throws Exception {
		ResponseEntity<String> result = null;
		
		String uploadPath = request.getServletContext().getRealPath(savePath + "/" + where);
		
		String uuid = UUID.randomUUID().toString().replace("-", "");
		String fileName = uuid + "$$" + file.getOriginalFilename();

		File saveFile = new File(uploadPath, fileName);
		if (!saveFile.exists()) {
			saveFile.mkdirs();
		}
		
		System.out.println("*********************************" + uploadPath + "*********************************");
		
		try {
			file.transferTo(saveFile);
			
			System.out.println("SUCCESS Summernote Img Upload : " + request.getContextPath() + savePath + "/" + where + "/" + fileName);
			result = new ResponseEntity<String>(request.getContextPath() + savePath + "/" + where + "/" + fileName, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Fail Summernote Img Upload : " + request.getContextPath() + savePath + "/" + where + "/" + fileName);
			result = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;

		//String uploadPathForOther = request.getContextPath() + "\\resources\\uploadImg";
		
		//proudctImage.transferTo(resourceLoader.getResource("resources/images/"+product.getProductId()+".png").getFile());
		//String uploadPathForOther = ;
		//DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
		//Resource resource = defaultResourceLoader.getResource("classpath:resources/uploadImg");
		//Set<String> test = request.getSession().getServletContext().getResourcePaths("/");
		//System.out.println(test);
		
		/*String test = request.getSession().getServletContext().getRealPath("/uploadImg/갸아아아아ㅏ아ㅏㅇ.jpg");
		System.out.println("test 존재? : " + new File(test).exists());*/
		
		//Set<String> test = request.getSession().getServletContext().getResourcePaths("/");
		//System.out.println("test : " + test + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		/*Iterator<String> iter = test.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.toString());
		}*/

		//
		//ClassPathResource resource = new ClassPathResource("uploadImg/갸아아아아ㅏ아ㅏㅇ.jpg");
		//System.out.println("resource.getPath() : " + resource.getPath() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		//System.out.println("resource.getURI() : " + resource.getURI() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		//System.out.println("resource.getURL() : " + resource.getURL() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		//
		
		
		/*File saveFileForOther = new File(uploadPathForOther, fileName);
		if (!saveFileForOther.exists()) {
			saveFileForOther.mkdirs();
		}*/
		
		//System.out.println(uploadPathForOther + fileName);
		//System.out.println(resource);
	}
	
	public ResponseEntity<String> deleteImg(HttpServletRequest request, String fileName, String savePath, String where) throws Exception {
		ResponseEntity<String> result = null;

		String uploadPath = request.getServletContext().getRealPath(savePath + "/" + where + "/");
		
		File target = new File(uploadPath + "/" + fileName);
		if (!target.exists()) {
			result = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} else {
			try {
				target.delete();
				System.out.println("SUCCESS Summernote Img Delete : " + uploadPath + "/" + fileName);
				result = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			} catch (Exception e) {
				System.out.println("Fail Summernote Img Delete : " + uploadPath + "/" + fileName);
				result = new ResponseEntity<String>("Fail", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return result;
	}
	
}
