//import java.util.Scanner;
//
//public class MaximumSubarraySum {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Input array size
//        System.out.print("Enter the size of the array: ");
//        int size = scanner.nextInt();
//
//        // Input array elements
//        int[] array = new int[size];
//        System.out.println("Enter the elements of the array:");
//        for (int i = 0; i < size; i++) {
//            array[i] = scanner.nextInt();
//        }
//
//        // Calculate maximum subarray sum and subarray
//        int[] result = findMaximumSubarray(array, 0, size - 1);
//
//        // Display the result
//        System.out.println("Maximum Subarray Sum: " + result[2]);
//        System.out.print("Maximum Subarray: ");
//        for (int i = result[0]; i <= result[1]; i++) {
//            System.out.print(array[i] + " ");
//        }
//
//        scanner.close();
//    }
//
//    // Function to find the maximum subarray sum and subarray using divide and conquer
//    private static int[] findMaximumSubarray(int[] array, int low, int high) {
//        if (low == high) {
//            return new int[]{low, high, array[low]}; // Base case: Only one element
//        }
//
//        int mid = (low + high) / 2;
//
//        // Recursively find the maximum subarray sum and subarray in the left and right halves
//        int[] leftSubarray = findMaximumSubarray(array, low, mid);
//        int[] rightSubarray = findMaximumSubarray(array, mid + 1, high);
//        int[] crossingSubarray = findMaximumCrossingSubarray(array, low, mid, high);
//
//        // Compare the results from left, right, and crossing subarrays to find the maximum subarray
//        if (leftSubarray[2] >= rightSubarray[2] && leftSubarray[2] >= crossingSubarray[2]) {
//            return leftSubarray;
//        } else if (rightSubarray[2] >= leftSubarray[2] && rightSubarray[2] >= crossingSubarray[2]) {
//            return rightSubarray;
//        } else {
//            return crossingSubarray;
//        }
//    }
//
//    // Function to find the maximum subarray sum and subarray crossing the midpoint
//    private static int[] findMaximumCrossingSubarray(int[] array, int low, int mid, int high) {
//        int leftSum = Integer.MIN_VALUE;
//        int sum = 0;
//        int maxLeft = mid;
//
//        for (int i = mid; i >= low; i--) {
//            sum += array[i];
//            if (sum > leftSum) {
//                leftSum = sum;
//                maxLeft = i;
//            }
//        }
//
//        int rightSum = Integer.MIN_VALUE;
//        sum = 0;
//        int maxRight = mid;
//
//        for (int i = mid + 1; i <= high; i++) {
//            sum += array[i];
//            if (sum > rightSum) {
//                rightSum = sum;
//                maxRight = i;
//            }
//        }
//
//        return new int[]{maxLeft, maxRight, leftSum + rightSum};
//    }
//}
