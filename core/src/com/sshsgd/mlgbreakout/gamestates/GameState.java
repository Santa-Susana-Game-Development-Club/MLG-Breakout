package com.sshsgd.mlgbreakout.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.sshsgd.mlgbreakout.managers.GameStateManager;

public abstract class GameState {

	protected GameStateManager gsm;
	
	protected GameState(GameStateManager gsm) {
		this.gsm = gsm;
		this.init();
	} 
	
	protected abstract void init();
	public abstract void handleInput();
	public abstract void update(float dt);
	public abstract void draw(ShapeRenderer sr, SpriteBatch sb, float dt);
	public abstract void resize(int width, int height);
	public abstract void dispose();
	
}
