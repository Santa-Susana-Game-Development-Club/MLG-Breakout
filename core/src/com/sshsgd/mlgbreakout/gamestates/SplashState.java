package com.sshsgd.mlgbreakout.gamestates;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sshsgd.mlgbreakout.Game;
import com.sshsgd.mlgbreakout.MyCamera;
import com.sshsgd.mlgbreakout.MyConstants;
import com.sshsgd.mlgbreakout.MyConstants.States;
import com.sshsgd.mlgbreakout.managers.GameStateManager;

public class SplashState extends GameState {

	private MyCamera cam;
	private Viewport view;
	
	private float stateTime;
	
	private float time;
	private float timer;
	
	private TextureRegion currentSnoop;
	
	private Texture devGuy;
	
	private float textY, textH;
	
	private float imgX, imgY, imgW, imgH;
	
	float angle;
	
	private String splashText;
	
	public SplashState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	protected void init() {
		cam = new MyCamera();
		view = new StretchViewport(MyConstants.WOLRD_WIDTH, MyConstants.WORLD_HEIGHT, cam);
		view.apply(true);
		view.update((int)Game.SIZE.x, (int)Game.SIZE.y, true);
		
		devGuy = new Texture("devguy.png");
		
		angle = 0;
		
		stateTime = 0;
		timer = 8;
		setValues();
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub

	}

	private void setValues() {
		splashText = "Santa Susana High School\nGame Development Club\nPresents";
		textH = Game.res.getHeight("splash", splashText, MyConstants.WOLRD_WIDTH, Align.center, true);
		textY = (MyConstants.WORLD_HEIGHT * .5f) + (textH * .5f);
		
		imgW = devGuy.getWidth() * 3;
		imgH = devGuy.getHeight() * 3;
		imgX = (MyConstants.WOLRD_WIDTH * .5f) - (imgW * .5f);
		imgY = textY + 10;
	}
	
	@Override
	public void update(float dt) {
		setValues();
		time += dt;
		if(time >= timer) {
			time = 0;
			gsm.setState(States.Play);
		}
		angle = 360 * (time / timer);
	}

	@Override
	public void draw(ShapeRenderer sr, SpriteBatch sb, float dt) {
		currentSnoop = Game.res.getKeyFrame("snoop", stateTime, true); 
		stateTime += dt;
		sb.begin();
		sb.setProjectionMatrix(cam.combined);
		sb.setColor(MyConstants.randomColor());
		sb.draw(currentSnoop, 0, 0, MyConstants.WOLRD_WIDTH * .5f, MyConstants.WORLD_HEIGHT * .5f, MyConstants.WOLRD_WIDTH, MyConstants.WORLD_HEIGHT, 1, 1, angle);
		sb.setColor(Color.WHITE);
		sb.draw(devGuy, imgX, imgY, imgW, imgH);
		Game.res.getFont("splash").draw(sb, splashText, 0, textY, MyConstants.WOLRD_WIDTH, Align.center, false);
		sb.end();
	}

	@Override
	public void resize(int width, int height) {
		view.update(width, height, true);
	}

	@Override
	public void dispose() {
		devGuy.dispose();
	}

}
