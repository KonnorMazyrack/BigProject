package Main;

import objects.OBJ_Door;
import objects.OBJ_Door2;
import objects.OBJ_Key;
import objects.OBJ_Key2;
import objects.OBJ_Chest;

public class AssetSetter {
	
	GameScreen gp;
	
	public AssetSetter(GameScreen gp)
	{
		this.gp = gp;
	}
	
	public void setObject()
	{
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldX = 23 * gp.tileSize;
		gp.obj[0].worldY = 7 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Key();
		gp.obj[1].worldX = 10 * gp.tileSize;
		gp.obj[1].worldY = 7 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Key2();
		gp.obj[2].worldX = 35 * gp.tileSize;
		gp.obj[2].worldY = 8 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Door();
		gp.obj[3].worldX = 10 * gp.tileSize;
		gp.obj[3].worldY = 11 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Door();
		gp.obj[4].worldX = 38 * gp.tileSize;
		gp.obj[4].worldY = 13 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Door2();
		gp.obj[5].worldX = 36 * gp.tileSize;
		gp.obj[5].worldY = 22 * gp.tileSize;
		
		gp.obj[7] = new OBJ_Chest();
		gp.obj[7].worldX = 10 * gp.tileSize;
		gp.obj[7].worldY = 8 * gp.tileSize;
	}
}
