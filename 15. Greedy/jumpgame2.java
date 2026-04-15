import java.util.*;

public class jumpgame2 {

    public static int Jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int l = 0, r = 0;
        while(r < n-1){
            int farthest = 0;
            for(int i = l; i<=r; i++){
                farthest = Math.max(farthest, i+nums[i]);
            }
            l = r+1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        int result = Jump(arr); // 2jumps needed 

        System.out.println(result);
    }
}