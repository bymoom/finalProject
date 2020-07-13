package com.funding.service;

import java.sql.SQLException;

import com.funding.dto.Thumb_upVO;

public interface ThumbUpService {
	
		//프로젝트 제안 글의 좋아요 조회
		public Thumb_upVO selectThumbUpForPJTPRP(Thumb_upVO thumbUp) throws SQLException;

		//프로젝트 제안 댓글의 좋아요 조회
		public Thumb_upVO selectThumbUpForPJTPRP_CMTS(Thumb_upVO thumbUp) throws SQLException;

		//자유게시판 글의 좋아요 조회
		public Thumb_upVO selectThumbUpForFreeBoard(Thumb_upVO thumbUp) throws SQLException;

		//자유게시판 댓글의 좋아요 조회
		public Thumb_upVO selectThumbUpForFreeBoard_CMTS(Thumb_upVO thumbUp) throws SQLException;

		//프로젝트 제안 글의 좋아요 등록
		public void registThumbUpForPJTPRP(Thumb_upVO thumbUp) throws SQLException;

		//프로젝트 제안 댓글의 좋아요 등록
		public void registThumbUpForPJTPRP_CMTS(Thumb_upVO thumbUp) throws SQLException;

		//자유게시판 글의 좋아요 등록
		public void registThumbUpForFreeBoard(Thumb_upVO thumbUp) throws SQLException;

		//자유게시판 댓글의 좋아요 등록
		public void registThumbUpForFreeBoard_CMTS(Thumb_upVO thumbUp) throws SQLException;

		//좋아요 삭제
		public void removeThumbUp(int thumbup_num) throws SQLException;
		
}
