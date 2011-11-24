package com.dust.pattern.observer.demo2;

/**
 * 这里定义了一个任务应该具有的功能。
 */
public interface ITask {

	public void setStatus(String status);

	public String getStatus();

	public void setProcess(String process);

	public String getProcess();

	public void setCheckList(String checkList);

	public String getCheckList();
}