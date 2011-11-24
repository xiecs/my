package com.dust.thread.local;

import java.util.Calendar;

public class Var {

	private static int traceSqc = 1;

	// Java语言规范中指出：为了获得最佳速度，允许线程保存共享成员变量的私有拷贝，
	// 而且只当线程进入或者离开同步代码块时才与共享成员变量的原始值对比。
	// 而volatile关键字就是提示VM：对于这个成员变量不能保存它的私有拷贝，而应直接与共享成员变量交互。

	// volatile关键字无法防止多线程重复读变量值
	// public volatile static int traceSqc = 1;

	// 因此volatile只是在线程内存和“主”内存间同步某个变量的值，而synchronized通过锁定和解锁某个监视器同步所有变量的值。
	// 显然synchronized要比volatile消耗更多资源。

	// synchronized也就是给方法上锁，同一时间，只能有一个线程能访问。
	public synchronized static String getTraceId() {
		Calendar date = Calendar.getInstance();
		int year = (date.get(Calendar.YEAR) % 2000) % 15;
		int month = date.get(Calendar.MONTH) + 1;
		int day = date.get(Calendar.DAY_OF_MONTH);
		int hour = date.get(Calendar.HOUR_OF_DAY);
		int min = date.get(Calendar.MINUTE);
		int sec = date.get(Calendar.SECOND);
		String days = String.valueOf(year * 600 + month * 40 + day);
		String hours = String.valueOf(hour);
		if (hour < 10) {
			hours = "0" + hours;
		}
		String mins = String.valueOf(min);
		if (min < 10) {
			mins = "0" + mins;
		}
		String secs = String.valueOf(sec);
		if (sec < 10) {
			secs = "0" + secs;
		}

		int sqc = traceSqc;
		String sqcs = String.valueOf(sqc);
		if (sqc < 10) {
			sqcs = "0" + sqcs;
		}
		traceSqc++;
		if (traceSqc > 99) {
			traceSqc = 1;
		}

		String traceId = days + hours + mins + secs + sqcs;

		return traceId;
	}

}
