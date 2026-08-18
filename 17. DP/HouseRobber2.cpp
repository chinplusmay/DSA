#include <bits/stdc++.h>;
using namespace std;
// same as HouseRobber-1 just here houses are aranged in circular pattern means
// we cant steal from adjacent houses which includes not stealing 0th house and n-1th house


 //top-down
int t[101];   
int solve(vector<int>& nums, int i, int n){ // HouseRobber-1
    if(i > n) return 0;  // here only ">" as n is not size here is a valid index (n-2 and n-2 are valid index of subarray) 

    if(t[i] != -1) return t[i];
    int steal = nums[i] + solve(nums, i+2, n);
    int skip = solve(nums, i+1, n);

    return t[i] = max(steal, skip);
}


int rob(vector<int>& nums) {
    int n = nums.size();
    memset(t, -1, sizeof(t));
    // case 1 : take 0th house then we can take last house n-1
    int take_0th = solve(nums, 0, n-2);

    // case 2 : skip 0th, take 1st index 
    int take_1st = solve(nums, 1, n-1);

    return max(take_0th, take_1st);

    
}


int main(){
    vector<int> nums = {1, 2, 3, 1}; //4: 1 + 3
    cout<<rob(nums);
}