package com.information.biz.physical;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PhysicalServiceClient {
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
				AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
				
				// 2. Spring 컨테이너로부터 BoardServiceImpl 객체를 Lookup 한다.
				PhysicalService physicalService = (PhysicalService) container.getBean("physicalService");

				// 글 추가
				PhysicalVO vo = new PhysicalVO();
				vo.setName1("아이린");
				vo.setWeight("200");
				vo.setHeight("30");
				vo.setBlood("AB");
				vo.setGender("여자");
				physicalService.insertPhysical(vo);
				
				// 글 수정
				/*PhysicalVO vo = new PhysicalVO();
				vo.setWeight("180");
				vo.setSeq(4);
				physicalService.updatePhysical(vo);*/
				
				// 글 삭제
				/*PhysicalVO vo = new PhysicalVO();
				vo.setSeq(5);
				physicalService.deletePhysical(vo);*/
				
				List<PhysicalVO> physicalList = physicalService.getPhysicalList(vo);
				for (PhysicalVO physical : physicalList) {
					System.out.println("---> " + physical.toString());
				}
				
				// 5. Spring 컨테이너 종료  
				container.close();
		
	}
}
