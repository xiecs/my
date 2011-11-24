package com.dust.pattern.observer.demo2.task;

import com.dust.pattern.observer.demo2.TaskObserver;

public class Reporter extends TaskObserver {

	@Override
	public void sendEmail() {
		print("[Reporter] The current status is : <" + this._status + ">.");
		print("[Reporter] The current process is : <" + this._process + ">.");
		print("[Reporter] The current checklist is : <" + this._checkList + ">.");
	}

	public String toString() {
		return "Reporter";
	}

}
