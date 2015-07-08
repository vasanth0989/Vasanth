package com.flowlogger.pojo;

import java.util.List;

public class ActionState extends State {
	
	private List<ActionExecutor> actionExecutors;
	
	public List<ActionExecutor> getActionExecutors() {
		return actionExecutors;
	}
	public void setActionExecutors(List<ActionExecutor> actionExecutors) {
		this.actionExecutors = actionExecutors;
	}

}
