package learning.test;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class DutchNationalFlagProblem {

	public static void main(String[] args) {

		final int[] ar = { 0, 2, 1, 1, 1, 2, 0 };

		int n = ar.length;
		BiConsumer<Integer, Integer> swapConsumer = (x, y) -> {
			int temp = ar[x];
			ar[x] = ar[y];
			ar[y] = temp;
		};
		int low = 0, mid = 0, high = n - 1;
		while (mid <= high) {
			if (ar[mid] == 0) {
				swapConsumer.accept(low, mid);
				low++;
				mid++;
			} else if (ar[mid] == 1) {
				mid++;
			} else {
				swapConsumer.accept(mid, high);
				high--;
			}
		}

		Arrays.stream(ar).forEach(System.out::println);

	}
}
