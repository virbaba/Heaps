/*
  Approach: first we make max heap by 0 to k - 1 element and the from k to n we compare 0th index element if 0th element is greater than to kth element we replace it and then we make
  max heap

  Remember that when we want to find kth min element than we make MAX heap for k element and when we want to find kth max element than we make MIN heap for k element
*/
public class Solution {

    // this is heapify algo for max heap
    public static void heapify(int[] arr, int i, int n){
         int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && arr[largest] < arr[left])
            largest = left;
        if(right < n && arr[largest] < arr[right])
            largest = right;
        if(largest != i){
            int t = arr[largest];
            arr[largest] = arr[i];
            arr[i] = t;
            heapify(arr, largest, n);
        }
    }


    public static int kthSmallest(int n,int k, int[]arr) {
        // Write your code here.
        for(int i = (k/2)-1; i >= 0; i--){
            heapify(arr, i, k);
        }

        for(int i = k; i < n; i++){
            if(arr[0] > arr[i]){
                arr[0] = arr[i];
                heapify(arr, 0, k);
            }
        }

        return arr[0];
    }
}
