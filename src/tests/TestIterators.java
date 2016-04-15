package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import a5.Picture;
import a5.PictureImpl;
import a5.PixelIterator;
import a5.SampleIterator;
import a5.ZigZagIterator;
import a5.TileIterator;
import a5.WindowIterator;
import a5.ColorPixel;

public class TestIterators {

	private Picture p1, p2;
	
	@Before
	public void setUp() throws Exception {
		p1 = new PictureImpl(4, 4);
		p1.setPixel(0,  0, new ColorPixel(0.0, 0.0, 0.0));
		p1.setPixel(0,  1, new ColorPixel(0.0, 0.0, 1.0));
		p1.setPixel(0,  2, new ColorPixel(0.0, 1.0, 0.0));
		p1.setPixel(0,  3, new ColorPixel(0.0, 1.0, 1.0));
		
		p1.setPixel(1,  0, new ColorPixel(1.0, 0.0, 0.0));
		p1.setPixel(1,  1, new ColorPixel(1.0, 0.0, 1.0));
		p1.setPixel(1,  2, new ColorPixel(1.0, 1.0, 0.0));
		p1.setPixel(1,  3, new ColorPixel(1.0, 1.0, 1.0));
		
		p1.setPixel(2,  0, new ColorPixel(0.25, 0.25, 0.25));
		p1.setPixel(2,  1, new ColorPixel(0.25, 0.25, 0.75));
		p1.setPixel(2,  2, new ColorPixel(0.25, 0.75, 0.25));
		p1.setPixel(2,  3, new ColorPixel(0.25, 0.75, 0.75));
		
		p1.setPixel(3,  0, new ColorPixel(0.75, 0.25, 0.25));
		p1.setPixel(3,  1, new ColorPixel(0.75, 0.25, 0.75));
		p1.setPixel(3,  2, new ColorPixel(0.75, 0.75, 0.25));
		p1.setPixel(3,  3, new ColorPixel(0.75, 0.75, 0.75));
		
		p2 = p1.extract(0, 0, 2, 3);
	}

	@Test
	public void testPixelIterator() {
	}

	@Test
	public void testSampleIterator() {
	}

	@Test
	public void testZigZagIterator() {	
	}
	
	@Test
	public void testTileIterator() {
	}
	
	@Test
	public void testWindowIterator() {
	}
}
