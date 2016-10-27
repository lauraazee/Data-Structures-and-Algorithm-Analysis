/* Laura Zhang
 * lbz2106
 * Test class for TwoStackQueue class
 */

public class Program2 {



    /** If implemented correctly, this code should output: 
	* Roses
	* Peonies
	* Daisies
	* Chrysanthemums
	* Dandelions
	* 0
	* null
	* Sunflowers

     */
    public static final void main(String[] args) {


	TwoStackQueue<String> testQueue = new TwoStackQueue<String>();

	testQueue.enqueue("Roses");
	System.out.println(testQueue.dequeue());
	testQueue.enqueue("Peonies");
	testQueue.enqueue("Daisies");
	testQueue.enqueue("Chrysanthemums");
	testQueue.enqueue("Dandelions");
	while(!testQueue.isEmpty()) {
	    System.out.println(testQueue.dequeue());
	}
	System.out.println(testQueue.size());
	System.out.println(testQueue.dequeue());
	testQueue.enqueue("Sunflowers");
	System.out.println(testQueue.dequeue());

    }





}