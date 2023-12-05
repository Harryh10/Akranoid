//PEREZ_PEREA_HARRY_ANTONIO_0222220035

package Game;

import elements.Ball;
import elements.Board;
import elements.Brick;
import elements.GameBrick;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import thread.GameThread;


public class Game extends JPanel implements ActionListener {

    
        JLabel jLabel1 = new JLabel();
    
        public Ball gameball = new Ball(this);
	public Board gameboard = new Board(this);
        Brick gamebrick;
	public ArrayList<Brick> arrayLadrillos = new ArrayList<Brick>();
        final static int VERYSLOW = 15;
        final static int SLOW = 10;
        static final int NORMAL = 8;
        static final int FAST = 5;
        static final int VERYFAST = 2;
        GameThread gameThread;
        public int [] guardarPuntajes = new int[5];
        
	public int speed = NORMAL;
	public int bspeed = 6;
	public int puntuacion = 0;
        public static JFrame frame = new JFrame("PEREZ_PEREA_HARRY_ANTONIO_0222220035"); 
        JMenuBar menuBar = new JMenuBar();        
        JMenu gameMenu = new JMenu("Game");
        public Cronometro clock = new Cronometro();
        public JFrame records = new JFrame("Records");
        
        
        
	public int getScore() {
		return puntuacion;
	}
        
        public Game() {
        
            records.add(jLabel1);
            jLabel1.setLocation(100, 200);
            records.setSize(250,300);
            
            
        JMenuBar menuBar = new JMenuBar();        
        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);
        frame.add(menuBar, BorderLayout.NORTH);
            
        JMenuItem playItem = new JMenuItem("Play");
        gameMenu.add(playItem);
        
        JMenuItem restartItem = new JMenuItem("Restart");
        gameMenu.add(restartItem);
        
        
        JMenuItem pauseItem = new JMenuItem("Pause");
        gameMenu.add(pauseItem);
        
        JMenuItem closeItem = new JMenuItem("Close");
        gameMenu.add(closeItem);
        
        JMenu optionsMenu = new JMenu("Options");
        menuBar.add(optionsMenu);
        
        JMenu records = new JMenu("Records");
        menuBar.add(records);
        JMenuItem showbesttimes = new JMenuItem("Show best times");
        records.add(showbesttimes);
        showbesttimes.setActionCommand("show best times");
        showbesttimes.addActionListener(this);
        
        
        JMenu speedMenu = new JMenu("Speed");
        optionsMenu.add(speedMenu);
        
        
        JMenu ballsMenu = new JMenu("Balls");
        optionsMenu.add(ballsMenu);
        
        //BOTONES DE OPCIÓN DE JUEGO
         ButtonGroup ballGroup = new ButtonGroup();
         JRadioButtonMenuItem ballItem = new JRadioButtonMenuItem("Balls: ONE");
         ballItem.setActionCommand("ONE");
         ballItem.addActionListener(this);
         ballGroup.add(ballItem);
         ballsMenu.add(ballItem);
         
         ballItem = new JRadioButtonMenuItem("Balls: TWO");
         ballItem.setActionCommand("TWO");
         ballItem.addActionListener(this);
         ballGroup.add(ballItem);
         ballsMenu.add(ballItem);
         
         ballItem = new JRadioButtonMenuItem("Balls: THREE");
         ballItem.setActionCommand("THREE");
         ballItem.addActionListener(this);
         ballGroup.add(ballItem);
         ballsMenu.add(ballItem);
           
        playItem.setActionCommand("PLAY");
        playItem.addActionListener(this);
        
        closeItem.setActionCommand("CLOSE");
        closeItem.addActionListener(this);
        
        pauseItem.setActionCommand("PAUSE");
        pauseItem.addActionListener(this);
        
        restartItem.setActionCommand("RESTART");
        restartItem.addActionListener(this);
        
        
        
  
         //BOTONES DE VELOCIDAD
         ButtonGroup btnGroup = new ButtonGroup();
         JRadioButtonMenuItem rbMenuItem = new JRadioButtonMenuItem("Speed: VERY SLOW");
         rbMenuItem.setActionCommand("VERYSLOW");
         rbMenuItem.addActionListener(this);
         btnGroup.add(rbMenuItem);
         speedMenu.add(rbMenuItem);   
        
