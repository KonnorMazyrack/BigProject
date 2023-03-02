package entity;

import java.awt.image.BufferedImage;

public class Entity {
	public int x, y;
	public int speed;
	
	public BufferedImage right1, right2, right3, right4, left1, left2, left3, left4;
	public BufferedImage upL1, upL2, upL3, upL4, upR1, upR2, upR3, upR4;
	public BufferedImage downL1, downL2, downL3, downR1, downR2, downR3;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
}
