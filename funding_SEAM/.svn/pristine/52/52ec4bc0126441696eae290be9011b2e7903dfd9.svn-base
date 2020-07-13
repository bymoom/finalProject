package com.funding.dao.freeboard;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dto.FreeBoardCmtsVO;
import com.funding.request.SearchCriteria;

public class FreeBoardCmtsDAOImpl implements FreeBoardCmtsDAO {

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<FreeBoardCmtsVO> selectFreeBoardCmtsList(int free_num) throws SQLException {
		List<FreeBoardCmtsVO> freeBoardCmtsList = sqlSession.selectList("FreeBoardCmts-Mapper.selectFreeBoardCmtsList", free_num);
		return freeBoardCmtsList;
	}
	
	@Override
	public FreeBoardCmtsVO selectFreeBoardCmts(int free_cmts_num) throws SQLException {
		FreeBoardCmtsVO freeBoardCmts = sqlSession.selectOne("FreeBoardCmts-Mapper.selectFreeBoardCmts", free_cmts_num);
		return freeBoardCmts;
	}

	@Override
	public int countFreeBoardCmts(int free_num) throws SQLException {
		int count = (Integer) sqlSession.selectOne("FreeBoardCmts-Mapper.countFreeBoardCmts", free_num);
		return count;
	}

	@Override
	public void registFreeBoardCmts(FreeBoardCmtsVO freeBoardCmts) throws SQLException {
		sqlSession.update("FreeBoardCmts-Mapper.registFreeBoardCmts", freeBoardCmts);
	}

	@Override
	public void modifyFreeBoardCmts(FreeBoardCmtsVO freeBoardCmts) throws SQLException {
		sqlSession.update("FreeBoardCmts-Mapper.modifyFreeBoardCmts", freeBoardCmts);
	}

	@Override
	public void modifyFreeBoardCmtsEnabled(FreeBoardCmtsVO freeBoardCmts) throws SQLException {
		sqlSession.update("FreeBoardCmts-Mapper.modifyFreeBoardCmtsEnabled", freeBoardCmts);
	}

	@Override
	public void removeFreeBoardCmts(int free_cmts_num) throws SQLException {
		sqlSession.update("FreeBoardCmts-Mapper.removeFreeBoardCmts", free_cmts_num);
	}

	@Override
	public void increaseFreeCmtsLike(int free_cmts_num) throws SQLException {
		sqlSession.update("FreeBoardCmts-Mapper.increaseFreeCmtsLike", free_cmts_num);
	}

	@Override
	public void decreaseFreeCmtsLike(int free_cmts_num) throws SQLException {
		sqlSession.update("FreeBoardCmts-Mapper.decreaseFreeCmtsLike", free_cmts_num);		
	}

}