         rbMenuItem = new JRadioButtonMenuItem("Speed: SLOW");
         rbMenuItem.setActionCommand("SLOW");
         rbMenuItem.addActionListener(this);
         btnGroup.add(rbMenuItem);
         speedMenu.add(rbMenuItem);   
        
         rbMenuItem = new JRadioButtonMenuItem("Speed: FAST");
         rbMenuItem.setActionCommand("FAST");
         rbMenuItem.addActionListener(this);
         btnGroup.add(rbMenuItem);
         speedMenu.add(rbMenuItem);   
        
         rbMenuItem = new JRadioButtonMenuItem("Speed: VERY FAST");
         rbMenuItem.setActionCommand("VERYFAST");
         rbMenuItem.addActionListener(this);
         btnGroup.add(rbMenuItem);
         speedMenu.add(rbMenuItem);
        

		crearLadrillos(arrayLadrillos);
                
                gameThread = new GameThread(gamebrick,gameball,speed,"GameThread",this);
                
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				gameboard.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				gameboard.keyPressed(e);
			}
		});
		setFocusable(true);
       
	}
        
        public void actionPerformed(ActionEvent e){
            
            if(e.getActionCommand().equals("VERYSLOW"))
            {
                    this.speed = VERYSLOW;
                    this.gameThread.setSpeed(VERYSLOW);
            }
            else{
                
                if(e.getActionCommand().equals("SLOW"))
                {
                        this.speed = SLOW;
                        this.gameThread.setSpeed(SLOW);
                }
                else{
                    
                    if(e.getActionCommand().equals("FAST"))
                    {
                        this.speed = FAST;
                        this.gameThread.setSpeed(FAST);
                    }
                    else{
                        
                        if(e.getActionCommand().equals("VERYFAST")){
                            
                            this.speed = VERYFAST;
                            this.gameThread.setSpeed(VERYFAST);
                            
                        } 
                    } 
                }  
            }

            if(e.getActionCommand().equals("PLAY")){
                
                initGame(gameThread);
                
            }else{
                
                if(e.getActionCommand().equals("PAUSE")){
                    
                    pauseGame(gameThread);
                       
                    
                }else{
                    
                    if(e.getActionCommand().equals("RESTART")){
                        
                        restartGame();
                        
                    }else{
                        
                            if(e.getActionCommand().equals("CLOSE")){
                 
                                System.exit(0);

                            }
                    }
                }
            }
            
            if(e.getActionCommand().equals("show best times")){
                
                    jLabel1.setText("            Puntaje "+":    "+String.valueOf(guardarPuntajes[1]));

                records.setVisible(true);
                
            }
            
            
            
              
        }
 
        private void move() {
		gameball.move();
		gameboard.move();     
	}
        
        
        @Override
        public void paint(Graphics g) {
		super.paint(g);
		setBackground(Color.decode("#ffffff"));
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gameball.paint(g2d);
		gameboard.paint(g2d);

		for (int i = 0; i < arrayLadrillos.size(); i++) {

			arrayLadrillos.get(i).paint(g2d);

		}

		g2d.setColor(Color.decode("#505250"));
		g2d.setFont(new Font("DialogInput", Font.ITALIC, 17));
		g2d.drawString(String.valueOf("Score: " + getScore()), 10, 520);

	}

        public void crearLadrillos(ArrayList<Brick> arrayLadrillos) {
		
		for (int x=0;x<650; x++) {
                    
                        if(x>0)
                        x += 60;
                    
			for (int y = 0; y < 100; y++) {
                                                    
                            gamebrick = new GameBrick(this,x, y) {};
                            arrayLadrillos.add(gamebrick);
                            
                            if(y>0)
                            y +=20;
				
			}
		}
	} 
    
        private void initGame(GameThread gt){
        
        gt.start();
        if(gt.isInterrupted()==false){
           clock = new Cronometro();
           clock.setEstado(true);
           clock.setVisible(true); 
        }
    }
    
        private void pauseGame(GameThread gt){
        
        gt.interrupt();
        clock.setEstado(false);
        
    }
    
        private void restartGame(){
        
        Random r = new Random();
        
        puntuacion=0;
        gameball.x=r.nextInt(650)+10;
        gameball.y=150;
        gameball.xa=1;
        gameball.ya=1;
        
        
    }
    
    
}
