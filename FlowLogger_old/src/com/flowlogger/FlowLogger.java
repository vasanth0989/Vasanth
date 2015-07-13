package com.flowlogger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.flowlogger.pojo.ActionExecutor;
import com.flowlogger.pojo.ActionState;
import com.flowlogger.pojo.Flow;
import com.flowlogger.pojo.State;
import com.flowlogger.pojo.SubflowState;
import com.flowlogger.pojo.ViewState;

public class FlowLogger {

	private Set<HashMap<String,Flow>> flowSet = new HashSet<HashMap<String,Flow>>();
	private Map<String,Flow> flowNameMap = new LinkedHashMap<String, Flow>();
	private List<State> orderdStateList = new ArrayList<State>();
	private int order=0;


	public static void main(String[] args) {
		FlowLogger flowLogger = new FlowLogger();
		flowLogger.creatFlowXML("E:\\Workarea\\FlowLogger\\ca-logs.txt");
		flowLogger.orderFlow();
		System.out.println("Completed...");

	}


	public void creatFlowXML(String filePath)
	{
		Pattern pattern = null;
		Matcher matcher = null;
		BufferedReader bufferedReader = null;
		String [] stringSplit=null;
		String flowName=null;
		String state=null;
		String stateName=null;
		List<State> flowStateList=null;
		List<ActionExecutor> actionExecutorList=null;
		Flow flow=null;
		State stateObj=null;
		ActionState actionState=null;
		String className=null;
		String methodName=null;
		String result=null;
		String helper=null;
		try
		{
			bufferedReader=new BufferedReader(new FileReader(new File(filePath)));
			String line;
			while((line=bufferedReader.readLine())!=null)
			{

				pattern=Pattern.compile(FlowLoggerConstants.REGEX_ENTERING_STATE);
				matcher = pattern.matcher(line);
				if(matcher.find())
				{
					//					System.out.println(line);
					stringSplit=line.split(" ");
					flowName=stringSplit[9].replace("'", "");
					if(null!=stringSplit && stringSplit.length>0)
					{

						flow= flowNameMap.get(flowName);			
						if(flow==null)
						{
							flow=new Flow();
							flow.setFlowName(flowName);
							flow.setFlowSates(new ArrayList<State>());
							flowNameMap.put(flowName,flow);
						}
						state=stringSplit[2];
						stateName=stringSplit[6].replace("'","");
						stateObj = getStateByName(state);
						stateObj.setStateCriteria(state);
						stateObj.setStateName(stateName);
						stateObj.setBelongFlow(flowName);
						stateObj.setOrder(order++);
						flow.getFlowSates().add(stateObj);
						orderdStateList.add(stateObj);
					}
				}

				pattern = Pattern.compile(FlowLoggerConstants.REGEX_ACTION_EXECUTOR);
				matcher = pattern.matcher(line);
				if(matcher.find())
				{
					if(stateObj!=null) 
					{
						if(stateObj.getActionExecutors()==null)
						{
							stateObj.setActionExecutors(new ArrayList<ActionExecutor>());
						}
						try
						{
							stringSplit = (line.substring(line.indexOf("=")+2,line.indexOf("resultExpression")-2)).split("\\.",2);
							className=stringSplit[0];
							methodName=stringSplit[1];
						}
						catch(StringIndexOutOfBoundsException ae)
						{
							System.out.println("Exception Caught");
							System.out.println("it is:"+line);
							System.exit(0);
						}
						result=line.substring(line.indexOf("result ")+9,line.length());		
						ActionExecutor actionExecutor = new ActionExecutor();
						actionExecutor.setClassName(className);
						actionExecutor.setMethodName(methodName);
						actionExecutor.setResult(result);
						stateObj.getActionExecutors().add(actionExecutor);
					}
				}
				
				if(stateObj!=null)
				{
					if(stateObj instanceof ViewState)
					{
						pattern = Pattern.compile(FlowLoggerConstants.REGEX_VIEW_DEF);
						matcher = pattern.matcher(line);
						if(matcher.find())
						{					
							((ViewState) stateObj).setViewDefiniton(line.substring(line.indexOf("name")+6,line.indexOf(";")-1));
						}
						
						pattern = Pattern.compile(FlowLoggerConstants.REGEX_TRANSITION_ON);
						matcher = pattern.matcher(line);
						
						if(matcher.find())
						{
							((ViewState) stateObj).setTransitionReturned(line.substring(line.indexOf("on =")+5,line.indexOf(", to")));
						}
					}
					
					if(stateObj instanceof SubflowState)
					{
						pattern = Pattern.compile(FlowLoggerConstants.REGEX_SUBFLOW_NAME);
						matcher = pattern.matcher(line);
						if(matcher.find())
						{					
							((SubflowState) stateObj).setSubFlowName(line.substring(line.indexOf("subflow")+9,line.indexOf("' with")));
						}
					}
					
				}
				
				

			}

			/*for(Map.Entry<String, Flow> flowEntries:flowNameMap.entrySet())
			{

				System.out.println("Flow Name:"+flowEntries.getKey());
				Flow flows=flowEntries.getValue();
				for(State stat:flows.getFlowSates())
				{
					System.out.println(stat.getStateCriteria());
					System.out.println(stat.getStateName());
					if(stat instanceof ViewState)
					{
						System.out.println("View Definiton:"+((ViewState) stat).getViewDefiniton());
						System.out.println("#Transition Returned:"+((ViewState) stat).getTransitionReturned());
					}
					if(stat instanceof SubflowState)
					{
						System.out.println("*SubFlow Name:"+((SubflowState)stat).getSubFlowName());
					}
					System.out.println("Order:.."+stat.getOrder());
					if(null !=stat.getActionExecutors())
					{
						for(ActionExecutor actionExecut:stat.getActionExecutors())
						{
							System.out.println(actionExecut.getClassName());
							System.out.println(actionExecut.getMethodName());
							System.out.println(actionExecut.getResult());
						}
					}
				}

				System.out.println("End of Flow.............................");

			}*/

		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		finally
		{
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private State getStateByName(String stateName)
	{
		State state=null;
		try {
			Class<?> clazz = Class.forName("com.flowlogger.pojo."+stateName);
			state = (State) clazz.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return state;
	}
	
	
	public void orderFlow()
	{
		for(State stat:orderdStateList)
		{
			System.out.println("Flow Name:"+stat.getBelongFlow());
			System.out.println(stat.getStateCriteria());
			System.out.println(stat.getStateName());
			if(stat instanceof ViewState)
			{
				System.out.println("View Definiton:"+((ViewState) stat).getViewDefiniton());
				System.out.println("#Transition Returned:"+((ViewState) stat).getTransitionReturned());
			}
			if(stat instanceof SubflowState)
			{
				System.out.println("*SubFlow Name:"+((SubflowState)stat).getSubFlowName());
			}
			System.out.println("Order:.."+stat.getOrder());
			if(null !=stat.getActionExecutors())
			{
				for(ActionExecutor actionExecut:stat.getActionExecutors())
				{
					System.out.println(actionExecut.getClassName());
					System.out.println(actionExecut.getMethodName());
					System.out.println(actionExecut.getResult());
				}
			}
			
			System.out.println("End of State****");
		}
	}




}
