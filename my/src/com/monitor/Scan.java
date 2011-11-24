package com.monitor;

import java.util.List;

public class Scan {

	private List<Address> l;

	public Scan(List<Address> l) {
		this.l = l;
	}

	public void process() {
		//未考虑数据冲突的情况
		for (Address s : l) {
			MonitorThread m = new MonitorThread(s);
			m.start();
		}

		for (Address s : l) {
			CheckThread c = new CheckThread(s);
			c.start();
		}
	}

}
