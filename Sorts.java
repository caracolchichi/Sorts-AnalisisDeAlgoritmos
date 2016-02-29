/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Andres
 */
public class Sorts {
    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
             
        
        int size = 1000000;
        
        int [] a = new int[size];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt();
        }
        
        for (int i = 0; i < 10; i++) {
        long startTime = System.currentTimeMillis();
        quickSort(a, 0, a.length-1);
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Tiempo de ejecucion para "+ size+" objetos: "+duration);
        }
        
        
    }
    private static int[] BubbleSort (int size){
        int [] intArray = new int[size];
        Random r = new Random();
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = r.nextInt();
        }
        int n = intArray.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {

                if (intArray[j - 1] > intArray[j]) {
                    //swap the elements!
                    temp = intArray[j - 1];
                    intArray[j - 1] = intArray[j];
                    intArray[j] = temp;
                }

            }
        }
        return intArray;
}
    public static int[] InsertionSort(int size){
         int [] input = new int[size];
        Random r = new Random();
        for (int i = 0; i < input.length; i++) {
            input[i] = r.nextInt();
        }
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }
    public static void HeapSort(int size){
        int [] a0 = new int[size];
        Random r = new Random();
        for (int i = 0; i < a0.length; i++) {
            a0[i] = r.nextInt();
        }
        
        a=a0;
        buildheap(a);
        
        for(int i=n;i>0;i--){
            exchange(0, i);
            n=n-1;
            maxheap(a, 0);
        }
    }
    
    public static void buildheap(int []a){
        n=a.length-1;
        for(int i=n/2;i>=0;i--){
            maxheap(a,i);
        }
    }
    
    public static void maxheap(int[] a, int i){ 
        left=2*i;
        right=2*i+1;
        if(left <= n && a[left] > a[i]){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= n && a[right] > a[largest]){
            largest=right;
        }
        if(largest!=i){
            exchange(i,largest);
            maxheap(a, largest);
        }
    }
    
    public static void exchange(int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t; 
        }
    
    public static void SelectionSort ( int size )
{
    int [] num = new int[size];
        Random r = new Random();
        for (int i = 0; i < num.length; i++) {
            num[i] = r.nextInt();
        }
     int i, j, first, temp;  
     for (i = num.length - 1; i > 0; i --)  
     {
          first = 0;   //initialize to subscript of first element
          for(j = 1; j <= i; j ++)   //locate smallest element between positions 1 and i.
          {
               if( num[ j ] < num[ first ] )         
                 first = j;
          }
          temp = num[ first ];   //swap smallest found with element in position i.
          num[ first ] = num[ i ];
          num[ i ] = temp; 
      }           
}
    public static void mergeSort(int size)
	{
        int [] a = new int[size];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt();
        }
		int[] tmp = new int[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
	}


	private static void mergeSort(int [ ] a, int [ ] tmp, int left, int right)
	{
		if( left < right )
		{
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center + 1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}


    private static void merge(int[ ] a, int[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left] != a[right])
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
    
    public static void radixsort(int size) {
        int [] input = new int[size];
        Random r = new Random();
        for (int i = 0; i < input.length; i++) {
            input[i] = r.nextInt(9999);
        }
        
  final int RADIX = 10000;
  // declare and initialize bucket[]
  List<Integer>[] bucket = new ArrayList[RADIX];
  for (int i = 0; i < bucket.length; i++) {
    bucket[i] = new ArrayList<Integer>();
  }
 
  // sort
  boolean maxLength = false;
  int tmp = -1, placement = 1;
  while (!maxLength) {
    maxLength = true;
    // split input between lists
    for (Integer i : input) {
      tmp = i / placement;
      bucket[tmp % RADIX].add(i);
      if (maxLength && tmp > 0) {
        maxLength = false;
      }
    }
    // empty lists into input array
    int a = 0;
    for (int b = 0; b < RADIX; b++) {
      for (Integer i : bucket[b]) {
        input[a++] = i;
      }
      bucket[b].clear();
    }
    // move to next digit
    placement *= RADIX;
  }
}
    public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}

}


