package com.sshsgd.mlgbreakout.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sshsgd.mlgbreakout.Game;
import com.sshsgd.mlgbreakout.MyConstants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 800;
		config.height = MyConstants.sixteenNineResolution(config.width);
		new LwjglApplication(new Game(), config);
	}
}
