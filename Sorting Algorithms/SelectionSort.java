import java.util.Scanner;

class SelectionSort
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //size of the array
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            arr[i] = scan.nextInt();
        }
        for(int i = 0; i < n-1; i++)
        {
            int smallIndex = i;
            for(int j = i + 1; j < n; j++)
            {
                if(arr[j] < arr[smallIndex])
                    smallIndex = j;
            }
            if(smallIndex != i)
            {
                int t = arr[i];
                arr[i] = arr[smallIndex];
                arr[smallIndex] = t;
            }
        }
        System.out.println("Sorted Array:");
        for(int i : arr)
            System.out.print(i + " ");
    }
}
