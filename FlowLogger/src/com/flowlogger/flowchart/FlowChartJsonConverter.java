package com.flowlogger.flowchart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flowlogger.pojo.ActionExecutor;
import com.flowlogger.pojo.Flow;
import com.flowlogger.pojo.State;
import com.flowlogger.pojo.SubflowState;
import com.flowlogger.pojo.ViewState;

public class FlowChartJsonConverter {


	public FlowChartJson convertToFlowChartJsonObject(List<State> flowStateList)
	{
		FlowChartJson flowChartJson =null;
		List<LinkDataArray> linkDataArrayList = null;
		List<NodeDataArray> nodeDataArrayList = null;
		int key=0;
		int locationStart=175;
		int locationEnd=100;
		int count=0;
		NodeDataArray nodeData=null;
		LinkDataArray linkElement=null;
		if(null!=flowStateList && flowStateList.size()>0)
		{
			flowChartJson = new FlowChartJson();
			linkDataArrayList=new ArrayList<LinkDataArray>();
			nodeDataArrayList=new ArrayList<NodeDataArray>();
			flowChartJson.setName("go.GraphLinksModel");
			flowChartJson.setLinkFromPortIdProperty("fromPort");
			flowChartJson.setLinkToPortIdProperty("toPort");

			/*NodeDataArray comentNode = new NodeDataArray();
			comentNode.setCategory("Comment");	
			comentNode.setKey(-13);
			comentNode.setLoc("360 -10");
			comentNode.setText("Flow Logger ;)");
			nodeDataArrayList.add(comentNode);*/
			
			addComments(nodeDataArrayList);

			NodeDataArray startNode = new NodeDataArray();
			startNode.setCategory("Start");
			startNode.setKey(-1);
			startNode.setLoc("175 130");
			startNode.setText("Start");
			nodeDataArrayList.add(startNode);

			LinkDataArray startLink = new LinkDataArray();
			startLink.setFrom(-1);
			startLink.setTo(1);
			startLink.setFromPort("B");
			startLink.setToPort("T");
			startLink.setVisible(false);
			startLink.setText("");
			linkDataArrayList.add(startLink);

			for(State state:flowStateList)
			{
				count=0;
				if(null !=state.getActionExecutors() && state.getActionExecutors().size()>0 )
				{

					for(ActionExecutor actionExecutor:state.getActionExecutors())
					{
						key++;
						count++;
						locationEnd=locationEnd+160;
						nodeData = createNodeDataArray(key, state.getStateCriteria(), locationStart, locationEnd);
						linkElement = createLinkDataArray(key,(key+1), "B","T");
						if(null!=actionExecutor)
						{
							linkElement.setVisible(true);
							linkElement.setText(actionExecutor.getClassName()+"."+actionExecutor.getMethodName());
						}
						else
						{
							linkElement.setVisible(false);
							linkElement.setText("");
						}
						if(state instanceof ViewState)
						{
							nodeData.setText("(Flow)\n"+state.getBelongFlow()+"\n("+state.getStateCriteria()+")\n"+state.getStateName()+"\nView:"+((ViewState)state).getViewDefiniton());
							if(count==state.getActionExecutors().size()&& null!=((ViewState)state).getTransitionReturned() && !(((ViewState)state).getTransitionReturned().equals("")||((ViewState)state).getTransitionReturned().equals("null")) )
							{
								linkElement.setVisible(true);
								linkElement.setText("On "+((ViewState)state).getTransitionReturned());
							}	
						}
						else if(state instanceof SubflowState)
						{
							nodeData.setText("(Flow)\n"+state.getBelongFlow()+"\n("+state.getStateCriteria()+")\n"+state.getStateName()+"\nSubFlow:"+((SubflowState)state).getSubFlowName());
							
						}
						else
						{
							nodeData.setText("(Flow)\n"+state.getBelongFlow()+"\n("+state.getStateCriteria()+")\n"+state.getStateName());
						}
						nodeDataArrayList.add(nodeData);
						linkDataArrayList.add(linkElement);
					}

				}
				else{
					key++;
					locationEnd=locationEnd+160;
					nodeData = createNodeDataArray(key, state.getStateCriteria(), locationStart, locationEnd);
					linkElement = createLinkDataArray(key,(key+1), "B","T");
					if(state instanceof ViewState)
					{
						nodeData.setText("(Flow)\n"+state.getBelongFlow()+"\n("+state.getStateCriteria()+")\n"+state.getStateName()+"\nView:"+((ViewState)state).getViewDefiniton());
						if(null!=((ViewState)state).getTransitionReturned() && !(((ViewState)state).getTransitionReturned().equals("")||((ViewState)state).getTransitionReturned().equals("null")) )
						{
							linkElement.setVisible(true);
							linkElement.setText("On "+((ViewState)state).getTransitionReturned());
						}

					}
					else if(state instanceof SubflowState)
					{
						nodeData.setText("(Flow)\n"+state.getBelongFlow()+"\n("+state.getStateCriteria()+")\n"+state.getStateName()+"\nSubFlow:"+((SubflowState)state).getSubFlowName());
						linkElement.setVisible(false);
						linkElement.setText("");
						
					}
					else
					{
						nodeData.setText("(Flow)\n"+state.getBelongFlow()+"\n("+state.getStateCriteria()+")\n"+state.getStateName());
						linkElement.setVisible(false);
						linkElement.setText("");
					}

					nodeDataArrayList.add(nodeData);
					linkDataArrayList.add(linkElement);
				}
			}

			NodeDataArray endNode = new NodeDataArray();
			endNode.setKey(-2);
			endNode.setCategory("End");
			locationEnd=locationEnd+150;
			endNode.setLoc(Integer.toString(locationStart)+" "+Integer.toString(locationEnd));
			endNode.setText("Enjoy!");
			nodeDataArrayList.add(endNode);

			LinkDataArray endLink = new LinkDataArray();
			endLink.setFrom(key);
			endLink.setTo(-2);
			endLink.setFromPort("B");
			endLink.setToPort("T");
			endLink.setVisible(false);
			endLink.setText("");
			linkDataArrayList.add(endLink);
			flowChartJson.setNodeDataArray(nodeDataArrayList);
			flowChartJson.setLinkDataArray(linkDataArrayList);
		}

		return flowChartJson;
	}

