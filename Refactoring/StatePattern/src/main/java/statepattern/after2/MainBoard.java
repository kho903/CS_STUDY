package statepattern.after2;

public class MainBoard {
	public static void main(String[] args) {
		Player player = new Player();
		player.play(1);
		PlayerLevel advancedLevel = AdvancedLevel.getInstance();
		player.upgradeLevel(advancedLevel);
		player.play(2);
		PlayerLevel superLevel = SuperLevel.getInstance();
		player.upgradeLevel(superLevel);
		player.play(3);
	}
}
