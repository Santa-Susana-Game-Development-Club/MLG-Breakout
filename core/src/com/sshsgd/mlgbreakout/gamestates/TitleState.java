package com.sshsgd.mlgbreakout.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sshsgd.mlgbreakout.Game;
import com.sshsgd.mlgbreakout.MyCamera;
import com.sshsgd.mlgbreakout.MyConstants;
import com.sshsgd.mlgbreakout.managers.GameStateManager;

public class TitleState extends GameState {

	private MyCamera cam;
	private Viewport view;
	
	private Vector2[] gifPoints;
	
	private float stateTime;

	public TitleState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	protected void init() {
		Game.res.stopAllSound();
		Game.res.getMusic("darude").play();
		cam = new MyCamera();
		view = new StretchViewport(MyConstants.WOLRD_WIDTH, MyConstants.WORLD_HEIGHT, cam);
		view.apply(true);
		view.update((int)Game.SIZE.x, (int)Game.SIZE.y, true);
		
		gifPoints = new Vector2[Game.res.getNumAnims()];
		
		for (int i = 0; i < gifPoints.length; i++) {
			int x = MathUtils.random(MyConstants.WOLRD_WIDTH - Game.res.getKeyFrame(Game.res.getAnimKey(i), 0, true).getRegionWidth());
			int y = MathUtils.random(MyConstants.WORLD_HEIGHT - Game.res.getKeyFrame(Game.res.getAnimKey(i), 0, true).getRegionHeight());
			gifPoints[i] = new Vector2(x, y);
		}
		
		stateTime = 0;

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
		stateTime += dt;
		
		sb.begin();
		sb.setProjectionMatrix(cam.combined);
		for (int i = 0; i < Game.res.getNumAnims(); i++) {
			TextureRegion region = Game.res.getKeyFrame(Game.res.getAnimKey(i), stateTime, true);
			float rWidth = MyConstants.clamp(region.getRegionWidth(), 0, 200);
			float rHeight = MyConstants.clamp(region.getRegionHeight(), 0, 200);
			float originX = rWidth * .5f;
			float originY = rHeight * .5f;
			sb.draw(region, gifPoints[i].x, gifPoints[i].y, originX, originY, rWidth, rHeight, 1, 1, MathUtils.random(360));
		}
		sb.end();

	}

	@Override
	public void resize(int width, int height) {
		view.update(width, height, true);

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
