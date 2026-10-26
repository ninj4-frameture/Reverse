import java.util.Arrays;
import  java.util.Scanner;
public class Main {
    // Divide the array into smaller subarrays
    public static void ReverseSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            // Sort the left half
            ReverseSort(arr, left, mid);
            // Sort the right half
            ReverseSort(arr, mid + 1, right);
            // Reverse the sorted halves
            Reverse(arr, left, mid, right);
        }
    }
    private static void Reverse(int[] arr, int left, int mid, int right) {
        merge(arr, left, mid, right);
    }
    // Reverse two sorted subarrays
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        // Copy elements into temporary arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        // Compare and merge elements in sorted order
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // Copy any remaining elements from L
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // Copy any remaining elements from R
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {18, 29, 30, 49, 65, 79, 83, 95};
        System.out.println("Original array: "+ Arrays.toString(arr));
        ReverseSort(arr, 0, arr.length - 1);
        int left = 0;
        int right = arr.length - 1;
        // Reverse the entire array
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        System.out.println("Reverse array: "+ Arrays.toString(arr));
    }
}