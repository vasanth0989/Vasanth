package com.flowlogger.flowchart;

public class NodeDataArray
{
    private String text;

    private String category;

    private String loc;

    private int key;

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getCategory ()
    {
        return category;
    }

    public void setCategory (String category)
    {
        this.category = category;
    }

    public String getLoc ()
    {
        return loc;
    }

    public void setLoc (String loc)
    {
        this.loc = loc;
    }

    

    public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	@Override
    public String toString()
    {
        return "ClassPojo [text = "+text+", category = "+category+", loc = "+loc+", key = "+key+"]";
    }
}
