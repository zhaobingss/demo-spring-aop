package com.zbss.aop;

import com.zbss.aop.annotation.ServiceOneAnnotation;
import com.zbss.aop.annotation.ServiceTwoAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @desc 
 * @author zbss
 * @date 2017/11/22 17:22
 */

@Aspect
@Component
public class ServiceLogAspect {

	private Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);

	@Around("execution(* com.zbss.service.*.*(..)) && @annotation(sla)")
	public Object logOne(ProceedingJoinPoint jp, ServiceOneAnnotation sla){
		String req = "";
		String rsp = "";
		String type = sla.value();
		Object[] args = jp.getArgs();
		if (args.length > 0){
			req = String.valueOf(args[0]);
		}

		Object ret = null;
		try {
			ret = jp.proceed(args);
		} catch (Throwable throwable) {
			logger.error("执行方法"+type+"异常："+ throwable.getMessage());
		}
		rsp = String.valueOf(ret);

		logger.info("----------------"+type+"----------------\nreq:\t"+req+"\nrsp:\t"+rsp);

		return ret;
	}

	@Around("execution(* com.zbss.service.*.*(..)) && @annotation(sla)")
	public Object logTwo(ProceedingJoinPoint jp, ServiceTwoAnnotation sla){
		String req = "";
		String rsp = "";
		String type = sla.value();
		Object[] args = jp.getArgs();
		if (args.length > 0){
			req = String.valueOf(args[0]);
		}

		Object ret = null;
		try {
			ret = jp.proceed(args);
		} catch (Throwable throwable) {
			logger.error("执行方法"+type+"异常："+ throwable.getMessage());
		}
		rsp = String.valueOf(ret);

		logger.info("----------------"+type+"----------------\nreq:\t"+req+"\nrsp:\t"+rsp);

		return ret;
	}

}
