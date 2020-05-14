package com.sinoframework.web.servlet.argumentResolver;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class ListIntegerArgumentResolver  implements HandlerMethodArgumentResolver{

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		RequestListParam requestParam = parameter.getParameterAnnotation(RequestListParam.class);
		ParameterizedType parameterizedType = (ParameterizedType)parameter.getGenericParameterType();
		if(requestParam!=null
		   &&parameterizedType.getRawType().equals(List.class)
		   &&parameterizedType.getActualTypeArguments()[0].equals(Integer.class))
				return true;
		
		return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		RequestListParam requestParam = parameter.getParameterAnnotation(RequestListParam.class);
		String pmName = this.getIfAbsentName(requestParam, parameter.getParameterName());
		String text = webRequest.getParameter(pmName);
		if(requestParam.required()&&text==null) {
			throw new RuntimeException(String.format("参数 %s required=true", pmName));
		}
		if(StringUtils.isEmpty(text)&&requestParam.defaultValue().equals("")) {
			return null;
		}
		
		if(StringUtils.isEmpty(text)&&!requestParam.defaultValue().equals("")) {
			text = requestParam.defaultValue();
		}
		
		
    	String[] els = text.split(",");
    	List<Integer> list= new ArrayList<Integer>();
    	for (int i = 0; i < els.length; i++) {
			list.add(Integer.valueOf(els[i]));
		}
        return list;
	}
	
	
	private String getIfAbsentName(RequestListParam requestParam ,String defaultName) {
		if(!requestParam.name().equals("")) {
			return requestParam.name();
		}
		if(!requestParam.value().equals("")) {
			return requestParam.value();
		}
		return defaultName;
	}

}
