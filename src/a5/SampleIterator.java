package a5;

import java.util.Iterator;

public class SampleIterator implements Iterator<Pixel> {

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pixel next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Cannot remove pixels from a picture");
	}

}
