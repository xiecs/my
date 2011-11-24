package com.dust.pattern.observer.demo2;

import com.dust.pattern.observer.demo2.task.Assignee;
import com.dust.pattern.observer.demo2.task.Reporter;
import com.dust.pattern.observer.demo2.task.Reviewer;

//观察者模式定义了一个一对多的对象关系：一个主体对象对应多个观察者对象。
//当主体对象发生改变时，所有它对应的观察者对象都会自动得到通知并更新。
public class TaskManager {

	public static void main(String[] args) {
		// Create subject
		TaskSubject taskSubject = new TaskSubject();

		// Create observers
		IObserver assignee = new Assignee();
		IObserver reviewer = new Reviewer();
		IObserver reporter = new Reporter();

		// 注册观察者[因为我们使用的是一个列表，所以在通知观察者的时候是按照添加的顺序通知的]
		taskSubject.registerObserver(assignee);
		taskSubject.registerObserver(reviewer);
		taskSubject.registerObserver(reporter);

		// 更新主体对象的信息
		taskSubject.setStatus("Assigned");
		taskSubject.setProcess("No Process Attacted");
		taskSubject.setCheckList("CheckList Version 1.0");

		// 通知所有观察者
		taskSubject.notifyObserver();

		// 更新主体对象信息
		taskSubject.setStatus("In Progress");
		taskSubject.setProcess("Process Attached");
		taskSubject.setCheckList("CheckList Version Final Version");

		// 取消报告者的注册，并通知剩余所有观察者
		taskSubject.removeObserver(reporter);
		taskSubject.notifyObserver();
	}
}
