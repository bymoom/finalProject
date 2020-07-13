package com.funding.service.project;

import java.sql.SQLException;
import java.util.Map;

import com.funding.dto.Pjt_pay_detailVO;
import com.funding.request.PaylistSearchCriteria;
import com.funding.request.SearchCriteria;

public interface Pjt_pay_detailService {
	
	public int pjtSumPay(int pjt_num)throws SQLException;
	
	public void pjtPay(Pjt_pay_detailVO pjt_pay_detail)throws SQLException;
	
	public Map<String, Object> getPjtPayTableList(SearchCriteria cri,int mem_num)throws SQLException;
	
	public Map<String, Object> getPjtPayListByMemNum(SearchCriteria cri,int mem_num)throws SQLException;

	public Map<String, Object> getPjtPayListForRefundByMemNum(SearchCriteria cri,int mem_num)throws SQLException;
	
	public Map<String, Object> getPjtRefundListByMemNum(PaylistSearchCriteria cri,int mem_num)throws SQLException;
	
	public Map<String, Object> getPjtAllPayListByMemNum(PaylistSearchCriteria cri,int mem_num)throws SQLException;
	
	public Map<String, Object> getPjtPayTypePayListByMemNum(PaylistSearchCriteria cri,int mem_num)throws SQLException;
	
	public void updateAskRefundStateToOne(int pjt_pay_num) throws SQLException;

}
