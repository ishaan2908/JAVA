import java.util.Scanner;

public class HeapSort {

	public void sort(int[] arr, int size) {
		// build a max heap 
		for(int i = (size - 2) / 2; i >= 0; i--) {
			heapify(arr, size, i);
		}

		while(size-- > 0) {
			int t = arr[0]; // swap the largest(first) element with the last element
			arr[0] = arr[size];
			arr[size] = t;

			// again, build a max heap out of the array with reduced size
			heapify(arr, size, 0); 
		}
	}

	public void heapify(int[] arr, int size, int i) {
		int largestIndex = i;
		int leftIndex = 2 * i + 1;
		int rightIndex = 2 * i + 2;

		if(leftIndex < size && arr[leftIndex] > arr[largestIndex])
			largestIndex = leftIndex;

		if(rightIndex < size && arr[rightIndex] > arr[largestIndex])
			largestIndex = rightIndex;

		if(largestIndex != i) {
			int t = arr[largestIndex];
			arr[largestIndex] = arr[i];
			arr[i] = t;

			heapify(arr, size, largestIndex);
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();

		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}

		HeapSort hs = new HeapSort();
		hs.sort(arr, size);

		System.out.println("Sorted Array is: ");
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
}
