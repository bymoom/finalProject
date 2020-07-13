package com.funding.service.admin;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.funding.dto.PopupVO;
import com.funding.request.SearchCriteria;

public interface PopupService {
	Map<String, Object> selectPopupList(SearchCriteria cri)throws SQLException;
	
	PopupVO selectPopupListByNum(int p_num)throws SQLException;
	
	void registPopup(PopupVO popup)throws SQLException;
	
	void deletePopup(int p_num)throws SQLException;
	
	void popupDisabled(int p_num)throws SQLException;
	
	void popupEnabled(int p_num)throws SQLException;
	
	void modifyPopup(PopupVO popup)throws SQLException;
	
	List<PopupVO> selectActivePopup()throws SQLException;
}
