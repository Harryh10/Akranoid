//PEREZ_PEREA_HARRY_ANTONIO_0222220035
package elements;

import Game.Game;
import java.awt.Color;
import java.awt.Graphics2D;

public class GameBrick extends Brick {
    
    public GameBrick(Game game, int x, int y) {
		super(game, x, y);
	}

	@Override
	public void paint(Graphics2D g2d) {
		g2d.setColor(Color.decode("#2980B9"));// color principal
		g2d.fillRect(X, Y, WIDTH, HEIGHT);

	}


    
}
