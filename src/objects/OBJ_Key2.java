package objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Key2 extends SuperObject{

	public OBJ_Key2()
	{
		name = "Key2";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/object/key2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
