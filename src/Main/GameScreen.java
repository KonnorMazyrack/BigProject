package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GameScreen extends JPanel implements Runnable{
	
	//SCREEN SETTINGS
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3;
	
	public final int gravity = 1;
	public final int tileSize = originalTileSize * scale; // 48x48 tile
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	final int screenHeight = tileSize * maxScreenRow; // 576 pixels
	
	//FPS
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	Player player = new Player(this,keyH);
	
	public GameScreen() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener((KeyListener) keyH);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		while(gameThread != null) {
			double drawInterval = 1000000000/FPS; // .01666 seconds
			double delta = 0;
			long lastTime = System.nanoTime();
			long currentTime;
			
			while(gameThread != null) {
				currentTime = System.nanoTime();
				
				delta += (currentTime - lastTime)/drawInterval;
				lastTime = currentTime;
				
				if(delta >= 1) {
					update();
					repaint();
					delta--;
					
				}
			}
		}
	}
	
	public void update() {
		player.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		
		player.draw(g2);
		
		g2.dispose();
	}
	
}
