package com.sshsgd.mlgbreakout;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	public static final String GAME_TITE = "MLG Breakout";
	
	private float fpsTime;
	private int fps, frames;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		
		frames = 0;
		fps = 0;
		fpsTime = 0;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
		
		float dt = Gdx.graphics.getDeltaTime();
		
		fpsTime += dt;
		frames++;
		if(fpsTime >= 1) {
			fps = frames;
			frames = 0;
			fpsTime = 0;
		}
		
		Gdx.graphics.setTitle(String.format("%s | FPS: %d", Game.GAME_TITE, fps));
	}
}
