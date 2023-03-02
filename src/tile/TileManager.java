package tile;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

import Main.GameScreen;

public class TileManager {

	GameScreen gp;
	Tile[] tile = {};
	
	public TileManager(GameScreen gp)
	{
		this.gp = gp;
		
		tile = new Tile[10];
		
		getTileImage();
	}
	
	public void getTileImage()
	{
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/GroundBrick1.png"));
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/EndBlock1.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g2)
	{
		int col = 0;
		int row = gp.maxScreenRow;
		int x = 0;
		int y = (gp.tileSize*gp.maxScreenRow)-gp.tileSize;
		while(col < gp.maxScreenCol && row == gp.maxScreenRow)
		{
			g2.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
			col++;
			x += gp.tileSize;
		}
		//g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
		//g2.drawImage(tile[1].image, 48, 0, gp.tileSize, gp.tileSize, null);
	}
}
