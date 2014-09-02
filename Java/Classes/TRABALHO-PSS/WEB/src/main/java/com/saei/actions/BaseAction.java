package com.saei.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.saei.constants.Constants;
import com.saei.manager.AplicationEng;

public class BaseAction extends ActionSupport implements ServletRequestAware{
	
	protected HttpServletRequest request;
	
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	protected HttpServletRequest getServletRequest() {
		return this.request;
	}

	protected AplicationEng getAplicationEng(){
		return (AplicationEng) ServletActionContext.getServletContext().getAttribute(Constants.ENG_KEY);
	}
}
