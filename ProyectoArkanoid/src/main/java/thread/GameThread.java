//PEREZ_PEREA_HARRY_ANTONIO_0222220035

package thread;

import Game.Game;
import elements.Ball;
import elements.Brick;

public class GameThread extends Thread{
    
    Brick brick;
    Ball ball;
    int speed;
    Game game;
    public boolean estado = true;
    
    
    public GameThread(Brick brick, Ball ball, int speed, String name,Game game) {
        super(name);
        this.brick = brick;
        this.ball = ball;
        this.speed = speed;
        this.game = game;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }  
    
    @Override
    public void run(){
                        
                    while(!isInterrupted()){

                        game.repaint();
                        game.gameball.move();
                        game.gameboard.move();

                        System.out.println(this.getName());

                        try{

                            Thread.sleep(speed);

                        }
                        catch(InterruptedException e){
                            
                            interrupt();
                        }
                        
                    }                
    } 
}
