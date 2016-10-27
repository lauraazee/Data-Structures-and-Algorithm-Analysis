/* Laura Zhang
 * lbz2106
 * Records runtime of fragments with various input sizes
 */

import java.util.Arrays;

public class Problem3 {

	//first fragment
	public static void fragmentA(int n) {
		int sum = 0;
		for ( int i = 0; i < 23; i ++) {
    		for ( int j = 0; j < n ; j ++) {
        		sum = sum + 1;
    		}
		}
	}

	//second fragment
	public static void fragmentB(int n) {
		int sum = 0;
		for ( int i = 0; i < n ; i ++) {
    		for ( int k = i ; k < n ; k ++) {
        		sum = sum + 1;
    		}
		}
	}

	//third fragment
	public static int foo(int n, int k) {
    	if(n<=k) {
        	return 1;
    	}
    	else {
        	return foo(n/k,k) + 1;
    	}
	}

	public static void main(String[] args) {
		
		long starTime = 0;
		long endTime = 0;

		//runs fragment A through various input sizes and creates an array with the runtime of each input
		int[] fragmentAValues = {5, 10, 20, 30, 50, 100, 300, 500, 1000, 3000, 5000, 10000};
		long[] fragmentATimes = new long[fragmentAValues.length];
		for(int i = 0; i < fragmentATimes.length; i++) {
			starTime = System.nanoTime();
			fragmentA(fragmentAValues[i]);
			endTime = System.nanoTime();
			fragmentATimes[i] = endTime - starTime;
		}

		//runs fragment B through various input sizes and creates an array with the runtime of each input
		int[] fragmentBValues = {5, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110}; 
		long[] fragmentBTimes = new long[fragmentBValues.length];
		for(int i = 0; i < fragmentBValues.length; i++) {
			starTime = System.nanoTime();
			fragmentB(fragmentBValues[i]);
			endTime = System.nanoTime();
			fragmentBTimes[i] = endTime - starTime;
		}

		//runs fragment C through various input sizes and creates an array with the runtime of each input
		int[] fooValues = {1000, 5000, 10000, 50000, 100000, 500000, 1000000, 5000000, 10000000, 50000000, 100000000, 500000000};
		long[] fooTimes = new long[fooValues.length];
		int k = 2;
		for(int i = 0; i < fooValues.length; i++) {
			starTime = System.nanoTime();
			foo(fooValues[i], k);
			endTime = System.nanoTime();
			fooTimes[i] = endTime - starTime;
		}

		//prints arrays with runtimes for each fragment
		System.out.println(Arrays.toString(fragmentATimes));
		System.out.println(Arrays.toString(fragmentBTimes));
		System.out.println(Arrays.toString(fooTimes));

	}


}