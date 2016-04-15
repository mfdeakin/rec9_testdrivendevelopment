package a5;

import java.util.Iterator;

public class TileIterator implements Iterator<SubPicture> {

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SubPicture next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Cannot remove subpictures from a picture");
	}

}
