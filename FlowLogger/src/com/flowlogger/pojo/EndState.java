package com.flowlogger.pojo;

import java.util.List;

public class EndState extends State {
	
	private List<Transition> transitions;

	public List<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}
	
	

}
