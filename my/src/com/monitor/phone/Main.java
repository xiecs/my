package com.monitor.phone;

import java.util.ArrayList;
import java.util.List;

import com.monitor.Address;
import com.monitor.Scan;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Address> l = new ArrayList<Address>();
		l.add(new Address("211.138.251.205", 6161));
		l.add(new Address("211.138.251.205", 6162));
		l.add(new Address("211.138.251.205", 6163));
		l.add(new Address("211.138.251.205", 6164));
		l.add(new Address("211.138.251.205", 6165));
		l.add(new Address("211.138.251.205", 6166));
		l.add(new Address("211.138.251.205", 6167));
		l.add(new Address("211.138.251.205", 6168));
		l.add(new Address("211.138.251.205", 6169));

		new Scan(l).process();

	}

}
