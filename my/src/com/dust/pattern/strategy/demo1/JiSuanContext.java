package com.dust.pattern.strategy.demo1;

public class JiSuanContext {

	private SuanFa suanFa;

	public JiSuanContext(SuanFa suanFa) {
		this.suanFa = suanFa;
	}

	// 具体的调用
	public String getResult() {
		return suanFa.exec();

	}

	public SuanFa getSuanFa() {
		return suanFa;
	}

	public void setSuanFa(SuanFa suanFa) {
		this.suanFa = suanFa;
	}

}
