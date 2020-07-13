package com.funding.dao.project;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.funding.dto.Project_cmtsVO;

public class Project_cmtsDAOImpl implements Project_cmtsDAO {
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insertReply(Project_cmtsVO project_cmts) throws SQLException {
		sqlSession.update("Project_cmts-Mapper.insertReply",project_cmts);
	}

	@Override
	public void updateReply(Project_cmtsVO project_cmts) throws SQLException {
		sqlSession.update("Project_cmts-Mapper.updateReply",project_cmts);
	}

	@Override
	public void deleteReply(int pjt_cmts_num) throws SQLException {
		sqlSession.update("Project_cmts-Mapper.deleteReply",pjt_cmts_num);
	}

	@Override
	public List<Project_cmtsVO> selectReplyList(int pjt_num) throws SQLException {
		List<Project_cmtsVO> replyList = sqlSession.selectList("Project_cmts-Mapper.selectReplyList",pjt_num);
		return replyList;
	}

	@Override
	public void updateAllBlindCancle(int pjt_num) throws SQLException {
		sqlSession.update("Project_cmts-Mapper.updateAllBlindCancle",pjt_num);
	}

	@Override
	public void updateBlind(int pjt_cmts_num) throws SQLException {
		sqlSession.update("Project_cmts-Mapper.updateBlind",pjt_cmts_num);
	}

}
