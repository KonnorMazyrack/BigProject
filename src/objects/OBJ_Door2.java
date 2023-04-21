package objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Door2 extends SuperObject{
	
	public OBJ_Door2()
	{
		name = "Door2";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/object/door2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
