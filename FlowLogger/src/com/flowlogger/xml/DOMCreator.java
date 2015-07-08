package com.flowlogger.xml;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class DOMCreator {

	/*@SuppressWarnings("unused")
	private static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";
	
	Document document=null;

	public DOMCreator() {
		
	}
	
	
	public Document createDocument()
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=null;
		try {
			builder = factory.newDocumentBuilder();
			document=builder.newDocument();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
	}

	public Document createXMLDoc(String[] strArray) throws ParserConfigurationException {

		
		Element root = doc.createElement("customers");
		doc.appendChild(root);
		
		for (Customer customer : data) {
			Element custElement = addElement(root, "customer", "");
			String idAsString = Integer.toString(customer.getId());
			custElement.setAttribute(Customer.ID, idAsString);
			
			addElement(custElement, Customer.NAME, customer.getName());
			addElement(custElement, Customer.PHONE, customer.getPhone());
			addElement(custElement, Customer.AGE, Integer.toString(customer.getAge()));
			addElement(custElement, Customer.BALANCE, customer.getBalance().toString());
			addElement(custElement, Customer.ACTIVE, Boolean.toString(customer.getActive()));
			
			Element about = addElement(custElement, Customer.ABOUT, "");
			CDATASection cdata = doc.createCDATASection(customer.getAbout());
			about.appendChild(cdata);
			
			DateFormat df = new SimpleDateFormat(XMLDATEFORMAT);
			addElement(custElement, Customer.JOINED, df.format(customer.getJoined()));
			
		}
		
		return doc;
	}
	
	private Element addElement(Element parent, String elementName, String textValue) {
		Element childElement = doc.createElement(elementName);
		childElement.setTextContent(textValue);
		parent.appendChild(childElement);
		return childElement;
	}*/

}
