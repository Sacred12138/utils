package com.example.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SpringbootAopUtils {

	/**
	 * 	获取request
	 * @param joinPoint
	 * @return
	 */
	public static HttpServletRequest getRequest(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attributes.getRequest();
	}
	
	/**
	   *   获取response
	 * @param joinPoint
	 * @return
	 */
	public static HttpServletResponse getResponse(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attributes.getResponse();
	}
	
	/**
	    * 获取Class名
	 * @param joinPoint
	 * @return
	 */
	public static String getClassName(JoinPoint joinPoint) {
		return joinPoint.getSignature().getDeclaringTypeName();
	}
	
	/**
	 * 获取方法名
	 * @param joinPoint
	 * @return
	 */
	public static String getCutMehod(JoinPoint joinPoint) {
		return joinPoint.getSignature().getName();
	}
	
	/**
	 * 获取方法参数
	 * @param joinPoint
	 * @return
	 */
	public static Object[] getParamsValue(JoinPoint joinPoint) {
		return joinPoint.getArgs();
	}
	
	/**
	 * 获取代理对象
	 * @param joinPoint
	 * @return
	 */
	public static Object getClass(JoinPoint joinPoint) {
		return joinPoint.getTarget();
	}
	
	/**
	 * 获取session
	 * @param joinPoint
	 * @return
	 */
	public static HttpSession getSession(JoinPoint joinPoint) {
		return getRequest(joinPoint).getSession();
	}
	
	/**
	 * 获取GET请求参数
	 * @param joinPoint
	 * @return
	 */
	public static Map<String, String> getParameterNames(JoinPoint joinPoint) {
		HttpServletRequest request = getRequest(joinPoint);
		Enumeration<String> enumeration = request.getParameterNames();  
		if(enumeration == null) {
			return null;
		}
		Map<String,String> map = new HashMap<String, String>();
		while (enumeration.hasMoreElements()){  
	        String parameter = enumeration.nextElement();  
	        map.put(parameter,request.getParameter(parameter));  
	    } 
		return map;
	}
}
