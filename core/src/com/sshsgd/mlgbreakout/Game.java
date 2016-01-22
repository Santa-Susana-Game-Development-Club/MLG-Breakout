package com.sshsgd.mlgbreakout;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.sshsgd.mlgbreakout.MyConstants.*;
import com.sshsgd.mlgbreakout.managers.*;

public class Game extends ApplicationAdapter {
	
	public static final String GAME_TITE = "MLG Breakout";
	
	private float fpsTime;
	private int fps, frames;
	
	public static final States defaultState = States.Splash;
	
	public static Vector2 SIZE, CENTER;
	
	private GameStateManager gsm;
	
	public static Content res;
	
	@Override
	public void create () {
		
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		Game.SIZE = new Vector2();
		Game.CENTER = new Vector2();
		Game.SIZE.set(width, height);
		Game.CENTER.set(width * .5f, height * .5f);
		
		res = new Content();
		
		res.loadBitmapFont("font", "faucet.ttf", "main", 56, Color.WHITE);
		res.loadBitmapFont("font", "faucet.ttf", "splash", 72, Color.WHITE);
		res.loadBitmapFont("font", "faucet.ttf", "small", 32, Color.WHITE);
		
		res.loadAnimationFromFolder("snoop", "snoop", 58, "0.04");
		
		gsm = new GameStateManager();
		
		frames = 0;
		fps = 0;
		fpsTime = 0;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		float dt = Gdx.graphics.getDeltaTime();
		
		gsm.handleInput();
		gsm.update(dt);
		gsm.draw(dt);
		
		fpsTime += dt;
		frames++;
		if(fpsTime >= 1) {
			fps = frames;
			frames = 0;
			fpsTime = 0;
		}
		
		Gdx.graphics.setTitle(String.format("%s | FPS: %d", Game.GAME_TITE, fps));
	}

	@Override
	public void resize(int width, int height) {
		Game.SIZE.set(width, height);
		Game.CENTER.set(width * .5f, height * .5f);
		gsm.resize(width, height);
	}

	@Override
	public void dispose() {
		gsm.dispose();
		res.dispose();
	}
}
