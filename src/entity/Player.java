package entity;

import Main.KeyHandler;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GameScreen;

public class Player extends Entity{
	GameScreen gp;
	KeyHandler keyH;
	public boolean right = true;
	
	public Player(GameScreen gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues() {
		x = 0;
		y = (gp.tileSize*gp.maxScreenRow)-(gp.tileSize*2);
		speed = 4;
		direction = "right";
	}
	public void getPlayerImage()
	{
		try {
			right1 = ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerRight1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerRight2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerRight3.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerRight4.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerLeft1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerLeft2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerleft3.png"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerLeft4.png"));
			upL1 = ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerLeftJump1.png"));
			upL2 = ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerLeftJump2.png"));
			upL3 = ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerLeftJump3.png"));
			upL4 = ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerLeftJump4.png"));
			upR1 = ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerRightJump1.png"));
			upR2 = ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerRightJump2.png"));
			upR3 = ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerRightJump3.png"));
			upR4 = ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerRightJump4.png"));
			downL1 =ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerDownLeft1.png"));
			downL2 =ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerDownLeft2.png"));
			downL3 =ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerDownLeft3.png"));
			downR1 =ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerDownRight1.png"));
			downR2 =ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerDownRight2.png"));
			downR3 =ImageIO.read(getClass().getResourceAsStream("/Player/SmallProjectPlayerDownRight3.png"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void update() {
		if(true && y < (gp.tileSize*gp.maxScreenRow)-(gp.tileSize*2))
		{
			y += 5;
		}
			if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true)
			{
				if(keyH.upPressed == true) {
					direction = "up";
					y -= 150;
					keyH.upPressed = false;
				}else if(keyH.downPressed == true) {
					direction = "down";
					if(y < (gp.tileSize*gp.maxScreenRow)-(gp.tileSize*2)) {
						y += speed;
					}
					if(right == true) {
						x += speed;
					}else {
						x -=speed;
					}
					keyH.downPressed = false;
				}else if(keyH.leftPressed == true) {
					direction = "left";
					right = false;
					x -= speed;
				}else if(keyH.rightPressed == true) {
					direction = "right";
					right = true;
					x += speed;
				}
				spriteCounter++;
				if(spriteCounter > 12) {
					if(spriteNum == 1) {
						spriteNum = 2;
					}else if(spriteNum == 2) {
						spriteNum = 1;
					}
					spriteCounter = 0;
				}
			}
	}
	public void draw(Graphics2D g2){
		//g2.setColor(Color.white);
		
		//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction)
		{
		case "up":
			if(right == true) {
				if(spriteNum == 1) {
					image = upR1;
				}
				if(spriteNum == 2) {
					image = upR2;
				}
				if(spriteNum == 3) {
					image = upR3;
				}
				if(spriteNum == 4) {
					image = upR4;
				}
			}else {
				if(spriteNum == 1) {
					image = upL1;
				}
				if(spriteNum == 2) {
					image = upL2;
				}
				if(spriteNum == 3) {
					image = upL3;
				}
				if(spriteNum == 4) {
					image = upL4;
				}
			}
			break;
		case "down":
			if(right == true) {
				if(spriteNum == 1) {
					image = downR2;
				}
				if(spriteNum == 2) {
					image = downR1;
				}
				if(spriteNum == 3) {
					image = downR3;
				}
			}else {
				if(spriteNum == 1) {
					image = downL2;
				}
				if(spriteNum == 2) {
					image = downL1;
				}
				if(spriteNum == 3) {
					image = downL3;
				}
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left3;
			}
			if(spriteNum == 3) {
				image = left2;
			}
			if(spriteNum == 4) {
				image = left4;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right3;
			}
			if(spriteNum == 3) {
				image = right2;
			}
			if(spriteNum == 4) {
				image = right4;
			}
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}
}
