package com.dust.thread;

public class Goods {
	private class Content implements Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}
}