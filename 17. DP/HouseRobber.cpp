#include <bits/stdc++.h>
using namespace std;


class Solution {
public:

    // recursive
    int solve1(vector<int>& nums, int i){
        if(i >= nums.size()) return 0;

        int steal = nums[i] + solve1(nums, i+2);
        int skip = solve1(nums, i+1);

        return max(steal, skip);
    }
    int rob1(vector<int>& nums) {
        return solve1(nums, 0);
    }

    //memoi

    //top-down
    int t[101];   // constraint 1 <= nums.length <= 100 
    int solve2(vector<int>& nums, int i){
        if(i >= nums.size()) return 0;

        if(t[i] != -1) return t[i];
        int steal = nums[i] + solve2(nums, i+2);
        int skip = solve2(nums, i+1);

        return t[i] = max(steal, skip);
    }
    int rob2(vector<int>& nums) {
        memset(t, -1, sizeof(t));
        return solve2(nums, 0);
    }

    //bottom-down
    int rob3(vector<int>& nums) {
        int n = nums.size();
        memset(t, -1, sizeof(t));
        
        t[0] = 0;
        t[1] = nums[0];
 
        for(int i = 2; i<=n; i++){
            int steal = t[i-2] + nums[i-1];  // amt stolen till prevprev + current amt
            int skip = t[i-1]; //amt stolen till prev

            t[i] = max(steal, skip);
        }

        return t[n];
    }




};



int main(){
    Solution ob;

    vector<int> n = {2,1,1,2}; // 2+2 =4
    cout<<ob.rob3(n);
}