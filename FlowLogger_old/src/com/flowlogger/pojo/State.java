package com.flowlogger.pojo;

import java.util.List;

public abstract class State {
	
	private String stateCriteria;
	private String stateName;
	private String belongFlow;
	private List<ActionExecutor> actionExecutors;
	private List<Transition> transitions;
	private int order;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public List<ActionExecutor> getActionExecutors() {
		return actionExecutors;
	}

	public void setActionExecutors(List<ActionExecutor> actionExecutors) {
		this.actionExecutors = actionExecutors;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	public String getStateCriteria() {
		return stateCriteria;
	}

	public void setStateCriteria(String stateCriteria) {
		this.stateCriteria = stateCriteria;
	}

	public String getBelongFlow() {
		return belongFlow;
	}

	public void setBelongFlow(String belongFlow) {
		this.belongFlow = belongFlow;
	}
	

}
