import java.util.*;
public class GenerateSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int subset_size = 1 << n; //2^n
        List<List<Integer>> subsets = new ArrayList<>();
        for(int mask = 0; mask < subset_size; mask++){
            List<Integer> subset = new ArrayList<>();
            for(int i = 0; i<n; i++){
                if((mask & (1 << i)) != 0){ //if ith bit is set/on
                    subset.add(nums[i]);
                }
            }subsets.add(subset);
        }
        return subsets;
    } 


    public static void main(String[] args) {
        GenerateSubsets ob = new GenerateSubsets();
        int[] nums = {1,2,4};
        List<List<Integer>> ans = ob.subsets(nums);
        System.out.println(ans);
    }
}
