package com.funding.schedule;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dto.ProjectVO;
import com.funding.service.admin.AdminProjectManageService;
import com.funding.util.JavaSendSms;

public class AdminSchedule {

	@Autowired
	private AdminProjectManageService adminProjectManageService;
	public void setAdminProjectManageService(AdminProjectManageService adminProjectManageService) {
		this.adminProjectManageService = adminProjectManageService;
	}
	
	public void sendScheduler() {
	
		try {
			List<ProjectVO> finishProjectList = adminProjectManageService.getFinishProjectList();
		
			String content = "";
			String donationList = "";
			String loanList = "";
			
			if(finishProjectList != null) {
				for(ProjectVO project : finishProjectList) {
					if(project.getPjt_type_code() == 1) { //기부
						donationList += "- " + project.getPjt_title() + "\n";
					}
					if(project.getPjt_type_code() == 2) { //대출
						loanList = "- " + project.getPjt_title() + "\n";
					}
				}
				
				if(donationList.equals("")) {
					donationList = "종료된 기부 프로젝트가 없습니다.";
				}
				if(loanList.equals("")) {
					loanList = "종료된 대출 프로젝트가 없습니다.";
				}
				
				content = "[FunSEAMding]\n오늘 종료된 프로젝트 목록입니다.\n<기부형 프로젝트>\n" + donationList + "<대출형 프로젝트>\n" + loanList + "자세한 사항은 FunSEAMding 관리자 페이지에 방문하여 확인 부탁드립니다. \n행복한 하루 보내세요!";
			}else {
				content = "종료된 프로젝트가 없습니다.";
			}
			
			/*if(donationList.equals("")) {
				System.out.println("종료된 기부 프로젝트가 없음");
			}else if(!donationList.equals("")) {
				System.out.println("종료된 기부 프로젝트 : " + donationList);
			}
			if(loanList.equals("")) {
				System.out.println("종료된 대출 프로젝트가 없음");
			}else if(!loanList.equals("")) {
				System.out.println("종료된 대출 프로젝트 : " + loanList);
			}*/

			JavaSendSms javaSendSms = new JavaSendSms();
			javaSendSms.sendsms("010-9065-7177", content);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
