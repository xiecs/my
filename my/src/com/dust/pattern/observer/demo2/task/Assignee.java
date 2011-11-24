package com.dust.pattern.observer.demo2.task;

import com.dust.pattern.observer.demo2.TaskObserver;

public class Assignee extends TaskObserver {

	@Override
	public void sendEmail() {
		print("[Assignee] The current status is : <" + this._status + ">.");
		print("[Assignee] The current process is : <" + this._process + ">.");
		print("[Assignee] The current checklist is : <" + this._checkList + ">.");
	}

	public String toString() {
		return "Assignee";
	}

}
