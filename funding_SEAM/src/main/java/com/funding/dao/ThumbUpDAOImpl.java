package com.funding.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.funding.dto.Thumb_upVO;

public class ThumbUpDAOImpl implements ThumbUpDAO {

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public Thumb_upVO selectThumbUpForPJTPRP(Thumb_upVO thumbUp) throws SQLException {
		Thumb_upVO selectedThumbUp = sqlSession.selectOne("Thumb_up-Mapper.selectThumbUpForPJTPRP", thumbUp);
		return selectedThumbUp;
	}

	@Override
	public Thumb_upVO selectThumbUpForPJTPRP_CMTS(Thumb_upVO thumbUp) throws SQLException {
		Thumb_upVO selectedThumbUp = sqlSession.selectOne("Thumb_up-Mapper.selectThumbUpForPJTPRP_CMTS", thumbUp);
		return selectedThumbUp;
	}

	@Override
	public Thumb_upVO selectThumbUpForFreeBoard(Thumb_upVO thumbUp) throws SQLException {
		Thumb_upVO selectedThumbUp = sqlSession.selectOne("Thumb_up-Mapper.selectThumbUpForFreeBoard", thumbUp);
		return selectedThumbUp;
	}

	@Override
	public Thumb_upVO selectThumbUpForFreeBoard_CMTS(Thumb_upVO thumbUp) throws SQLException {
		Thumb_upVO selectedThumbUp = sqlSession.selectOne("Thumb_up-Mapper.selectThumbUpForFreeBoard_CMTS", thumbUp);
		return selectedThumbUp;
	}

	@Override
	public void registThumbUpForPJTPRP(Thumb_upVO thumbUp) throws SQLException {
		sqlSession.update("Thumb_up-Mapper.registThumbUpForPJTPRP", thumbUp);
	}

	@Override
	public void registThumbUpForPJTPRP_CMTS(Thumb_upVO thumbUp) throws SQLException {
		sqlSession.update("Thumb_up-Mapper.registThumbUpForPJTPRP_CMTS", thumbUp);
	}

	@Override
	public void registThumbUpForFreeBoard(Thumb_upVO thumbUp) throws SQLException {
		sqlSession.update("Thumb_up-Mapper.registThumbUpForFreeBoard", thumbUp);
	}

	@Override
	public void registThumbUpForFreeBoard_CMTS(Thumb_upVO thumbUp) throws SQLException {
		sqlSession.update("Thumb_up-Mapper.registThumbUpForFreeBoard_CMTS", thumbUp);
	}

	@Override
	public void removeThumbUp(int thumbup_num) throws SQLException {
		sqlSession.delete("Thumb_up-Mapper.removeThumbUp", thumbup_num);
	}

}
