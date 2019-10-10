package vanguardamanager.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage maleIcon, femaleIcon; 
	
	public static void init() {
		maleIcon = ImageLoader.loadImage("/images/male.png");
		femaleIcon = ImageLoader.loadImage("/images/female.png");
		
	}
	
}
