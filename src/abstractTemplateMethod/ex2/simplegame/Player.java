package abstractTemplateMethod.ex2.simplegame;

public class Player {

	private PlayerLevel level;
	
	public Player() {
		level = new BeginnerLevel();
		level.showLevelMessage();
	}

	public void play(int count) {
		level.go(count);
	}
	
	public void levelUp(PlayerLevel level) {
		this.level = level;
		level.showLevelMessage();
	}
	
}