	public NodeDataArray createNodeDataArray(int key,String criteria,int locationStart,int locationEnd)
	{
		NodeDataArray nodeData = new NodeDataArray();
		nodeData.setKey(key);
		nodeData.setCategory(criteria);
		nodeData.setLoc(Integer.toString(locationStart)+" "+Integer.toString(locationEnd));
		return nodeData;
	}

	public LinkDataArray createLinkDataArray(int key,int to,String fromPort,String toPort)
	{
		LinkDataArray linkElement = new LinkDataArray();
		linkElement.setFrom(key);
		linkElement.setTo(to);
		linkElement.setFromPort(fromPort);
		linkElement.setToPort(toPort);
		return linkElement;

	}
	
	public void addComments(List<NodeDataArray> nodeDataArrayList)
	{
		NodeDataArray comentNode = new NodeDataArray();
		comentNode.setCategory("Comment");	
		comentNode.setKey(-13);
		comentNode.setLoc("400 -350");
		comentNode.setText("Flow Logger ;)");
		nodeDataArrayList.add(comentNode);
		
		NodeDataArray actionStateHelper = new NodeDataArray();
		actionStateHelper.setCategory("ActionStateHelper");	
		actionStateHelper.setKey(-14);
		actionStateHelper.setLoc("400 -300");
		actionStateHelper.setText("Action State");
		nodeDataArrayList.add(actionStateHelper);
		
		NodeDataArray decisionStateHelper = new NodeDataArray();
		decisionStateHelper.setCategory("DecisionStateHelper");	
		decisionStateHelper.setKey(-15);
		decisionStateHelper.setLoc("400 -250");
		decisionStateHelper.setText("Decision State");
		nodeDataArrayList.add(decisionStateHelper);
		
		NodeDataArray viewStateHelper = new NodeDataArray();
		viewStateHelper.setCategory("ViewStateHelper");	
		viewStateHelper.setKey(-16);
		viewStateHelper.setLoc("400 -200");
		viewStateHelper.setText("View State");
		nodeDataArrayList.add(viewStateHelper);
		
		NodeDataArray subFlowStateHelper = new NodeDataArray();
		subFlowStateHelper.setCategory("SubflowStateHelper");	
		subFlowStateHelper.setKey(-17);
		subFlowStateHelper.setLoc("400 -150");
		subFlowStateHelper.setText("Subflow State");
		nodeDataArrayList.add(subFlowStateHelper);
		
		NodeDataArray moduleStateHelper = new NodeDataArray();
		moduleStateHelper.setCategory("ModuleStateHelper");	
		moduleStateHelper.setKey(-18);
		moduleStateHelper.setLoc("400 -100");
		moduleStateHelper.setText("Module State");
		nodeDataArrayList.add(moduleStateHelper);
		
		NodeDataArray endStateHelper = new NodeDataArray();
		endStateHelper.setCategory("EndStateHelper");	
		endStateHelper.setKey(-19);
		endStateHelper.setLoc("400 -50");
		endStateHelper.setText("End State");
		nodeDataArrayList.add(endStateHelper);
	}

}
