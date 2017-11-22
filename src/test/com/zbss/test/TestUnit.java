package com.zbss.test;

import com.zbss.service.ServiceOne;
import com.zbss.service.ServiceTwo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @desc 
 * @author zbss
 * @date 2017/11/22 17:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring.xml")
public class TestUnit {

	@Autowired
	private ServiceOne serviceOne;

	@Autowired
	private ServiceTwo serviceTwo;

	@Test
	public void test00(){
		serviceOne.serviceOneOnly("test");
	}

	@Test
	public void test01(){
		serviceTwo.serviceTwoOnly("test");
	}

	@Test
	public void test03(){
		serviceOne.serviceOneCallServiceTwo("test");
	}

}
