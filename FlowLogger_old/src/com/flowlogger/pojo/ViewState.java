package com.flowlogger.pojo;

import java.util.List;

public class ViewState extends State {
	
	private String viewDefiniton;
	private String transitionReturned;
	
	public String getTransitionReturned() {
		return transitionReturned;
	}

	public void setTransitionReturned(String transitionReturned) {
		this.transitionReturned = transitionReturned;
	}

	public String getViewDefiniton() {
		return viewDefiniton;
	}

	public void setViewDefiniton(String viewDefiniton) {
		this.viewDefiniton = viewDefiniton;
	}


}
