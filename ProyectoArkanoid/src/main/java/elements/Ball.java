//HARRY_PEREZ_PEREA_0222220035

package elements;

import Game.Game;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ball {
        
    
        
        private static final int DIAMETER = 10;
	public int x = 40;
	public int y = 150;
	public int xa = 1;
	public int ya = 1;
	public Game game;
        
	public Ball(Game game){
            
            this.game = game;
                
	}
        
        public void move() {
        
            
             
            System.out.println(" xa "+xa);
            System.out.println("ya "+ya);
            
            if (x + xa < 0)
			xa = -xa;
		else if (x + xa > game.getWidth() - DIAMETER)
			xa = -xa;
		else if (y + ya < 0)
			ya = ya;
		else if (y + ya > game.getHeight() - DIAMETER) {
                        
                    JOptionPane.showMessageDialog(game, "GAME OVER");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
                        
                        game.puntuacion=0;
                        
                        x = 100;
                        y = 130;
		}
                
		else if (boardcrash()) {
			ya = -ya;
			y = game.gameboard.getTopY() - DIAMETER;
			
		} else if (brickcrash()) {
			ya = -ya;
			xa = +xa;// +game.speed;
		} 
                
  
		x= x + xa;
		y= y + ya;

        }
         
        private boolean boardcrash() {
            
            return game.gameboard.getBounds().intersects(getBounds());
  
	}
        
        private boolean brickcrash() {
	
		for (int i = 0; i < game.arrayLadrillos.size(); i++) {
			if (game.arrayLadrillos.get(i).getBounds().intersects(getBounds())) {
				
					game.puntuacion += 100;
					game.arrayLadrillos.remove(i);
					return true;
            
			}
		}

		return false;
	}
        
        public void paint(Graphics2D g) {
		g.setColor(Color.decode("#ff0000"));
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
        
}
