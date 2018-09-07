import java.util.Arrays;
import java.util.Random;


public class Practice03Test {

	protected int count = 0;
	protected double [] arr;
	private int resIndex = -1;

	/**
	 * Constructor
	 */
	public Practice03Test (String [] args) {
		try {
			count = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Defaulting array size to 20.");
			count = 20;
		}
		arr = new double[count];
		generate_array();
	}


	/**
	 * print_array: prints the array of doubles... formatted so it fits
	 * ... on many small screens.
	 */
	public void print_array() {
		System.out.println("------------------------------------");
		System.out.println("Array contains the values:");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%.2f ", arr[i]);
			if (i > 0 && i % 9 == 0)
				System.out.println();
		}
		System.out.println("\n------------------------------------");
	}


	/**
	 * Fills the array with random double instances.
	 */
	public void generate_array() {
		Random rand = new Random();
		double min = 1.0;
		double max = 100.0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = min + rand.nextDouble() * (max-min);
		}
	}


	public int find_min_iterative () {
		// TODO: Fill in this iterative function.
		int count = 0;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[count]) {
				count = i;
			}
		}
		return count;
	}


	public int find_min_recursive () {
		// TODO: Fill in this recursive function.
		
		find_min_recursive(0, arr);
		return resIndex;
	
	}
	
	public double find_min_recursive (int index, double[] array) {
		
		if (index == array.length-1) {
			resIndex = index;
			return array[index];
		}
			
		double tempRes = find_min_recursive(index+1, array);
		if (array[index] < tempRes) {
			resIndex = index;
			return array[index];
		}
		
		else {
			return tempRes;
		}
	}


	/**
	 * print_min: determines the min iteratively and recursively.
	 * ... and prints them both.
	 */
	public void print_min() {
		System.out.println("Iteratively determined min at index " + find_min_iterative());
		System.out.println("Recursively determined min at index " + find_min_recursive());
	}


	/**
	 * main for Practice 03: print the array and determine the min.
	 */
	public static void main(String [] args) {
		Practice03Test test = new Practice03Test(args);
		test.print_array();
		test.print_min();
	}

}
