package com.information.biz.physical;

import java.util.List;


public interface PhysicalService {
	void insertPhysical(PhysicalVO vo);  // 게시글 등록
	
	void updatePhysical(PhysicalVO vo);  // 게시글 수정
	
	void deletePhysical(PhysicalVO vo);  // 게시글 삭제
	
	PhysicalVO getPhysical(PhysicalVO vo);  // 게시글 상세 조회
	
	List<PhysicalVO> getPhysicalList(PhysicalVO vo);  // 게시글 목록 조회
}
