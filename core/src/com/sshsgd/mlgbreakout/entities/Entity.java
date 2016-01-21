package com.sshsgd.mlgbreakout.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
	
	private Rectangle bounds;
	
	private Vector2 vel;
	
	public abstract void draw(ShapeRenderer sr, SpriteBatch sb, float dt);
	
	
	public float getX() {
		return bounds.x;
	}
	public void setX(float x) {
		bounds.x = x;
	}
	public float getY() {
		return bounds.y;
	}
	public void setY(float y) {
		bounds.y = y;
	}
	public float getWidth() {
		return bounds.width;
	}
	public void setWidth(float width) {
		bounds.width = width;
	}
	public float getHeight() {
		return bounds.height;
	}
	public void setHeight(float height) {
		bounds.height = height;
	}
	
	public float getRight(){
		return bounds.x + bounds.width;
	}
	
	public float getTop(){
		return bounds.y + bounds.height;
	}
	
	public Vector2 getCenter(){
		return new Vector2(bounds.x + (bounds.width * .5f), bounds.y + (bounds.height * .5f));
	}
	
	public Vector2 getVel() {
		return vel;
	}

	public void setVel(Vector2 vel) {
		this.vel = vel;
	}
	
	
}
