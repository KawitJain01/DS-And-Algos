package array.sorting;

import java.util.Arrays;

/**
 * Class contains algorithms that moves all 0's numbers
 * at the end of given array.
 * 
 * @see https://www.techiedelight.com/move-zeros-present-array-end/
 * @see https://www.geeksforgeeks.org/move-zeroes-end-array-set-2-using-single-traversal/
 */
public class MoveAllZerosToEndInArray {

	/**
	 * Method moves all 0's present in the given array 
	 * to the end of the given array.
	 * Time Complexity: O(N)
	 * Space Complexity: O(1)
	 * 
	 * @param ar array of numbers
	 */
	public static void moveAllZerosToEnd(int[] arr)
	{
		int count = 0; // count of non 0's
		
		int temp; // constant used for swapping non-zero element with 0
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] != 0)
			{
				temp = arr[count]; 
		        arr[count] = arr[i]; 
		        arr[i] = temp; 
		        count++;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = { 4,3,0,1,3,0,5,0 };
		
		moveAllZerosToEnd(arr);
		
		System.out.println(Arrays.toString(arr));		
	}
}
