package com.funding.dao.admin;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.funding.dto.BannerVO;
import com.funding.dto.PopupVO;
import com.funding.request.SearchCriteria;

public class BannerDAOImpl implements BannerDAO{

	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<BannerVO> selectBannerList(SearchCriteria cri) throws SQLException {
		int offset=cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();
		RowBounds rowBounds= new RowBounds(offset,limit);
		List<BannerVO> list = sqlSession.selectList("Banner-Mapper.selectBannerList",cri,rowBounds);
		return list;
	}

	@Override
	public BannerVO selectBannerListByNum(int b_num) throws SQLException {
		BannerVO banner = sqlSession.selectOne("Banner-Mapper.selectBannerListByNum",b_num);
		return banner;
	}

	@Override
	public int selectBannerListCount() throws SQLException {
		int count = sqlSession.selectOne("Banner-Mapper.selectBannerListCount");
		return count;
	}

	@Override
	public int selectBannerSeqNext() throws SQLException {
		int seq = sqlSession.selectOne("Banner-Mapper.selectBannerSeqNext");
		return seq;
	}

	@Override
	public void registBanner(BannerVO banner) throws SQLException {
		sqlSession.update("Banner-Mapper.registBanner",banner);
		
	}

	@Override
	public void deleteBanner(int b_num) throws SQLException {
		sqlSession.update("Banner-Mapper.deleteBanner",b_num);
		
	}

	@Override
	public void bannerDisabled(int b_num) throws SQLException {
		sqlSession.update("Banner-Mapper.bannerDisabled",b_num);
		
	}

	@Override
	public void bannerEnabled(int b_num) throws SQLException {
		sqlSession.update("Banner-Mapper.bannerEnabled",b_num);
		
	}

	@Override
	public void modifyBanner(BannerVO banner) throws SQLException {
		sqlSession.update("Banner-Mapper.modifyBanner",banner);
		
	}

	@Override
	public List<BannerVO> selectActiveBanner() throws SQLException {
		List<BannerVO> list = sqlSession.selectList("Banner-Mapper.selectActiveBanner");
		return list;
	}

	@Override
	public List<BannerVO> selectActivePartnerBanner() throws SQLException {
		List<BannerVO> list = sqlSession.selectList("Banner-Mapper.selectActivePartnerBanner");
		return list;
	}

}
