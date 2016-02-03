package com.sshsgd.mlgbreakout.managers.input;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class MyInputProcessor extends InputAdapter {

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.A || keycode == Keys.LEFT) {
			MyInput.setKey(MyInput.LEFT, true);
		}
		if(keycode == Keys.D || keycode == Keys.RIGHT) {
			MyInput.setKey(MyInput.RIGHT, true);
		}
		if(keycode == Keys.ENTER) {
			MyInput.setKey(MyInput.START, true);
		}
		if(keycode == Keys.ESCAPE) {
			MyInput.setKey(MyInput.BACK, true);
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.A || keycode == Keys.LEFT) {
			MyInput.setKey(MyInput.LEFT, false);
		}
		if(keycode == Keys.D || keycode == Keys.RIGHT) {
			MyInput.setKey(MyInput.RIGHT, false);
		}
		if(keycode == Keys.ENTER) {
			MyInput.setKey(MyInput.START, false);
		}
		if(keycode == Keys.ESCAPE) {
			MyInput.setKey(MyInput.BACK, false);
		}
		return true;
	}

	
	
}
