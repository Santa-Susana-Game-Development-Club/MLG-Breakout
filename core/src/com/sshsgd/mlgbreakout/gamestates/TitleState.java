package com.sshsgd.mlgbreakout.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.sshsgd.mlgbreakout.Game;
import com.sshsgd.mlgbreakout.managers.GameStateManager;

public class TitleState extends GameState {

	public TitleState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	protected void init() {
		Game.res.stopAllSound();
		Game.res.getMusic("darude").play();

	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(ShapeRenderer sr, SpriteBatch sb, float dt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
