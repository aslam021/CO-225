/* Author      : Aslam M.M.M
   Reg.No      : E/15/021
   Assighnment : 3 - CO 225
*/

//Answers is at the end of this java file

class Main {

	// matrices may be changed
	public static int[][] a = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
	public static int[][] b = { { 1 }, { 1 }, { 1 } };

	// a method to print the matrix
	public static void print_matrix(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {

		// check whether matrices are suitable for multiply
		if (a[0].length == b.length) {

			// change the no of threads if needed
			int noOfThread = 3;

			if (noOfThread > a.length) {
				noOfThread = a.length;
			}

			// a method to allocate size of the resultatnt matrix
			MatThread.result(a.length, b[0].length, noOfThread);

			// initializing the arrray of thread class
			MatThread[] MatMal = new MatThread[a.length];

			// creating the thread and implement that
			for (int i = 0; i < noOfThread; i++) {
				MatMal[i] = new MatThread(a, b, i, noOfThread);
				MatMal[i].start();
			}

			// wait untill all threads finish thiere task
			for (int i = 0; i < noOfThread; i++) {
				try {
					MatMal[i].join();
				} catch (InterruptedException e) {
					System.out.println("Error in Thread");
					System.exit(-1);
				}
			}

			// print the final output
			print_matrix(MatThread.c);

		} else {
			System.out.println("Could not multiply, Invalid matrix sizes");
		}

	}
}

// ********************** ANSWERS ****************************//

// 1. How to use threads to parallelize the operation?
/*
 * multi-threaded program contains two or more parts that can run concurrently
 * and each part can handle a different task at the same time making optimal use
 * of the available resources specially when a computer has multiple CPUs. We
 * can create threads in several ways. 1. Create a Thread by Extending a Thread
 * Class 2. Create a Thread by Implementing a Runnable Interface
 * 
 * By creating new objects for the Thread class, we can run a new thread.
 */

// 2. How may threads to use?
/*
 * Initially no of threads was pre defined to 3. But if we want we can change
 * that. BTW if no of threads is set to a large number than no of arrays of the
 * first matrix then it will be set to No of arrays. If noOfThreads < NoOfArrays
 * arrays divided equally to threads and balance will be given to the last
 * thread
 */

// 3. How to allocate work for each thread (recall it is the run function which
// all the threads execute)
/*
 * Work is allocated by creating array of threads. This is easy to implement
 * different matrix sizes. If enough threads available each thread will do one
 * array's and one column's multiplications. Otherwise arrays will be divided as
 * sets and given to the thread
 */

// 4. How to synchronize?
/*
 * If we have a varibale, that will change with every thread, then we have to
 * use the syncronized methods to make sure only one thread execute that
 * variable at a time. But in this case no sitations came like that. So
 * syncronized method did not use. But if there is variable like that we have to
 * use that variable inside a sycronized method.
 */
