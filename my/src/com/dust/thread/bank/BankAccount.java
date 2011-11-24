package com.dust.thread.bank;

public class BankAccount {

	// 交易金额
	private int number;
	// 账户总额
	private int balance;

	public BankAccount(int number, int balance) {
		this.number = number;
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public int getNumber() {
		return number;
	}

	// 使用synchronized同步

	// 存钱
	public void deposit(int amount) {
		balance = balance + amount;

		// 同步锁
		// synchronized (this) {
		// balance = balance + amount;
		// }
	}

	// 取钱
	public void withdraw(int amount) {
		balance = balance - amount;

		// 同步锁
		// synchronized (this) {
		// balance = balance - amount;
		// }
	}

	public static void main(String[] args) throws InterruptedException {
		BankAccount a = new BankAccount(1, 1000);
		Thread t1 = new Thread(new Depositor(a, 100));
		Thread t2 = new Thread(new Withdrawer(a, 100));
		t1.start();
		t2.start();

		// 加join有什么区别？？
		t1.join();
		t2.join();
		System.out.println(a.getBalance());
	}
}

// 存钱
class Depositor implements Runnable {
	BankAccount account;
	int amount;

	public Depositor(BankAccount account, int amount) {
		this.account = account;
		this.amount = amount;
	}

	public void run() {
		for (int i = 0; i < 100000; i++)
			account.deposit(amount);
	}
}

// 取钱
class Withdrawer implements Runnable {
	BankAccount account;
	int amount;

	public Withdrawer(BankAccount account, int amount) {
		this.account = account;
		this.amount = amount;
	}

	public void run() {
		for (int i = 0; i < 100000; i++)
			account.withdraw(amount);
	}
}
