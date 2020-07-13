package com.funding.dao.admin;

import java.sql.SQLException;
import java.util.List;

import com.funding.dto.BannerVO;
import com.funding.request.SearchCriteria;
import com.funding.dto.BannerVO;

public interface BannerDAO {
	//배너 리스트
	List<BannerVO> selectBannerList(SearchCriteria cri)throws SQLException;
	
	//선택 배너조회
	BannerVO selectBannerListByNum(int b_num)throws SQLException;
	
	//배너리스트 총 갯수
	int selectBannerListCount()throws SQLException;
	
	//시퀀스번호 받기
	int selectBannerSeqNext()throws SQLException;
	
	//배너 등록
	void registBanner(BannerVO banner)throws SQLException;
	
	//배너 삭제
	void deleteBanner(int b_num)throws SQLException;
	
	//배너 비활성화
	void bannerDisabled(int b_num)throws SQLException;
	
	//배너 활성화
	void bannerEnabled(int b_num)throws SQLException;
	
	//배너 수정
	void modifyBanner(BannerVO banner)throws SQLException;
	
	//활성화된 배너 리스트(메인)
	List<BannerVO> selectActiveBanner()throws SQLException;
	
	//활성화된 배너 리스트(파트너)
	List<BannerVO> selectActivePartnerBanner()throws SQLException;
}
