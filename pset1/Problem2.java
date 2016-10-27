/* Laura Zhang
 * lbz2106
 * finds largest Rectangle object by perimeter
 */

import java.util.*;

public class Problem2 {

	//searches for rectangle x out of array of rectangles sorted by perimeter from smallest to largest
	public static <AnyType extends Comparable<AnyType>> int binarySearch(AnyType[] a, AnyType x) {
		
		int start;
		int end;

		start = 0;
		end = a.length - 1;
		
		int middle;
		
		Rectangle searchTerm = (Rectangle) x;

		while (start <= end) {
			middle = (start + end) / 2;
			Rectangle middleRectangle = (Rectangle) a[middle];
			
			if (searchTerm.compareTo(middleRectangle) == -1) {
				end = middle - 1;
			}
			else if (searchTerm.compareTo(middleRectangle) == 1) {
				start = middle + 1;
			}
			else {
				return middle; //method has successfully found the rectangle in the array and returns its array position
			}
		}

		return -1; //rectangle is not in the array

	}

	public static void main(String[] args) {
		
		//creates new rectangle array
		Rectangle a = new Rectangle(7,8);
		Rectangle b = new Rectangle(5,6);
		Rectangle c = new Rectangle(4,5);
		Rectangle d = new Rectangle(10,11);
		Rectangle e = new Rectangle(2,3);
		Rectangle f = new Rectangle(3,4);
		Rectangle[] rectangleArray = {a, b, c, d, e, f};

		int rectangleArrayLength = rectangleArray.length;
		
		/* creates a new array of perimeters of the rectangle array
		and a new map linking each perimeter to its corresponding rectangle */
		int[] rectanglePerimeters = new int[rectangleArrayLength];
		HashMap perimeterRectangleMap = new HashMap();

		for (int i = 0; i < rectangleArrayLength; i++) {
			int perimeter = rectangleArray[i].getPerimeter();
			rectanglePerimeters[i] = perimeter;
			perimeterRectangleMap.put(perimeter, rectangleArray[i]);
		}

		Arrays.sort(rectanglePerimeters); 

		/*Creates array of sorted rectangles by taking the array of sorted perimeters and using the map linking perimeters to rectangles.*/
		Rectangle[] sortedRectangleArray = new Rectangle[rectangleArrayLength];

		for (int i = 0; i < rectangleArrayLength; i++) {
			int rectanglePerimeter = rectanglePerimeters[i];
			Object rectangle = perimeterRectangleMap.get(rectanglePerimeter);
			sortedRectangleArray[i] = (Rectangle) rectangle;
		}

		//Searches the sorted array of rectangles for the searchRectangle
		Rectangle searchRectangle = new Rectangle(7,8);
		System.out.println(binarySearch(sortedRectangleArray, searchRectangle));
	}
}