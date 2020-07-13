package com.funding.service.admin;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.funding.dto.BannerVO;
import com.funding.request.SearchCriteria;

public interface BannerService {
	Map<String, Object> selectBannerList(SearchCriteria cri)throws SQLException;
	
	BannerVO selectBannerListByNum(int b_num)throws SQLException;
	
	void registBanner(BannerVO banner)throws SQLException;
	
	void deleteBanner(int b_num)throws SQLException;
	
	void bannerDisabled(int b_num)throws SQLException;
	
	void bannerEnabled(int b_num)throws SQLException;
	
	void modifyBanner(BannerVO banner)throws SQLException;
	
	List<BannerVO> selectActiveBanner()throws SQLException;
	
	List<BannerVO> selectActivePartnerBanner()throws SQLException;
}
