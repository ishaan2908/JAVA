import java.util.Scanner;

class InsertionSort
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //size of the array
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        for(int i = 1; i < n; i++)
        {
            int value = arr[i];
            int hole = i;
            while(hole-1 >= 0 && arr[hole-1] > value)
            {
                arr[hole] = arr[hole-1];
                hole -= 1;
            }
            arr[hole] = value;
        }
        System.out.println("Sorted Array:");
        for(int i : arr)
            System.out.print(i + " ");
    }
}
