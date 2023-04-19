import java.util.Arrays;

// Space is O(n) and time is O(n).
public class IntermediateArray {

    private static void rotate(int[] nums, int k) {

        // If the rotation size is greater than the array size, adjusts it to ignore full rotations.
        // For example: if the array size (n) = 7 and the rotation size (k) = 15,
        // there are two full rotations (wich can be ignored).
        // The remainder (1) corresponds to the new rotation size.
        if(k > nums.length) {
            k = k % nums.length;
        }
    
        // New temporary array.
        int[] result = new int[nums.length];
    
        // Fills in the first k positions of the temporary array.
        for(int i = 0; i < k; i++) {
            result[i] = nums[nums.length - k + i];
        }
    
        // Fills in the remainder positions of the temporary array.
        int j = 0;
        for(int i = k; i < nums.length; i++) {
            result[i] = nums[j];
            j++;
        }

        // Copy the content of the temporary array to the original array.
        System.arraycopy(result, 0, nums, 0, nums.length);
    }
    
    public static void main(String[] args) {
    
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(nums));
    
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
