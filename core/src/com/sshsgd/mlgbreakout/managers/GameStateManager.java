package com.sshsgd.mlgbreakout.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.sshsgd.mlgbreakout.Game;
import com.sshsgd.mlgbreakout.MyConstants.States;
import com.sshsgd.mlgbreakout.gamestates.*;

public class GameStateManager {

	private GameState currentState;
	
	private SpriteBatch sb;
	private ShapeRenderer sr;
	
	public GameStateManager() {
		sb = new SpriteBatch();
		sr = new ShapeRenderer();
		setState(Game.defaultState);
	}
	
	public void setState(States state) {
		if(currentState != null) currentState.dispose();
		if(state == States.Splash) {
			currentState = new SplashState(this);
		}
		if(state == States.Title) {
			currentState = new TitleState(this);
		}
		if(state == States.Play) {
			currentState = new PlayState(this);
		}
		if(state == States.GameOver) {
			currentState = new GameOverState(this);
		}
		if(state == States.Credits) {
			currentState = new CreditsState(this);
		}
	}
	
	public void handleInput() {
		currentState.handleInput();
	}
	
	public void update(float dt) {
		currentState.update(dt);
	}
	
	public void draw(float dt) {
		currentState.draw(sr, sb, dt);
	}
	
	public void resize(int width, int height) {
		currentState.resize(width, height);
	}
	
	public void dispose() {
		currentState.dispose();
	}
	
}
