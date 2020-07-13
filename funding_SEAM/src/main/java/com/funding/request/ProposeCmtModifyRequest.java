package com.funding.request;

import com.funding.dto.ProjectProposeCmtVO;

public class ProposeCmtModifyRequest {
	private int pjtprp_cmts_num;
	private String pjtprp_cmts_contents;
	public int getPjtprp_cmts_num() {
		return pjtprp_cmts_num;
	}
	public void setPjtprp_cmts_num(int pjtprp_cmts_num) {
		this.pjtprp_cmts_num = pjtprp_cmts_num;
	}
	public String getPjtprp_cmts_contents() {
		return pjtprp_cmts_contents;
	}
	public void setPjtprp_cmts_contents(String pjtprp_cmts_contents) {
		this.pjtprp_cmts_contents = pjtprp_cmts_contents;
	}
	
	
	public ProjectProposeCmtVO toProposeCmtVO() {
		ProjectProposeCmtVO cmtVO = new ProjectProposeCmtVO();
		
		cmtVO.setPjtprp_cmts_num(pjtprp_cmts_num);
		cmtVO.setPjtprp_cmts_contents(pjtprp_cmts_contents);
		
		return cmtVO;
	}
	
}
