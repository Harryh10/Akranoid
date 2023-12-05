//HARRY_PEREZ_PEREA_0222220035

package elements;

import Game.Game;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Board {
    
        private static final int Y = 560;
	private static final int WIDTH = 110;
	private static final int HEIGHT = 25;
	public int x = 230;
	int xa;
	public Game game;

	public Board(Game game) {
		this.game = game;
	}
        
        public void move() {

		if (x + xa > 0 && x + xa < game.getWidth() - WIDTH) {

			x = x + xa;
		}
	}
        
        public void paint(Graphics2D g) {
		g.setColor(Color.decode("#181d27"));
		g.fillRect(x, Y, WIDTH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}
        
        public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -game.bspeed;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = game.bspeed;
	}
        
        public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}

	public int getTopY() {
		return Y - HEIGHT + 20;
	}
    
}
