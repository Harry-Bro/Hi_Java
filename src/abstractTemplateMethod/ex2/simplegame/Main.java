package abstractTemplateMethod.ex2.simplegame;

public class Main {

	public static void main(String[] args) {
		
		Player p1 = new Player();
		
		p1.play(2);
		p1.levelUp(new AdvancedLevel());
		p1.play(1);
		p1.levelUp(new SuperLevel());
		p1.play(1);
	}
	
}
