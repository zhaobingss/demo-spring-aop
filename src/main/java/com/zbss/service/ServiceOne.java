package com.zbss.service;

import com.zbss.aop.annotation.ServiceOneAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @desc 
 * @author zbss
 * @date 2017/11/22 17:16
 */
@Service("serviceOne")
public class ServiceOne {

	@Autowired
	private ServiceTwo serviceTwo;

	@ServiceOneAnnotation("serviceOneCallServiceTwo")
	public String serviceOneCallServiceTwo(String string){
		return serviceTwo.serviceTwoOnly(string);
	}

	@ServiceOneAnnotation("serviceOneOnly")
	public String serviceOneOnly(String string){
		return "one:"+string;
	}
}
