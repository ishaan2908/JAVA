import java.util.Scanner;
import java.util.Random;

class QuickSortRandomized
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //size of the array
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        quickSort(arr, 0, arr.length-1);
        for(int i : arr)
            System.out.print(i + " ");
    }

    static void quickSort(int arr[], int start, int end)
    {
        if(start < end)
        {
            int partitionIndex=randomPartition(arr, start, end);
            quickSort(arr, start, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    static int randomPartition(int arr[], int start, int end)
    {
        // to choose a random pivot
        Random r = new Random();
		    //generate a random number between start and end
        int pivotIndex = r.nextInt((end - start) + 1) + start;
        // swapping the default pivot with the randomly choosen pivot
        int t = arr[end];
        arr[end] = arr[pivotIndex];
        arr[pivotIndex] = t;
        return partition(arr, start, end); //normal call to partition function
    }
    
    static int partition(int arr[], int start, int end)
    {
        int pivot = arr[end];
        int partitionIndex = start;
        for(int i = start; i < end; i++)
        {
            if(arr[i] <= pivot) // swap if element is lesser than pivot
            {
                int t = arr[i];
                arr[i] = arr[partitionIndex];
                arr[partitionIndex] = t;
                partitionIndex += 1;
            }
        }
        int t = arr[end]; //swapping the pivot
        arr[end] = arr[partitionIndex];
        arr[partitionIndex] = t;
        return partitionIndex;
    }
    
}
