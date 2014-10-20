package com.saei.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.saei.constants.Constants;
import com.saei.manager.AplicationEng;

public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected String actionError;
	protected boolean hasActionError;
	protected String actionMessage;
	protected boolean hasActionMessage;
	protected String actionSuccess;
	protected boolean hasActionSuccess;
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	protected HttpServletRequest getServletRequest() {
		return this.request;
	}
	
	protected HttpServletResponse getServletResponse() {
		return this.response;
	}

	protected AplicationEng getAplicationEng(){
		return (AplicationEng) ServletActionContext.getServletContext().getAttribute(Constants.ENG_KEY);
	}
	
	@Override
	public void addActionError(String anErrorMessage) {
		if(StringUtils.isNotEmpty(anErrorMessage)){
			this.actionError = anErrorMessage;
			this.hasActionError = true;
			request.setAttribute("actionError", actionError);
			request.setAttribute("hasActionError", hasActionError);
		}
	}

	
	public void addActionSuccess(String anSuccessMessage) {
		if(StringUtils.isNotEmpty(anSuccessMessage)){
			this.actionSuccess = anSuccessMessage;
			this.hasActionSuccess = true;

			request.setAttribute("actionSuccess", actionSuccess);
			request.setAttribute("hasActionSuccess", hasActionSuccess);
		}
	}
	
	@Override
	public void addActionMessage(String aMessage) {
		if(StringUtils.isNotEmpty(aMessage)){
			this.actionMessage = aMessage;
			this.hasActionMessage= true;

			request.setAttribute("actionMessage", actionMessage);
			request.setAttribute("hasActionMessage", hasActionMessage);
		}
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getActionError() {
		return actionError;
	}

	public void setActionError(String actionError) {
		this.actionError = actionError;
	}

	public boolean isHasActionError() {
		return hasActionError;
	}

	public void setHasActionError(boolean hasActionError) {
		this.hasActionError = hasActionError;
	}

	public String getActionMessage() {
		return actionMessage;
	}

	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}

	public boolean isHasActionMessage() {
		return hasActionMessage;
	}

	public void setHasActionMessage(boolean hasActionMessage) {
		this.hasActionMessage = hasActionMessage;
	}

	public String getActionSuccess() {
		return actionSuccess;
	}

	public void setActionSuccess(String actionSuccess) {
		this.actionSuccess = actionSuccess;
	}

	public boolean isHasActionSuccess() {
		return hasActionSuccess;
	}

	public void setHasActionSuccess(boolean hasActionSuccess) {
		this.hasActionSuccess = hasActionSuccess;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	
}
