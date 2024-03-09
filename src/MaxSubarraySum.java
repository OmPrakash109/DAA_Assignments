import java.util.*;
public class MaxSubarraySum {
    public static int maxSarray(int[] nums) {
        int n = nums.length;
        int maxEndingHere = nums[0];
        int maxSum = nums[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > maxEndingHere + nums[i]) {
                maxEndingHere = nums[i];
                tempStart = i;
            } else {
                maxEndingHere += nums[i];
            }
            if (maxEndingHere > maxSum) {
                maxSum = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }
        System.out.println("Maximum Subarray sum is " + maxSum);
        System.out.print("\nMaximum subarray : ");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        maxSarray(arr);
    }
}
