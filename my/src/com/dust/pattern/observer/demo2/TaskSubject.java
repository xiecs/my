package com.dust.pattern.observer.demo2;

import java.util.ArrayList;
import java.util.List;

//任务主体
public class TaskSubject implements ITask, ISubject {

	// 在这里对观察者列表进行初始化。因为是静态初始化，所以保证在这个运行过程中只有一个实例得到初始化。
	static {
		_observers = new ArrayList<IObserver>();
	}

	public void notifyObserver() {
		// 调用观察者的方法通知并更新观察者信息。
		for (IObserver observer : _observers) {
			observer.remind(this);
		}
	}

	public void registerObserver(IObserver observer) {
		if (_observers.contains(observer)) {
			System.out.println("< " + observer + " > is already registed!");
		}

		// Register an observer
		_observers.add(observer);
		System.out.println("< " + observer + " > is registed successfully!");
	}

	public void removeObserver(IObserver observer) {
		if (!_observers.contains(observer)) {
			System.out.println("< " + observer + " > is never registed!");
		}

		// Remove an observer
		_observers.remove(observer);
		System.out.println("< " + observer + " > is removed successfully!");
	}

	public String getCheckList() {
		return this._checkList;
	}

	public String getProcess() {
		return this._process;
	}

	public String getStatus() {
		return this._status;
	}

	public void setCheckList(String checkList) {
		this._checkList = checkList;
	}

	public void setProcess(String process) {
		this._process = process;
	}

	public void setStatus(String status) {
		this._status = status;
	}

	// 这里将观察者列表定义为一个静态的变量，这样可以保证自始至终只有一个变量列表，便于系统的维护。
	// 这里用到了泛型，这样在对这个列表进行操作的时候，无需再进行类型的转换。
	private static List<IObserver> _observers;
	private String _status;
	private String _process;
	private String _checkList;

}
