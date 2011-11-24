package com.dust.innerclass;

interface Selector {
	boolean end();
	Object current();
	void next();
}

//简单的list集合
public class Sequence {
	private Object[] items;
	private int next = 0;

	public Sequence(int size) {
		items = new Object[size];
	}

	public void add(Object x) {
		if (next < items.length) {
			items[next++] = x;// next用了在加
		}
	}
	
	public int size(){
		return items.length;
	}

	private class SequenceSelctor implements Selector {

		private int i = 0;

		public boolean end() {
			return i == items.length;
		}

		public Object current() {
			return items[i];
		}

		public void next() {
			if (i < items.length)
				i++;
		}
	}

	public Selector selector() {
		return new SequenceSelctor();
	}

	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for (int i = 0; i < 10; i++) {
			sequence.add(i);
		}
		
		System.out.println(sequence.size());
		
		Selector selector = sequence.selector();
		while (!selector.end()) {
			System.out.println(selector.current());
			selector.next();
		}

	}

}
