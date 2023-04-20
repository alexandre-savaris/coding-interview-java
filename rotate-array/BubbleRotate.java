import java.util.Arrays;

// Space is O(1) and time is O(n*k).
public class BubbleRotate {

    private static void rotate(int[] nums, int k) {

        // If the rotation size is greater than the array size, adjusts it to ignore full rotations.
        // For example: if the array size (n) = 7 and the rotation size (k) = 15,
        // there are two full rotations (wich can be ignored).
        // The remainder (1) corresponds to the new rotation size.
        if(k > nums.length) {
            k = k % nums.length;
        }

        // Move the array elements from left to right, one at a time. Repeat for k times.
        int temp;
        for(int i = 0; i < k; i++) {
            for(int j = nums.length - 1; j > 0; j--) {
                temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
    
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(nums));
    
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
