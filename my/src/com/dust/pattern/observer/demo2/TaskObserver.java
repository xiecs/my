package com.dust.pattern.observer.demo2;

public abstract class TaskObserver implements IObserver {

	public void remind(ITask taskSubject) {
		this._status = taskSubject.getStatus();
		this._process = taskSubject.getProcess();
		this._checkList = taskSubject.getCheckList();

		// 更新观察者对象
		this.sendEmail();
	}

	public abstract void sendEmail();

	// 工具类方法，减少编码数量，增加可读性。
	public void print(String msg) {
		System.out.println(msg);
	}

	// 在父类中定义参数，减少重复编码。
	protected String _status;
	protected String _process;
	protected String _checkList;

}
