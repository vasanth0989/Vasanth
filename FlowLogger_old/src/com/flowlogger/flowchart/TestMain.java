package com.flowlogger.flowchart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

public class TestMain {

	public static void main(String[] args) {
		
		FlowChartJson flowChartJson = new FlowChartJson();
		flowChartJson.setName("go.GraphLinksModel");
		flowChartJson.setLinkFromPortIdProperty("fromPort");
		flowChartJson.setLinkToPortIdProperty("toPort");
		
		List<LinkDataArray> linkDataArrayList = new ArrayList<LinkDataArray>();
		List<NodeDataArray> nodeDataArrayList = new ArrayList<NodeDataArray>();
		
		
		NodeDataArray nodeDataArray = new NodeDataArray();
		nodeDataArray.setCategory("Comment");	
		nodeDataArray.setKey(-13);
		nodeDataArray.setLoc("360 -10");
		nodeDataArray.setText("Kookie Brittle");
		nodeDataArrayList.add(nodeDataArray);
		
		NodeDataArray nodeDataArray1 = new NodeDataArray();
		nodeDataArray1.setCategory("Start");
		nodeDataArray1.setKey(-1);
		nodeDataArray1.setLoc("175 0");
		nodeDataArray1.setText("Start");
		nodeDataArrayList.add(nodeDataArray1);
		
		NodeDataArray nodeDataArray2 = new NodeDataArray();
		nodeDataArray2.setKey(1);
		nodeDataArray2.setCategory("");
		nodeDataArray2.setLoc("175 100");
		nodeDataArray2.setText("Hello Vasanth");
		nodeDataArrayList.add(nodeDataArray2);
		
		NodeDataArray nodeDataArray3 = new NodeDataArray();
		nodeDataArray3.setKey(2);
		nodeDataArray3.setCategory("");
		nodeDataArray3.setLoc("175 190");
		nodeDataArray3.setText("Gradually beat in 1 cup sugar and 2 cups sifted flour");
		nodeDataArrayList.add(nodeDataArray3);
		
		NodeDataArray nodeDataArray4 = new NodeDataArray();
		nodeDataArray4.setKey(3);
		nodeDataArray4.setCategory("");
		nodeDataArray4.setLoc("175 270");
		nodeDataArray4.setText("Mix in 6 oz (1 cup) Nestle's Semi-Sweet Chocolate Morsels");
		nodeDataArrayList.add(nodeDataArray4);
		
		NodeDataArray nodeDataArray5 = new NodeDataArray();
		nodeDataArray5.setKey(-2);
		nodeDataArray5.setCategory("End");
		nodeDataArray5.setLoc("175 360");
		nodeDataArray5.setText("Enjoy!");
		nodeDataArrayList.add(nodeDataArray5);
		
		flowChartJson.setNodeDataArray(nodeDataArrayList);
		
		LinkDataArray linkDataArray = new LinkDataArray();
		linkDataArray.setFrom(-1);
		linkDataArray.setTo(1);
		linkDataArray.setFromPort("B");
		linkDataArray.setToPort("T");
		linkDataArray.setVisible(true);
		linkDataArray.setText("Next Step");
	    linkDataArrayList.add(linkDataArray);
		
		LinkDataArray linkDataArray1 = new LinkDataArray();
		linkDataArray1.setFrom(1);
		linkDataArray1.setTo(2);
		linkDataArray1.setFromPort("B");
		linkDataArray1.setToPort("T");
		linkDataArray1.setVisible(true);
		linkDataArray1.setText("Next Step");
		linkDataArrayList.add(linkDataArray1);
		
		LinkDataArray linkDataArray2 = new LinkDataArray();
		linkDataArray2.setFrom(2);
		linkDataArray2.setTo(3);
		linkDataArray2.setFromPort("B");
		linkDataArray2.setToPort("T");
		linkDataArray2.setVisible(true);
		linkDataArray2.setText("Next Step");
		linkDataArrayList.add(linkDataArray2);
		
		LinkDataArray linkDataArray3 = new LinkDataArray();
		linkDataArray3.setFrom(3);
		linkDataArray3.setTo(-2);
		linkDataArray3.setFromPort("B");
		linkDataArray3.setToPort("T");
		linkDataArray3.setVisible(true);
		linkDataArray3.setText("Next Step");
		linkDataArrayList.add(linkDataArray3);
		
		flowChartJson.setLinkDataArray(linkDataArrayList);
		
		
		
		/*User user = new User();
		user.setName("Vasanth");
		user.setLastName("Senthamarai Kannan");*/
		ObjectMapper m = new ObjectMapper();
		String jsonData=null;
		
		try {
			jsonData= m.writeValueAsString(flowChartJson);
			System.out.println(jsonData);
			//m.writeValue(new File("E:\\user.json"),flowChartJson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedWriter bufferedWriter=null;
		BufferedReader bufferdReader = null;
		StringBuffer strBuff=new StringBuffer();
		String line;
		
		try
		{
			bufferdReader = new BufferedReader(new FileReader("E:\\Workarea\\FlowLogger\\FlowChart\\flowchart.html"));
			while((line=bufferdReader.readLine())!=null)
			{
				strBuff.append(line);
				strBuff.append("\n");
			}
			
			int textAreaStartIndex=strBuff.indexOf("300px")+7;
			int textAreaEndIndex=strBuff.indexOf("</textarea>");
			
			
			
			String textArea=strBuff.substring(textAreaStartIndex,textAreaEndIndex);
			//System.out.println(textArea);
			
			strBuff.replace(textAreaStartIndex, textAreaEndIndex, jsonData);
			
			bufferedWriter=new BufferedWriter(new FileWriter(new File("E:\\Workarea\\FlowLogger\\FlowChart\\abc.html")));
			bufferedWriter.write(new String(strBuff));
			
		}
		catch(IOException ie)
		{
			
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			try {
				bufferdReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				bufferedWriter.flush();
				bufferedWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		System.out.println("Completed");
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
