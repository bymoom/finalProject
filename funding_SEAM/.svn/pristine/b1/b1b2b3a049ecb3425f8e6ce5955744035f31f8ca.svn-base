package com.funding.service.admin;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.funding.dao.admin.BannerDAO;
import com.funding.dto.BannerVO;
import com.funding.request.PageMaker;
import com.funding.request.SearchCriteria;

public class BannerServiceImpl implements BannerService{

	private BannerDAO bannerDAO;
	public void setBannerDAO(BannerDAO bannerDAO) {
		this.bannerDAO = bannerDAO;
	}
	@Override
	public Map<String, Object> selectBannerList(SearchCriteria cri) throws SQLException {
		List<BannerVO> list = bannerDAO.selectBannerList(cri);
		Map<String,Object> dataMap = new HashMap<String, Object>();
		
		int totalCount = bannerDAO.selectBannerListCount();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("banner", list);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}

	@Override
	public BannerVO selectBannerListByNum(int b_num) throws SQLException {
		BannerVO banner = bannerDAO.selectBannerListByNum(b_num);
		return banner;
	}

	@Override
	public void registBanner(BannerVO banner) throws SQLException {
		int b_num = bannerDAO.selectBannerSeqNext();
		banner.setB_num(b_num);
		
		bannerDAO.registBanner(banner);
	}

	@Override
	public void deleteBanner(int b_num) throws SQLException {
		bannerDAO.deleteBanner(b_num);
		
	}

	@Override
	public void bannerDisabled(int b_num) throws SQLException {
		bannerDAO.bannerDisabled(b_num);
		
	}

	@Override
	public void bannerEnabled(int b_num) throws SQLException {
		bannerDAO.bannerEnabled(b_num);
		
	}

	@Override
	public void modifyBanner(BannerVO banner) throws SQLException {
		bannerDAO.modifyBanner(banner);
		
	}

	@Override
	public List<BannerVO> selectActiveBanner() throws SQLException {
		List<BannerVO> list = bannerDAO.selectActiveBanner();
		return list;
	}
	@Override
	public List<BannerVO> selectActivePartnerBanner() throws SQLException {
		List<BannerVO> list = bannerDAO.selectActivePartnerBanner();
		return list;
	}

}
