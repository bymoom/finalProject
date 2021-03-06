package com.funding.service.admin;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dao.admin.AdminProjectPayManageDAO;
import com.funding.dto.Pjt_pay_detailVO;
import com.funding.request.AdminMemberDetailRequest;
import com.funding.request.AdminProjectPayPageMaker;
import com.funding.request.AdminProjectPaySearchCriteria;

public class AdminProjectPayManageServiceImpl implements AdminProjectPayManageService {

	@Autowired
	private AdminProjectPayManageDAO adminProjectPayManageDAO;
	public void setAdminProjectPayManageDAO(AdminProjectPayManageDAO adminProjectPayManageDAO) {
		this.adminProjectPayManageDAO = adminProjectPayManageDAO;
	}
	
	@Override
	public Map<String, Object> getProjectPayList(AdminProjectPaySearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<AdminMemberDetailRequest> projectPayList = adminProjectPayManageDAO.selectProjectPayList(cri);
		int totalCount = adminProjectPayManageDAO.selectProjectPayListTotalCount(cri);
		
		AdminProjectPayPageMaker pageMaker = new AdminProjectPayPageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("projectPayList", projectPayList);
		dataMap.put("pageMaker", pageMaker);
		
		/**
		 * 다운로드 용 리스트 조회
		 */
		List<AdminMemberDetailRequest> projectPayListForDownload = adminProjectPayManageDAO.selectProjectPayListForDownload(cri);
		dataMap.put("projectPayListForDownload", projectPayListForDownload);

		/**
		 * 환불 대기자 리스트 조회
		 */
		List<Pjt_pay_detailVO> standByToRefundList = adminProjectPayManageDAO.selectStandByToRefundList();
		dataMap.put("standByToRefundList", standByToRefundList);
		
		return dataMap;
	}

	@Override
	public void updateRefund(int pjt_pay_num) throws SQLException {
		adminProjectPayManageDAO.updateRefund(pjt_pay_num);
	}

	@Override
	public Map<String, Object> getProjectPayDetail(int pjt_pay_num) throws SQLException {
		Map<String, Object> dataMap = new HashMap<>();
		
		AdminMemberDetailRequest projectPayDetail = adminProjectPayManageDAO.selectProjectPayDetail(pjt_pay_num);
		List<Pjt_pay_detailVO> standByToRefundList = adminProjectPayManageDAO.selectStandByToRefundList();
		
		
		dataMap.put("projectPayDetail", projectPayDetail);
		dataMap.put("standByToRefundList", standByToRefundList);
		
		return dataMap;
	}

}
