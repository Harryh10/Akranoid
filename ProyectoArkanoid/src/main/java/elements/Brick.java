//HARRY_PEREZ_PEREA_0222220035

package elements;

import Game.Game;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Brick {
    
        protected Game game;
	protected static final int WIDTH = 60;
	protected static final int HEIGHT = 20;
	protected int X = 0;
	protected int Y = 0;
    
    public Brick(Game game, int x, int y) {
        
		super();
		this.game = game;
		X = x;
		Y = y;
	}
    
    
    public Rectangle getBounds() {
        
	return new Rectangle(X, Y, WIDTH, HEIGHT);

    }
    
    public abstract void paint(Graphics2D g);
    
    public int getY() {
        
        return Y;
    }

    public void setY(int y) {
        
	this.Y = y;
    }

}
