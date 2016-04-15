package a5;

import java.lang.Iterable;
import java.util.Iterator;

public interface Picture extends Iterable<Pixel> {

	int getWidth();
	int getHeight();

	Pixel getPixel(int x, int y);
	Pixel getPixel(Coordinate c);

	void setPixel(int x, int y, Pixel p);
	void setPixel(Coordinate c, Pixel p);
	
	SubPicture extract(int xoff, int yoff, int width, int height);
	SubPicture extract(Coordinate a, Coordinate b);
	
	Iterator<Pixel> sample(int init_x, int init_y, int dx, int dy);
	Iterator<Pixel> zigzag();
	Iterator<SubPicture> tile(int tile_width, int tile_height);
	Iterator<SubPicture> window(int window_width, int window_height);
}

