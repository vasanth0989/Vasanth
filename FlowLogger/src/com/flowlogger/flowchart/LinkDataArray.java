package com.flowlogger.flowchart;

public class LinkDataArray
{
    private int to;

    private String text;

    private boolean visible;

    private String fromPort;

    private int from;

    private String toPort;



    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getFromPort ()
    {
        return fromPort;
    }

    public void setFromPort (String fromPort)
    {
        this.fromPort = fromPort;
    }

   
    public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public String getToPort ()
    {
        return toPort;
    }

    public void setToPort (String toPort)
    {
        this.toPort = toPort;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [to = "+to+", text = "+text+", visible = "+visible+", fromPort = "+fromPort+", from = "+from+", toPort = "+toPort+"]";
    }
}
