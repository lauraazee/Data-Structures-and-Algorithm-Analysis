/* Laura Zhang
 * lbz2106
 * finds largest Rectangle object by perimeter
 */

public class Problem1 {
	
	public static <AnyType extends Comparable<AnyType>> AnyType findMax(AnyType[] arr) { // findMax routine provided in the problem.
  	
  	int maxIndex = 0;
  	
  	for (int i = 1; i < arr.length; i++) {
    	if (arr[i].compareTo(arr[maxIndex]) > 0 ) {
       		maxIndex = i;
    	}
  	}

    return arr[maxIndex];
	}

	public static void main(String[] args) {
		
		//creates array of rectangles
		Rectangle a = new Rectangle(7,8);
		Rectangle b = new Rectangle(5,6);
		Rectangle c = new Rectangle(4,5);
		Rectangle d = new Rectangle(10,11);
		Rectangle e = new Rectangle(2,3);
		Rectangle f = new Rectangle(3,4);
		Rectangle[] rectangleArray = {a, b, c, d, e, f};
		
		//finds largest rectangle by perimeter
		Rectangle maxRectangle = findMax(rectangleArray);
		
		int maxRectangleLength = maxRectangle.getLength();
		int maxRectangleWidth = maxRectangle.getWidth();
		
		System.out.println("The largest rectangle is the rectangle with a length of "+maxRectangleLength+" and a width of "+maxRectangleWidth);
	}
}