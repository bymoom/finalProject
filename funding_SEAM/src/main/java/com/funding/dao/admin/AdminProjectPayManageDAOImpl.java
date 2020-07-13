package com.funding.dao.admin;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.funding.dto.Pjt_pay_detailVO;
import com.funding.request.AdminMemberDetailRequest;
import com.funding.request.AdminProjectPaySearchCriteria;

public class AdminProjectPayManageDAOImpl implements AdminProjectPayManageDAO {

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<AdminMemberDetailRequest> selectProjectPayList(AdminProjectPaySearchCriteria cri) throws SQLException {
		int offset=cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();
		RowBounds rowBounds= new RowBounds(offset,limit);
		List<AdminMemberDetailRequest> projectPayList = sqlSession.selectList("Admin-Mapper.selectProjectPayList", cri, rowBounds);
		return projectPayList;
	}

	@Override
	public int selectProjectPayListTotalCount(AdminProjectPaySearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("Admin-Mapper.selectProjectPayListTotalCount", cri);
		return count;
	}

	@Override
	public List<AdminMemberDetailRequest> selectProjectPayListForDownload(AdminProjectPaySearchCriteria cri)
			throws SQLException {
		List<AdminMemberDetailRequest> projectPayListForDownload = sqlSession.selectList("Admin-Mapper.selectProjectPayList", cri);
		return projectPayListForDownload;
	}

	@Override
	public List<Pjt_pay_detailVO> selectStandByToRefundList() throws SQLException {
		List<Pjt_pay_detailVO> standByToRefundList = sqlSession.selectList("Admin-Mapper.selectStandByToRefundList");
		return standByToRefundList;
	}

	@Override
	public AdminMemberDetailRequest selectProjectPayDetail(int pjt_pay_num) throws SQLException {
		AdminMemberDetailRequest projectPayDetail = sqlSession.selectOne("Admin-Mapper.selectProjectPayDetail", pjt_pay_num);
		return projectPayDetail;
	}

	@Override
	public Pjt_pay_detailVO selectPjtPayDetailByPjtPayNum(int pjt_pay_num) throws SQLException {
		Pjt_pay_detailVO pjtPayDetail = sqlSession.selectOne("Admin-Mapper.selectPjtPayDetailByPjtPayNum", pjt_pay_num);
		return pjtPayDetail;
	}

	@Override
	public void updateRefund(int pjt_pay_num) throws SQLException {
		sqlSession.update("Admin-Mapper.updateRefund", pjt_pay_num);
	}


}
