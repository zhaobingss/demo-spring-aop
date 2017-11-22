package com.zbss.service;

import com.zbss.aop.annotation.ServiceTwoAnnotation;
import org.springframework.stereotype.Service;

/**
 * @desc 
 * @author zbss
 * @date 2017/11/22 17:17
 */
@Service("serviceTwo")
public class ServiceTwo {

	@ServiceTwoAnnotation("serviceTwoOnly")
	public String serviceTwoOnly(String string){
		return "two:" + string;
	}

}
