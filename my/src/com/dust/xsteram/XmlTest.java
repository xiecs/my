package com.dust.xsteram;

import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;

public class XmlTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Child child=new Child();
		child.setChild1("aaa");
		
		XmlData xml=new XmlData();
		xml.setName("xml");
		xml.setNaMe("aaa");
		
		ArrayList<Child> list=new ArrayList<Child>();
		
		xml.setList(list);
		list.add(child);
		
		XStream x=new XStream();		
		x.processAnnotations(XmlData.class);
		String str=x.toXML(xml);
		
		
		System.out.println(str);

	}

}
