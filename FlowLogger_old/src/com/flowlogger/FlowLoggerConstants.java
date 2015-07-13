package com.flowlogger;

public final class FlowLoggerConstants {
	
	public static String REGEX_ENTERING_STATE="(^.*(\\wState).*\\bEntering state\\b.*)";
	public static String REGEX_EXITIN_STATE="^.*(\\bExiting state\\b).*";
	public static String REGEX_ACTION_EXECUTOR="ActionExecutor.*(\\bFinished executing\\b).*(\\W\\bEvaluateAction\\b).*";
	public static String REGEX_VIEW_DEF="^.*(\\bViewState\\b).*(\\bRendering\\b).*(\\WServletMvcView).*";
	public static String REGEX_SUBFLOW_NAME="^.*(\\bSubflowState\\b).*(\\bCalling subflow\\b).*";
	public static String REGEX_TRANSITION_ON="^.*(\\bTransition\\b).*(\\bExecuting\\b\\s\\WTransition).*";
	
}
