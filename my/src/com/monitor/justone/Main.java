package com.monitor.justone;

import java.util.ArrayList;
import java.util.List;

import com.monitor.Address;
import com.monitor.Scan;

/**
 * 检测校讯通首页是否正常访问
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
		l.add(new Address("http://211.138.251.204"));
		l.add(new Address("http://www.xxt.gx.chinamobile.com/"));
		l.add(new Address("http://211.138.251.205:8002/"));
		l.add(new Address("http://211.138.251.205:8003/"));
		l.add(new Address("http://211.138.251.205:8004/"));
		l.add(new Address("http://211.138.251.205:8005/"));
		l.add(new Address("http://211.138.251.205:8006/"));
		l.add(new Address("http://211.138.251.205:8007/"));
		l.add(new Address("http://211.138.251.205:8008/"));
		l.add(new Address("http://211.138.251.205:8009/"));
		l.add(new Address("http://211.138.251.205:8010/"));
		l.add(new Address("http://211.138.251.205:8011/"));
		l.add(new Address("http://211.138.251.205:8012/"));
		l.add(new Address("http://211.138.251.205:8013/"));

		new Scan(l).process();

	}

}
