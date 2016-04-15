/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import a5.ColorPixel;
import a5.Picture;
import a5.PictureImpl;
import a5.Pixel;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author michael
 */
public class TestIterators2 {

  private Picture[] p;

  public TestIterators2() {
  }

  @Before
  public void setUp() {
    p = new Picture[2];
    p[0] = new PictureImpl(3, 3);
    p[0].setPixel(0, 0, new ColorPixel(0.0, 0.0, 0.0));
    p[0].setPixel(0, 1, new ColorPixel(0.0, 0.0, 1.0));
    p[0].setPixel(0, 2, new ColorPixel(0.0, 1.0, 0.0));

    p[0].setPixel(1, 0, new ColorPixel(0.0, 1.0, 1.0));
    p[0].setPixel(1, 1, new ColorPixel(1.0, 0.0, 0.0));
    p[0].setPixel(1, 2, new ColorPixel(1.0, 0.0, 1.0));

    p[0].setPixel(2, 0, new ColorPixel(1.0, 1.0, 0.0));
    p[0].setPixel(2, 1, new ColorPixel(1.0, 1.0, 1.0));
    p[0].setPixel(2, 2, new ColorPixel(0.5, 0.5, 0.5));

    p[1] = p[0].extract(0, 0, 2, 2);
  }

  @Test
  public void testPixelIterator() {
    Iterator<Pixel> pixelIterator = p[0].iterator();
    assertNotNull(pixelIterator);
    for (int i = 0; i < p[0].getHeight(); i++) {
      for (int j = 0; j < p[0].getWidth(); j++) {
        assertTrue(pixelIterator.hasNext());
        Pixel pix = pixelIterator.next();
        Pixel picPix = p[0].getPixel(j, i);
        assertEquals(pix.getBlue(), picPix.getBlue(), 0.0);
        assertEquals(pix.getGreen(), picPix.getGreen(), 0.0);
        assertEquals(pix.getRed(), picPix.getRed(), 0.0);
      }
    }
    assertFalse(pixelIterator.hasNext());
    try {
      Pixel pix = pixelIterator.next();
      assertFalse(true);
    } catch (NoSuchElementException e) {
    }
  }

  @Test
  public void testSampleIterator() {
    // Verify all legal parameters work,
    // because we know that the number of legal combinations is small
    for (int init_x = 0; init_x < p[0].getWidth(); init_x++) {
      for (int init_y = 0; init_y < p[0].getHeight(); init_y++) {
        for (int dx = 1; dx <= p[0].getWidth(); dx++) {
          for (int dy = 1; dy <= p[0].getHeight(); dy++) {
            Iterator<Pixel> pixelIterator = p[0].sample(init_x, init_y, dx, dy);
            assertNotNull(pixelIterator);
            for (int i = init_y; i < p[0].getHeight(); i += dy) {
              for (int j = init_x; j < p[0].getWidth(); j += dx) {
                assertTrue(pixelIterator.hasNext());
                Pixel pix = pixelIterator.next();
                Pixel picPix = p[0].getPixel(j, i);
                assertEquals(pix.getBlue(), picPix.getBlue(), 0.0);
                assertEquals(pix.getGreen(), picPix.getGreen(), 0.0);
                assertEquals(pix.getRed(), picPix.getRed(), 0.0);
              }
            }
            assertFalse(pixelIterator.hasNext());
            try {
              Pixel pix = pixelIterator.next();
              assertFalse(true);
            } catch (NoSuchElementException e) {
            }
          }
        }
      }
    }

    try {
      Iterator<Pixel> pixelIterator = p[0].sample(-1, 0, 1, 1);
      fail();
    } catch (IllegalArgumentException e) {
    }

    try {
      Iterator<Pixel> pixelIterator = p[0].sample(0, -1, 1, 1);
      fail();
    } catch (IllegalArgumentException e) {
    }

    try {
      Iterator<Pixel> pixelIterator = p[0].sample(p[0].getWidth(), 0, 1, 1);
      fail();
    } catch (IllegalArgumentException e) {
    }

    try {
      Iterator<Pixel> pixelIterator = p[0].sample(0, p[0].getHeight(), 1, 1);
      fail();
    } catch (IllegalArgumentException e) {
    }

    try {
      Iterator<Pixel> pixelIterator = p[0].sample(0, 0, 0, 1);
      fail();
    } catch (IllegalArgumentException e) {
    }

    try {
      Iterator<Pixel> pixelIterator = p[0].sample(0, 0, 1, 0);
      fail();
    } catch (IllegalArgumentException e) {
    }

    int numTests = 10000;
    for (int tests = 0; tests < numTests; tests++) {
      int initialX = (int) Math.random() * 2 - 1 * Integer.MAX_VALUE;
      int initialY = (int) Math.random() * 2 - 1 * Integer.MAX_VALUE;
      int dx = (int) Math.random() * 2 - 1 * Integer.MAX_VALUE;
      int dy = (int) Math.random() * 2 - 1 * Integer.MAX_VALUE;
      boolean isValid = initialX >= 0 && initialX < p[0].getWidth()
              && initialY >= 0 && initialY < p[0].getHeight()
              && dx > 0 && dy > 0;
      if (!isValid) {
        try {
          Iterator<Pixel> pixelIterator = p[0].sample(0, 0, 1, 0);
          fail();
        } catch (IllegalArgumentException e) {
        }
      } else {
        Iterator<Pixel> pixelIterator = p[0].sample(initialX, initialY, dx, dy);
        assertNotNull(pixelIterator);
        for (int i = initialY; i < p[0].getHeight(); i += dy) {
          for (int j = initialX; j < p[0].getWidth(); j += dx) {
            assertTrue(pixelIterator.hasNext());
            Pixel pix = pixelIterator.next();
            Pixel picPix = p[0].getPixel(j, i);
            assertEquals(pix.getBlue(), picPix.getBlue(), 0.0);
            assertEquals(pix.getGreen(), picPix.getGreen(), 0.0);
            assertEquals(pix.getRed(), picPix.getRed(), 0.0);
          }
        }
        assertFalse(pixelIterator.hasNext());
        try {
          Pixel pix = pixelIterator.next();
          assertFalse(true);
        } catch (NoSuchElementException e) {
        }
      }
    }
  }

}
