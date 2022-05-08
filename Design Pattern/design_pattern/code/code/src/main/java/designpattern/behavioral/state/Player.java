package designpattern.behavioral.state;

public class Player {

	private PlayerLevel level;

	public Player() {
		level = new BeginnerLevel();
		level.showLevelMessage();
	}

	public void upgradeLevel(PlayerLevel level) {
		level.showLevelMessage();
		this.level = level;
	}

	public PlayerLevel getPlayerLevel() {
		return level;
	}

	public void play(int count) {
		run();

		for (int i = 0; i < count; i++) {
			jump();
		}

		turn();
		fly();
	}

	private void fly() {
		level.fly();
	}

	private void turn() {
		level.turn();
	}

	private void jump() {
		level.jump();
	}

	private void run() {
		level.run();
	}

}
