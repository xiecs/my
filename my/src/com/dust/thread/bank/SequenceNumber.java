package com.dust.thread.bank;

public class SequenceNumber {

	// 定义匿名子类创建ThreadLocal的变量
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		// 覆盖初始化方法
		public Integer initialValue() {
			return 0;
		}
	};

	private int num = 0;

	// 下一个序列号
	public int getNextNum() {
		return num++;
	}

	// 下一个序列号
	public int getNextNumSync() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}

	private static class TestClient extends Thread {
		private SequenceNumber sn;

		public TestClient(SequenceNumber sn) {
			this.sn = sn;
		}

		// 线程产生序列号
		public void run() {
			for (int i = 0; i < 3; i++) {
				System.out.println("thread[" + Thread.currentThread().getName() + "] sync_sn[" + sn.getNextNumSync()
						+ "]");

				System.out.println("thread[" + Thread.currentThread().getName() + "] sn[" + sn.getNextNum() + "]");
			}
		}
	}

	public static void main(String[] args) {
		SequenceNumber sn = new SequenceNumber();
		// 三个线程产生各自的序列号
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		t1.start();
		t2.start();
		t3.start();
	}
}
