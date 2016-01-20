package com.sshsgd.mlgbreakout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class MyConstants {

	/**
	 * All the Game States
	 * @author José Rodriguez-Rivas
	 *
	 */
	public static enum States {
		Splash, Title, Play,
		GameOver, Credits
	}
	
	/**
	 * The name of the save file
	 */
	public static final String saveFile = "mlg_breakout.sav";
	
	/**
	 * Arbitrary Enum to represent Direction
	 * @author José Rodriguez-Rivas
	 *
	 */
	public static enum Direction {
		LEFT, RIGHT
	}
	
	/**
	 * Virtual Width of Screen
	 */
	public static final int WOLRD_WIDTH = 1280;
	
	/**
	 * Virtual Height of Screen
	 */
	public static final int WORLD_HEIGHT = 720;
	
	/**
	 * @param radians The angle in radians of the velocity
	 * @param speed The speed of the velocity
	 * @return A velocity of the given speed moving at the given angle as a {@link com.badlogic.gdx.math.Vector2 Vector2}
	 */
	public static Vector2 generateVelocity(float radians, float speed) {
		float x = MathUtils.cos(radians) * speed;
		float y = MathUtils.sin(radians) * speed;
		return new Vector2(x, y);
	}
	
	/**
	 * @param speed The speed of the velocity
	 * @return A Velocity of the given speed in a random direction as a {@link com.badlogic.gdx.math.Vector2 Vector2}
	 */
	public static Vector2 randomVelocity(float speed) {
		return MyConstants.generateVelocity(MathUtils.random(MathUtils.PI2), speed);
	}
	
	/**
	 * 
	 * @return Returns a random {@link com.sshsgd.mlgbreakout.MyConstants.Direction Direction}
	 */
	public static Direction randomDirection() {
		if(MathUtils.randomBoolean()) {
			return Direction.RIGHT;
		} else {
			return Direction.LEFT;
		}
	}
	
	/**
	 * 
	 * @param x1 The x coordinate of the first point
	 * @param y1 The y coordinate of the first point
	 * @param x2 The x coordinate of the second point
	 * @param y2 The y coordinate of the second point
	 * @return The distance between the two points
	 */
	public static float distance(float x1,float y1,float x2,float y2) {
		float a = (x2 - x1);
		float b = (y2 - y1);
		return (float) Math.sqrt((Math.pow(a, 2)) + (Math.pow(b, 2)));
	}
	
	/**
	 * 
	 * @param p1 The First point
	 * @param p2 The Second Point
	 * @return The distance between the two points
	 * @see com.sshsgd.mlgbreakout.MyConstants#distance(float, float, float, float)
	 */
	public static float distance(Vector2 p1, Vector2 p2) {
		return distance(p1.x, p1.y, p2.x, p2.y);
	}
	
	/**
	 * @return A random {@link com.badlogic.gdx.graphics.Color Color}
	 */
	public static Color randomColor() {
		return new Color(MathUtils.random(), MathUtils.random(), MathUtils.random(), 1);
	}
	
	/**
	 * Allows use of the standard 255 scale, rather than from 0 to 1
	 * @param r The red value
	 * @param g The green value
	 * @param b The blue value
	 * @param a the alpha value
	 * @return The {@link com.badlogic.gdx.graphics.Colors Color} from the given values
	 */
	public static Color rgba(float r, float g, float b, float a) {
		return new Color(r / 255f, g / 255f, b / 255f, a / 255f);
	}
	
	/**
	 * Checks if a given boolean value is in an array
	 * @param b The boolean value to be checked if exits in array
	 * @param array The given array of booleans
	 * @return Whether the boolean array contains the given value
	 */
	public static boolean booleanArrayContains(boolean b, boolean[] array) {
		for(boolean bool : array) {
			if(bool == b) return true;
		}
		return false;
	}
	
	/**
	 * Clamps the given number to keep it in the given range
	 * @param n The given number
	 * @param min The maximum
	 * @param max The minimum
	 * @return if n is greater than max, then max, if n is less than min, then min, otherwise, returns n
	 */
	public static float clamp(float n, float min, float max) {
		float r = n;
		if(r < min) {
			r = min;
		}
		if(r > max) {
			r = max;
		}
		return r;
	}
	
	/**
	 * 
	 * Same as {@link com.sshsgd.mlgbreakout.MyConstants#clamp(float, float, float) clamp(float, float, float)}} but with Integers instead of Floats
	 * 
	 * @see com.sshsgd.mlgbreakout.MyConstants#clamp(float, float, float)
	 */
	public static int clamp(int n, int min, int max) {
		int r = n;
		if(r < min) {
			r = min;
		}
		if(r > max) {
			r = max;
		}
		return r;
	}
	
	/**
	 * Checks if n is greater than max, or less than min
	 * @param n The given number
	 * @param min The lowest the number can be
	 * @param max The highest the number can be
	 * @return True if n is greater than max, or less than min. False otherwise
	 */
	public static boolean wouldWrap(float n, float min, float max) {
		return n < min || n > max;
	}
	
	/**
	 * Same as {@link com.sshsgd.mlgbreakout.MyConstants#wouldWrap(float, float, float) wouldWrap(float, float, float)} but with Integers instead of Floats
	 * 
	 * @see com.sshsgd.mlgbreakout.MyConstants#wouldWrap(float, float, float)
	 */
	public static boolean wouldWrap(int n, int min, int max) {
		return n < min || n > max;
	}
	
	/**
	 * Wraps the given number so that when the number is above the max, it wraps around to the min
	 * @param n The given number
	 * @param min The lowest the number can be
	 * @param max The highest the number can be
	 * @return Min if n is greater than max, max if n is less than min, and n otherwise.
	 */
	public static float wrap(float n, float min, float max) {
		float r = n;
		if(r < min) {
			r = max;
		}
		if(r > max) {
			r = min;
		}
		return r;
	}
	
	/**
	 * Same as {@link com.sshsgd.mlgbreakout.MyConstants#wrap(float, float, float) wrap(float, float, float)} but with Integers instead of Floats
	 * 
	 * @see com.sshsgd.mlgbreakout.MyConstants#wrap(float, float, float)
	 */
	public static int wrap(int n, int min, int max) {
		int r = n;
		if(r < min) {
			r = max;
		}
		if(r > max) {
			r = min;
		}
		return r;
	}
	
	/**
	 * Checks if a given number is on the given interval
	 * @param n The given number
	 * @param min The lowest n can be
	 * @param max The highest n can be
	 * @param includeMin Whether to return true if n is equal to min
	 * @param includeMax Whether to return true if n is equal to max
	 * @return True if n is on the interval, false otherwise
	 */
	public static boolean inBetween(float n, float min, float max, boolean includeMin, boolean includeMax) {
		boolean greater, less;
		if(includeMin) {
			greater = n >= min;
		} else {
			greater = n > min;
		}
		if(includeMax) {
			less = n <= max;
		} else {
			less = n < max;
		}
		return greater && less;
	}

	/**
	 * @return The score that is padded with zeroes to be at least 7 characters 
	 */
	public static String getScore(int score) {
		return String.format("%07f", score);
	}
	
	/**
	 * 
	 * @param currentTime Time in seconds
	 * @return Formats the given time to min:sec:millisec
	 */
	public static String getTime(float currentTime) {
		float seconds = currentTime;
		float minutes = seconds / 60;
		float remainingSeconds = seconds % 60;
		float fmilliseconds = (float) (seconds - Math.floor(seconds));
		fmilliseconds *= 10000;
		int intmilliseconds = (int) fmilliseconds;
		String timeS;
		if(remainingSeconds >= 10) {
			timeS = (int) minutes + ":" + (int) remainingSeconds;
		} else {
			if(seconds < 0) {
				timeS = "-" + (int) minutes + ":0" + (int) Math.abs(remainingSeconds);
			} else {
				timeS = (int) minutes + ":0" + (int) remainingSeconds;
			}
		}
		timeS = timeS + "." + intmilliseconds;
		return timeS;
	}
	
	/**
	 * @param width Width of the resolution
	 * @return A height that is proportional to the given width 16:9
	 */
	public static float sixteenNineResolution(float width) {
		return (width * 9f) / 16f;
	}
	
	/**
	 * Works same as {@link com.sshsgd.mlgbreakout.MyConstants#sixteenNineResolution(float) sixteenNineResolution(float)} but with Integers instead of Floats
	 * @see com.sshsgd.mlgbreakout.MyConstants#sixteenNineResolution(float)
	 */
	public static int sixteenNineResolution(int width) {
		return (int) ((width * 9f) / 16f);
	}
}
