package com.flowlogger.flowchart;


import java.util.List;

public class FlowChartJson
{
    private String linkToPortIdProperty;

    private List<NodeDataArray> nodeDataArray;

    private String linkFromPortIdProperty;

    private String name;

	private List<LinkDataArray> linkDataArray;

    public String getLinkToPortIdProperty ()
    {
        return linkToPortIdProperty;
    }

    public void setLinkToPortIdProperty (String linkToPortIdProperty)
    {
        this.linkToPortIdProperty = linkToPortIdProperty;
    }

    public List<NodeDataArray> getNodeDataArray() {
		return nodeDataArray;
	}

	public void setNodeDataArray(List<NodeDataArray> nodeDataArray) {
		this.nodeDataArray = nodeDataArray;
	}

	public String getLinkFromPortIdProperty ()
    {
        return linkFromPortIdProperty;
    }

    public void setLinkFromPortIdProperty (String linkFromPortIdProperty)
    {
        this.linkFromPortIdProperty = linkFromPortIdProperty;
    }

    
    
    public List<LinkDataArray> getLinkDataArray() {
		return linkDataArray;
	}

	public void setLinkDataArray(List<LinkDataArray> linkDataArray) {
		this.linkDataArray = linkDataArray;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "FlowChartJson [linkToPortIdProperty=" + linkToPortIdProperty
				+ ", nodeDataArray=" + nodeDataArray
				+ ", linkFromPortIdProperty=" + linkFromPortIdProperty
				+ ", name=" + name + ", linkDataArray=" + linkDataArray + "]";
	}

	

   
}