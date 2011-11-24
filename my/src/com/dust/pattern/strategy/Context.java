package com.dust.pattern.strategy;

public class Context {

	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	//策略方法，可替换
	public void contextInterface() {
		strategy.strategyInfterface();
	}

}
