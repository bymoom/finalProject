package com.funding.dao.admin;

import java.sql.SQLException;
import java.util.List;

import com.funding.dto.PopupVO;
import com.funding.request.SearchCriteria;

public interface PopupDAO {
	//팝업 리스트조회
	List<PopupVO> selectPopupList(SearchCriteria cri)throws SQLException;
	
	//선택 팝업 select
	PopupVO selectPopupListByNum(int p_num)throws SQLException;
	
	//팝업 총 갯수
	int selectPopupListCount(SearchCriteria cri)throws SQLException;
	
	//팝업번호
	int selectPopupSeqNext()throws SQLException;
	
	//팝업 등록
	void registPopup(PopupVO popup)throws SQLException;
	
	//팝업 삭제
	void deletePopup(int p_num)throws SQLException;
	
	//팝업 비활성화
	void popupDisabled(int p_num)throws SQLException;
	
	//팝업 활성화
	void popupEnabled(int p_num)throws SQLException;
	
	//팝업 수정
	void modifyPopup(PopupVO popup)throws SQLException;
	
	//활성화된 팝업 리스트
	List<PopupVO> selectActivePopup()throws SQLException;
	
	
	
}
