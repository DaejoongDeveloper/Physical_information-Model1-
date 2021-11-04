package com.information.biz.physical.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.information.biz.physical.PhysicalService;
import com.information.biz.physical.PhysicalVO;
@Service("physicalService")
public class PhysicalServiceImpl  implements PhysicalService{
	@Autowired
	private PhysicalDAO physicalDAO;
	@Override
	public void insertPhysical(PhysicalVO vo) {
		physicalDAO.insertPhysical(vo);
	}

	@Override
	public void updatePhysical(PhysicalVO vo) {
		physicalDAO.updatePhysical(vo);
	}

	@Override
	public void deletePhysical(PhysicalVO vo) {
		physicalDAO.deletePhysical(vo);
	}

	@Override
	public PhysicalVO getPhysical(PhysicalVO vo) {
		return physicalDAO.getPhysical(vo);
	}

	@Override
	public List<PhysicalVO> getPhysicalList(PhysicalVO vo) {
		return physicalDAO.getPhysicalList(vo);
	}
	
}
