package com.flowlogger.pojo;

public class Transition {
	
	private String className;
	private String methodName;
	private String transitionOn;
	private String transitionTo;
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getTransitionOn() {
		return transitionOn;
	}
	public void setTransitionOn(String transitionOn) {
		this.transitionOn = transitionOn;
	}
	public String getTransitionTo() {
		return transitionTo;
	}
	public void setTransitionTo(String transitionTo) {
		this.transitionTo = transitionTo;
	}


}
