import java.util.*;
public class quicksort {

    private static void quicksorting(int[] arr,int low,int high){
        int j;


        // condition to call partition and quicksort recursively 


        if(low<high){


            j = partition(low,high,arr);
            quicksorting(arr, low, j);
            quicksorting(arr, j+1, high);

        }

    }


    private static int partition(int low, int high, int[] arr){
        
         // applying randomness

        int temp = 0;

        Random ran = new Random();
  
        int index = low+ran.nextInt(high-low+1);

        // swapping random

        temp=arr[index];
        arr[index]=arr[low];
        arr[low]=temp;
        
        
        // normal partition 
        
        int pivot = arr[low];
        int i=low-1;
        int j = high+1;
        


        while(i<j){


            do{
            i++;
            }while(arr[i]<=pivot);


            do{
            j--;
            }while(arr[j]>pivot);

            // swapping of arr[i],arr[j]

            if(i<j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            }


        }

            // swapping arr[j],arr[pivot] 

            temp = arr[low];
            arr[low] = arr[j];
            arr[j] = temp;


        return j;
    }




    public static void main(String[] args){

        // taking user input elements

        int arr[] = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE ELEMENTS IN THE ARRAY");
        for(int i=0;i<9;i++){
            arr[i] = sc.nextInt();
        }

        // calling quicksort function with low=0 and high = 9 and passing arr
        
        quicksorting(arr,0,8);

        // output will come

        System.out.println("THE SORTED ARRAY IS: ");
        for(int i=0;i<9;i++){
            System.out.println(arr[i]);
        }

        sc.close();

    }
}
