import java.util.Arrays;

// Space is O(1) and time is O(n).
public class Reversal {

    private static void reverse(int[] nums, int left, int right) {

        if(nums == null || nums.length == 1) {
            return;
        }

        // Reverse the array elements, from position left to the position right (both included).
        int temp;
        while(left < right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    private static void rotate(int[] nums, int k) {

        // If the rotation size is greater than the array size, adjusts it to ignore full rotations.
        // For example: if the array size (n) = 7 and the rotation size (k) = 15,
        // there are two full rotations (wich can be ignored).
        // The remainder (1) corresponds to the new rotation size.
        if(k > nums.length) {
            k = k % nums.length;
        }

        // Divide the array in two parts.
        // Reverse each part, and at the end reverse the whole array.
        int a = nums.length - k;
        reverse(nums, 0, a-1);
        reverse(nums, a, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(nums));
    
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
