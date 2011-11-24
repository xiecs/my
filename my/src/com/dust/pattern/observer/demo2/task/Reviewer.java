package com.dust.pattern.observer.demo2.task;

import com.dust.pattern.observer.demo2.TaskObserver;

public class Reviewer extends TaskObserver {

	@Override
	public void sendEmail() {
		print("[Reviewer] The current status is : <" + this._status + ">.");
		print("[Reviewer] The current process is : <" + this._process + ">.");
		print("[Reviewer] The current checklist is : <" + this._checkList + ">.");
	}

	public String toString() {
		return "Reviewer";
	}

}
