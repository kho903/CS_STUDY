package designpattern.behavioral.strategy.scheduler;

public interface Scheduler {

	public void getNextCall();
	public void sendCallToAgent();
}
