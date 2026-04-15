import java.util.*;

// we can jump to any index which is <= arr[i]
// ex 2 3 1 1 4, at index 0:a[0]=2 so we can jump to either 1 , 2 index
// we will track the max index we can jump to if we encounter a index which is greater than maxindex thats not possble hence false

public class jumpgame1 {

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int mxInd = 0;
        for(int i = 0; i<nums.length; i++){
            if(mxInd < i) return false;
            mxInd = Math.max(mxInd, i+nums[i]);
            if(mxInd >= n-1) return true;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
         boolean result = canJump(arr);

        System.out.println(result);
    }
}