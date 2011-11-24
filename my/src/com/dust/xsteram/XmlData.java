package com.dust.xsteram;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("data")
public class XmlData {

	@XStreamAlias("type")
	@XStreamAsAttribute
	private int messageType = 0;

	@XStreamAlias("nAme")
	private String name;

	@XStreamAlias("naMe")
	private String naMe;

	private List<Child> list;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Child> getList() {
		return list;
	}

	public void setList(List<Child> list) {
		this.list = list;
	}

	public String getNaMe() {
		return naMe;
	}

	public void setNaMe(String naMe) {
		this.naMe = naMe;
	}

}
