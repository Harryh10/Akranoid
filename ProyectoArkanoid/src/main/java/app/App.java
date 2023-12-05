//HARRY_PEREZ_PEREA_0222220035

package app;

import Game.Game;
import javax.swing.JFrame;

public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Game game = new Game();
		game.frame.add(game);
                game.frame.setSize(747, 650);
		game.frame.setLocationRelativeTo(null); // frame.setLocation(100,100);
		game.frame.setVisible(true);
		game.frame.setResizable(false);
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
