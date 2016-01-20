package com.sshsgd.mlgbreakout;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class MyCamera extends OrthographicCamera {

	public MyCamera() {
		super();
	}

	public MyCamera(float viewportWidth, float viewportHeight) {
		super(viewportWidth, viewportHeight);
	}
	
	public MyCamera(Vector2 viewport, boolean center) {
		super(viewport.x, viewport.y);
		if(center) this.position.set(viewport.x * .5f, viewport.y * .5f, 0);
		this.update();
	}
	
	public boolean inView(float x, float y) {
		float leftX, rightX, bottom, top;
		leftX = this.position.x - (this.viewportWidth * .5f);
		rightX = this.position.x + (this.viewportWidth * .5f);
		top = this.position.y + (this.viewportHeight * .5f);
		bottom = this.position.y - (this.viewportHeight * .5f);
		return (((x > leftX) && (x < rightX)) && ((y < top) && (y > bottom)));
	}
	
	public boolean inView(Vector2 point) {
		return inView(point.x, point.y);
	}
	
//	public boolean inView(Entity e) { TODO Add After Entity is created
//		boolean topLeft = inView(e.getX(), e.getTop());
//		boolean bottomLeft = inView(e.getPosition());
//		boolean topRight = inView(e.getRight(), e.getTop());
//		boolean bottomRight = inView(e.getRight(), e.getY());
//		boolean center = inViewCenter(e);
//		boolean bottomCenter = inView(e.getCenter().x, e.getY());
//		boolean topCenter = inView(e.getCenter().x, e.getTop());
//		boolean rightCenter = inView(e.getRight(), e.getCenter().y);
//		boolean leftCenter = inView(e.getX(), e.getCenter().y);
//		return topLeft || bottomLeft || topRight || bottomRight || center || bottomCenter || topCenter || topCenter || rightCenter || leftCenter;
//	}
//	
//	public boolean inViewCenter(Entity e) {
//		return inView(e.getCenter());
//	}

	public void resize(Vector2 size, boolean center) {
		this.viewportHeight = size.y;
		this.viewportWidth = size.x;
		if(center) this.position.set(size.x * .5f, size.y * .5f, 0);
		this.update();
	}
	
	public float getLeft() {
		return this.position.x - (this.viewportWidth * .5f);
	}
	
	public float getRight() {
		return this.position.x + (this.viewportWidth * .5f);
	}
	
	public float getBottom() {
		return this.position.y - (this.viewportHeight * .5f);
	}
	
	public float getTop() {
		return this.position.y + (this.viewportHeight * .5f);
	}
}
