package a5;

import java.lang.Math;
import java.util.Iterator;

abstract public class AnyPicture implements Picture {

	abstract public int getWidth();
	abstract public int getHeight();

	abstract public Pixel getPixel(int x, int y);
	
	@Override
	public Pixel getPixel(Coordinate c) {
		if (c == null) {
			throw new IllegalArgumentException("Coordinate is null");
		}
		return this.getPixel(c.getX(), c.getY());
	}

	abstract public void setPixel(int x, int y, Pixel p);
	
	@Override
	public void setPixel(Coordinate c, Pixel p) {
		if (c == null) {
			throw new IllegalArgumentException("Coordinate is null");
		}
		this.setPixel(c.getX(), c.getY(), p);
	}
	
	@Override
	public SubPicture extract(int xoff, int yoff, int width, int height) {
		return new SubPictureImpl(this, xoff, yoff, width, height);
	}

	@Override 
	public SubPicture extract(Coordinate corner_a, Coordinate corner_b) {
		if (corner_a == null || corner_b == null) {
			throw new IllegalArgumentException("One or both coordinates is null");
		}
		
		int min_x = Math.min(corner_a.getX(), corner_b.getX());
		int min_y = Math.min(corner_a.getY(), corner_b.getY());
		int max_x = Math.max(corner_a.getX(), corner_b.getX());
		int max_y = Math.max(corner_a.getY(), corner_b.getY());
		
		return extract(min_x, min_y, (max_x-min_x)+1, (max_y-min_y)+1);
	}

	@Override
	public Iterator<Pixel> iterator() {
		return null;
	}
	
	@Override
	public Iterator<Pixel> sample(int init_x, int init_y, int dx, int dy) {
		return null;
	}
	
	@Override
	public Iterator<Pixel> zigzag() {
		return null;
	}
	
	@Override
	public Iterator<SubPicture> tile(int tile_width, int tile_height) {
		return null;
	}
	
	@Override
	public Iterator<SubPicture> window(int window_width, int window_height) {
		return null;
	}
}
