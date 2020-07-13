package com.funding.controller.mypage.info;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.funding.controller.EmailSender;
import com.funding.dto.CalendarVO;
import com.funding.dto.ComMemberVO;
import com.funding.dto.EmailVO;
import com.funding.dto.MemberVO;
import com.funding.dto.PointManageVO;
import com.funding.dto.PointVO;
import com.funding.request.ComMemberDetailRequest;
import com.funding.request.ComMemberModifyRequest;
import com.funding.request.MemberModifyRequest;
import com.funding.request.MemberRegistRequest;
import com.funding.service.MemberService;
import com.funding.service.admin.AdminPointManageService;
import com.funding.service.member.PointService;
import com.funding.service.myinfo.CalendarService;
import com.funding.service.myinfo.MyinfoService;
import com.funding.util.Encryption;
import com.funding.util.TempKey;
import com.ibm.icu.util.Calendar;

@Controller
@RequestMapping("/mypage/info")
public class MypageInfoController {

//	@Autowired
//	private MemberService memberService;
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}
	
	@Autowired
	private MyinfoService myinfoService;
	
	public void setMyinfoService(MyinfoService myinfoService) {
		this.myinfoService = myinfoService;
	}
	
	@Autowired
	private CalendarService calendarService;
	
	public void setCalendarService(CalendarService calendarService) {
		this.calendarService = calendarService;
	}
	
	@Autowired
	private AdminPointManageService adminPointService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PointService pointService;
	
	@Resource(name = "memberAtcPath")
	private String memberAtcPath;
	
	@Autowired
	public EmailSender mailSender;
	
	@Autowired
	public EmailVO email;
	
	@RequestMapping(value = "/test4id")
	public String test4Id() throws Exception {
		String url = "mypage/info/calmain";
		
		MemberVO member = myinfoService.getMember("d1com@ddit.com");
		
		System.out.println(member.getMem_email());

		return url;
	}
	
	@RequestMapping(value="dailycheck", method=RequestMethod.POST)
	public ResponseEntity<String> dailyCheck(HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		String mem_email = member.getMem_email();
		
		ResponseEntity<String> entity = null;
		return entity;
	}
	
	//일반회원 정보 
	@RequestMapping(value = "detail", method = RequestMethod.POST )
	public String detailMyinfo(HttpSession session,
								Model model,
								String mem_pw
								) throws Exception {
		String url = "mypage/info/detailMyinfoForm.mypage";
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		
		Encryption enc;
		String encode = "";
		
		try {
			enc = new Encryption();
			encode = enc.aesEncode(mem_pw);
			System.out.println("encode >");
			System.out.println(encode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
//			memberService.login(member.getMem_email(), mem_pw);
			memberService.login(member.getMem_email(), encode);
		} catch (Exception e) {
			url = "mypage/info/modify_entrance_fail";
			e.printStackTrace();
			return url;
		}
		
		member = myinfoService.getMember(member.getMem_email());
		model.addAttribute("member", member);
		
		return url;
	}
	
	@RequestMapping("/beforeDetail")
	public String beforeDetailMyinfo() throws Exception {
		String url = "mypage/info/modify_entrance.mypage";
		
		return url;
	}
	
	@RequestMapping("/beforeDetailCom")
	public String beforeDetailComMyinfo() throws Exception {
		String url = "mypage/info/modify_entranceCom.mypage";
		
		return url;
	}
	
	//소상공인 정보 
	@RequestMapping(value = "detailCom", method = RequestMethod.POST )
	public String detailComMyinfo(HttpSession session,
								  Model model,
								  String mem_pw
								 ) throws Exception {
		String url = "mypage/info/detailComMyinfoForm.mypage";
		
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		
		System.out.println(member.getMem_email());
		
		Encryption enc;
		String encode = "";
		
		try {
			enc = new Encryption();
			encode = enc.aesEncode(mem_pw);
			System.out.println("encode >");
			System.out.println(encode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
//			memberService.login(member.getMem_email(), mem_pw);
			memberService.login(member.getMem_email(), encode);
		} catch (Exception e) {
			url = "mypage/info/modify_entranceCom_fail";
			e.printStackTrace();
			return url;
		}
		
		ComMemberDetailRequest comMember = myinfoService.getComMemberByMemNum(member.getMem_email());
		model.addAttribute("comMember", comMember);
		
		return url;
	}
	
//	//일반회원 정보수정 폼
//	@RequestMapping(value="modifyForm")
//	public String modifyMyinfoForm( HttpSession session,
//									HttpServletRequest request
//									) {
//		String url = "mypage/info/modifyMyinfoForm";
//		
//		MemberVO member = (MemberVO)session.getAttribute("loginUser");
//		
//		request.setAttribute("member", member);
//		
//		return url;
//	}
	
	//일반회원 정보수정 //GET
	@RequestMapping(value="modify", method = RequestMethod.GET)
	public String modifyMyinfoGET (	HttpSession session,
									String mem_email,
									Model model
									) throws Exception {
			String url = "mypage/info/modifyMyinfoForm.mypage";
			//MemberVO member = (MemberVO)session.getAttribute("loginUser");
			MemberVO member = myinfoService.getMember(mem_email);
			
			model.addAttribute("member", member);
			
			return url;
	}

	
	//일반회원 정보수정 //POST
	@RequestMapping(value="modify", method = RequestMethod.POST)
	public String modifyMyinfoPOST (HttpSession session,
								MemberModifyRequest modReq,
								HttpServletResponse response,
								Model model
								) throws Exception {
		String url = "mypage/info/modify_success";
		
		Encryption enc;
		String encode = "";
		
//		MemberVO member = modReq.toMemberVO();
		MemberVO member = (MemberVO)session.getAttribute("loginUser");

		MultipartFile[] files = { modReq.getMem_profile_img(), modReq.getMem_profile_ori()};
		List<String> saveFileName = new ArrayList<String>();
		for(MultipartFile file : files) {
			if (file == null) 
				continue;
			
//			String fileName = UUID.randomUUID().toString().replace("-", "");
			String fileName = UUID.randomUUID().toString().replace("-", "") + "$$" + file.getOriginalFilename();
			File savePath = new File(memberAtcPath + File.separator + member.getMem_email());
			if (!savePath.exists()) {
				savePath.mkdirs();
			}

			file.transferTo(new File(savePath, fileName));
			saveFileName.add(fileName);
		}
		
		//memberVO 에 각 attach set
		member.setMem_profile_img(saveFileName.get(0));
//		member.setMem_email(member.getMem_email());

		String mem_pw = modReq.getMem_pw();
		
		try {
			enc = new Encryption();
			encode = enc.aesEncode(mem_pw);
			System.out.println("encode >");
			System.out.println(encode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		member.setMem_pw(encode);
		member.setMem_phone(modReq.getMem_phone());
		
		try {
//			myinfoService.modify(member);
			myinfoService.modify(member);
			model.addAttribute("member", member);
			url = "mypage/info/modify_success";
		} catch (Exception e) {
			e.printStackTrace();
			url = "mypage/info/modify_fail";
		}
		
		return url;
	}
	
	//소상공인 회원 정보수정 폼
	@RequestMapping(value="modifyCom", method = RequestMethod.GET)
	public String modifyComMyinfoForm( HttpSession session,
									HttpServletRequest request,
									String mem_email,
									Model model ) throws Exception {
		String url = "mypage/info/modifyComMyinfoForm.mypage";
 
 		ComMemberDetailRequest comMember = null;

		try {
			comMember = myinfoService.getComMemberByMemNum(mem_email);
			model.addAttribute("comMember", comMember);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return url;
	}
	
	//소상공인 회원 정보수정
	@RequestMapping(value="modifyCom", method = RequestMethod.POST)
	public String modifyComMyinfo (HttpSession session,
								ComMemberModifyRequest comModReq,
								HttpServletResponse response,
								Model model
								) throws Exception {
		String url = "mypage/info/modifyCom_success";
		
		Encryption enc;
		String encode = "";
		
//		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		MemberVO member = comModReq.toMemberVO();
		ComMemberDetailRequest comMember = myinfoService.getComMemberByMemNum(member.getMem_email());
		 
		MultipartFile[] files = { comModReq.getMem_profile_img(), comModReq.getCom_bsns_reg_license(), comModReq.getCom_bsns_cert()};
		List<String> saveFileName = new ArrayList<String>();
		for(MultipartFile file : files) {
			if (file == null || file.isEmpty()) {
 				url = "mypage/info/modify_upload_fail";
				return url;
			}
			
//			String fileName = UUID.randomUUID().toString().replace("-", "");
			String fileName = UUID.randomUUID().toString().replace("-", "")  + "$$" + file.getOriginalFilename();
			
			File savePath = new File(memberAtcPath + File.separator + comModReq.getMem_email());
			if (!savePath.exists()) {
				savePath.mkdirs();
			}

			file.transferTo(new File(savePath, fileName));
			saveFileName.add(fileName);
		}
		
		System.out.println("modifyComMyinfo saveFileName Size>>> " + saveFileName.size());
		
		
		String mem_pw = comModReq.getMem_pw();
		
		try {
			enc = new Encryption();
			encode = enc.aesEncode(mem_pw);
			System.out.println("encode >");
			System.out.println(encode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		member.setMem_pw(encode);
		
		//attach set
		member.setMem_profile_img(saveFileName.get(0));
		member.setMem_email(member.getMem_email());
		member.setMem_phone(comModReq.getMem_phone());
		
		comMember.setCom_bsns_reg_license(saveFileName.get(1));
  		comMember.setCom_bsns_cert(saveFileName.get(2));

		comMember.setCom_bsns_name(comModReq.getCom_bsns_name());
		comMember.setCom_bsns_rep_name(comModReq.getCom_bsns_rep_name());
		comMember.setCom_bsns_phone(comModReq.getCom_bsns_phone());
		
		comMember.setCom_zipcode(comModReq.getCom_zipcode());
		comMember.setCom_addr1(comModReq.getCom_addr1());
 		comMember.setCom_addr2(comModReq.getCom_addr2()); 
		
		try {
			myinfoService.modify(member);

			myinfoService.modifyNewCom(comMember);
 			model.addAttribute("comMember", comMember);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
	@RequestMapping("/picture/{mem_num}")
	@ResponseBody
	public ResponseEntity<byte[]> sendPicture(@PathVariable int mem_num,	
												HttpServletResponse response,
												HttpSession session) throws Exception {
		ResponseEntity<byte[]> entity = null;
		
//		MemberVO mem = (MemberVO)session.getAttribute("loginUser");
//		MemberVO mem = myinfoService.getMember(mem_email);
		MemberVO mem = myinfoService.getMemberByNum(mem_num);
		
		String fileName = mem.getMem_profile_img();
		String savePath = memberAtcPath + File.separator;		// + emp.getId();

		FileInputStream in = null;

		try {
			in = new FileInputStream(savePath + File.separator + mem.getMem_email() + File.separator + fileName);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
		} catch (IOException e) {
			entity = new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		} finally {
			if(in!=null)
				in.close();
		}

		return entity;

	}
	
	@RequestMapping("/receiveDoc")
	@ResponseBody
	public ResponseEntity<byte[]> receiveDoc(String fileName, String id) throws Exception 
	{
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		HttpHeaders headers = new HttpHeaders();
		
		String savePath = memberAtcPath + File.separator + id;
		
		try {
			in = new FileInputStream(savePath + File.separator + fileName);
			
			fileName = fileName.substring(fileName.indexOf("$$") + 2);
			
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("utf-8"), "ISO-8859-1") + "\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			if(in != null)
				in.close();
		}
		return entity;
	}
		
	private String saveFile(MultipartFile file,String old_fileName,String id) throws Exception {
		if(file==null || file.isEmpty()) {
			if(old_fileName==null || old_fileName.isEmpty()) {
				File oldFile = new File(memberAtcPath + File.separator + id, old_fileName);
				if(oldFile.exists())
					oldFile.delete();
				return "";
			}
			return old_fileName;
		}
		
		//기존 파일 삭제
		File oldFile = new File(memberAtcPath + File.separator + id, old_fileName);
		if(oldFile.exists())
			oldFile.delete();
		
		//신규 파일 저장
//		String fileName = UUID.randomUUID().toString().replace("-", "");
		String fileName = UUID.randomUUID().toString().replace("-", "")  + "$$" + file.getOriginalFilename();
		File savePath = new File(memberAtcPath + File.separator + id);
		
		if(!savePath.exists()) {
			savePath.mkdirs();
		}
		
		file.transferTo(new File(savePath, fileName));

		return fileName;
	}
	
	@RequestMapping(value = "dailychk", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, String>> getDailyCheckData(String mem_email) throws Exception {
		ResponseEntity<Map<String, String>> entity = null;
		
		// 오늘 날짜의 데이터가 들어갔음을 알려주기 위해서 DB에 저장
		int mem_num = myinfoService.getMemNum(mem_email);
		CalendarVO cal = new CalendarVO();
		cal.setMem_num(mem_num);
		cal.setTitle("TodayCheck!");
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar day = Calendar.getInstance();  //현재날짜 구하기
		Date startDate = day.getTime();
		Date endDate = day.getTime();
		String startDateStr = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
		String endDateStr = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
		cal.setStartdate(startDate);
		cal.setEnddate(endDate);
		
		Map<String, String> result = new HashMap<String, String>();
		
		// try catch 로 익셉션 처리
		try {
			int cnt = 0;
			cnt = calendarService.selectTodayCheck(mem_num);
			
			if(cnt > 0)
			{
				System.out.println(mem_num + " >> Over Count!");
				return entity;
			}
			
			calendarService.insertDailyCheck(cal);
			
			result.put("title", "TodayCheck");
			result.put("start", startDateStr);
			result.put("end", endDateStr);
			
			PointManageVO attendPoint = adminPointService.checkAttendPoint();
			if(attendPoint.getPointmng_enabled()==1) {
				MemberVO member = memberService.getMember(mem_email);
				int mem_num2 = member.getMem_num();
				int getPoint = attendPoint.getPoint();
				
				PointVO point = new PointVO();
				point.setMem_num(mem_num2);
				point.setPoint(getPoint);
				
				pointService.savePoint(point);
			}

			
			entity = new ResponseEntity<Map<String, String>>(result, HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<Map<String, String>>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		
		return entity;
	}
	
	@RequestMapping(value = "loadDailyChk", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<CalendarListToJsonDTO>> getBeforeDailyCheckData (int mem_num) throws Exception {
		ResponseEntity<List<CalendarListToJsonDTO>> entity = null;
		
		try {
			List<String> dateList = calendarService.getAttendanceList(mem_num);
			List<CalendarListToJsonDTO> jsonList = new ArrayList<CalendarListToJsonDTO>();

			if(dateList != null) {
				for(String str : dateList) {
					CalendarListToJsonDTO cd = new CalendarListToJsonDTO("TodayCheck", str, str);
					jsonList.add(cd);
				}
			}

			entity = new ResponseEntity<List<CalendarListToJsonDTO>>(jsonList, HttpStatus.OK);

		} catch (Exception e) {
			entity = new ResponseEntity<List<CalendarListToJsonDTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}

	
//	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	@RequestMapping(value = "/calmain")
	public String CalendarMain(HttpSession session, Model model) throws Exception {
//		String url = "mypage/info/calmain.page";
		String url = "mypage/info/calmain.mypage";

		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		model.addAttribute("member", member);
		
		return url;
	}
	
	@RequestMapping(value = "list")
	public String myPageMain(HttpSession session, Model model) throws Exception {
		String url = "mypage/info/list.mypage";
		
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		model.addAttribute("member", member);
		
		return url;
	}
	
	@RequestMapping(value = "withdrawForm")
	public String withdrawForm(HttpSession session, Model model) throws Exception {
		String url = "mypage/info/withdrawForm.mypage";
		
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		model.addAttribute("member", member);
		
		return url;
	}

	@RequestMapping(value = "withdraw")
	public String withdraw(String mem_email,
							String mem_pw,
							String uuid_key,
							Model model) throws Exception {
		String url = "mypage/info/withdraw_ok";
		
		Encryption enc;
		String encode = "";
		
		try {
			enc = new Encryption();
			encode = enc.aesEncode(mem_pw);
			System.out.println("encode >");
			System.out.println(encode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
//			String id = memberService.getMemberByIdPwUuid(mem_email, mem_pw, uuid_key);
			String id = memberService.getMemberByIdPwUuid(mem_email, encode, uuid_key);
			int num = memberService.getMemNum(id);
			pointService.deletePointByMemNum(num);
			memberService.removeComMember(num);
			memberService.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("mem_email", mem_email);
		
		return url;
	}
	
	@RequestMapping(value = "issueUuidKey", method = RequestMethod.GET)
	public String issueUuidKey(String mem_email, HttpSession session, Model model) throws Exception {
		String url = "mypage/info/issueUuidKey";
		
//		MemberVO member = (MemberVO)session.getAttribute("loginUser");
//		model.addAttribute("member", member);
		
		String strTemp = TempKey.getKey(15, false);
		System.out.println("mem_email > " + mem_email + " login uuid_key > " + strTemp);
		memberService.updateUuidKey(strTemp, mem_email);
		
		String uuid_key = memberService.getUuidKeyById(mem_email);
		
		email.setReceiver(mem_email);	//수신자 메일주소
		email.setContent("안녕하세요 FUN SEAM DING 입니다.\n 인증키는 " + uuid_key + "입니다.");
		email.setSubject(mem_email + "님 회원탈퇴를 위한 인증 메일입니다.");
		
		try {
			mailSender.SendEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("mem_email", mem_email);
		
		return url;
	}
	
}
