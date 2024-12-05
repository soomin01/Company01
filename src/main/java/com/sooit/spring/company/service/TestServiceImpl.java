package com.sooit.spring.company.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sooit.spring.company.dto.TestDto;
import com.sooit.spring.company.mapper.TestMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class TestServiceImpl implements TestService {
	@Setter(onMethod_= @Autowired)
	private TestMapper mapper;
	
	@Override
	public String getOne() {
		log.info("test==========");
		TestDto tvo = mapper.getData1();
		String one = tvo.getStr_data();
		return one;
	}
	
	@Override
	public String getTwo() {
		log.info("test==========");
		TestDto tvo = mapper.getData2();
		String two = tvo.getStr_data();
		return two;
	}
}
