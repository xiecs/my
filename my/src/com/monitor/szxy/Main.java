package com.monitor.szxy;

import java.util.ArrayList;
import java.util.List;

import com.monitor.Address;
import com.monitor.Scan;

/**
 * 检测数字校园首页是否正常访问
 * 
 * @author xiecs
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Address> l = new ArrayList<Address>();

		l.add(new Address("http://211.138.253.42:9001/xxtbus"));
		l.add(new Address("http://211.138.253.42:9002/xxtbus"));
		l.add(new Address("http://211.138.253.42:9003/xxtbus"));
		l.add(new Address("http://211.138.253.42"));
		l.add(new Address("http://www.xxt.gx.chinamobile.com/szxy"));

		new Scan(l).process();
	}

}
