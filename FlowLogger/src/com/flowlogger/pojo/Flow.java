package com.flowlogger.pojo;

import java.util.List;

public class Flow {
	
	private String flowName;
	private List<State> flowSates;
	
	public String getFlowName() {
		return flowName;
	}
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	public List<State> getFlowSates() {
		return flowSates;
	}
	public void setFlowSates(List<State> flowSates) {
		this.flowSates = flowSates;
	}
	
	

}
