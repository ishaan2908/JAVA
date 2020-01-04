import java.util.Scanner;

class BubbleSort
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //size of the array
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        int flag = 0;
        for(int i = 1; i <= n-1; i++) //iteration for the number of rounds
        {
            flag=0;
            for(int j = 0; j+1 <= n-i; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    //swap element at index j with element at index j+1
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                    flag = 1;
                }
            }
            if(flag == 0)
            {
                // if not even a single swap occured
                break;
            }
        }
        for(int i : arr)
            System.out.print(i + " ");
    }
}
