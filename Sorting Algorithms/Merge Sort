import java.util.Scanner;

class MergeSort
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //size of the array
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        mergeSort(arr);
        for(int i : arr)
            System.out.print(i + " ");
    }

    static void mergeSort(int arr[])
    {
        int n = arr.length;
        if(n == 1) return; //base condition
        int mid = n/2;
        int left[] = new int[mid];
        int right[] = new int[n-mid];
        for(int i = 0;i < mid; i++)
            left[i] = arr[i];
        for(int i = mid; i < n; i++) 
            right[i - mid] = arr[i];
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    static void merge(int left[], int right[], int mainArr[])
    {
        //merges two sorted arrays into the main array
        int l = left.length, r = right.length, n = mainArr.length;
        int i = 0, j = 0, k = 0;
        while(i < l && j < r)
        {
            if(left[i] < right[j])
            {
                mainArr[k] = left[i];
                i += 1;
            }
            else
            {
                mainArr[k] = right[j];
                j += 1;
            }
            k += 1;
        }
        // if any of the subarrays have any left-overs.
        while(i < l)
        {
            mainArr[k] = left[i];
            i += 1;
            k += 1;
        }
        while(j < r)
        {
            mainArr[k] = right[j];
            j += 1;
            k += 1;
        }
    }

} 
