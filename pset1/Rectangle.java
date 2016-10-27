/* Laura Zhang
 * lbz2106
 * Rectangle class for use in problems 1 and 2
 */

public class Rectangle implements Comparable<Rectangle> {
	public int length;
	public int width;

	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public int getPerimeter() {
		int perimeter = 2 * (length + width);
		return perimeter;
	}
	
	// implements comparable method comparing by perimeter
	public int compareTo(Rectangle other) {
    	int perimeter = getPerimeter();
    	if (perimeter == other.getPerimeter())
    		return 0;
    	if (perimeter > other.getPerimeter())
    		return 1;
    	else
    		return -1;
	}

}

