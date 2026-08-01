#include <bits/stdc++.h>
using namespace std;

// can be done by recursion using f(n-1)+f(n-2) but gives tle

class Solution {
public:

    // top down
    int solve(int n, vector<int> &dp){
        if(n < 0) return 0;
        if(n == 0) return 1;

        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = solve(n-1, dp) + solve(n-2, dp);
    }
    int climbStairs1(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;

        vector<int> dp(n+1, -1);

        return solve(n, dp);
    }

    // bottom up
    int climbStairs2(int n) {
        if(n < 0) return 0;
        vector<int> dp(n+1, -1);
        
        dp[0] = 1;
        dp[1] = 1;


        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }


    // bottom up const space
    int climbStairs3(int n) {
        if(n <= 1) return n;

        int a = 1;
        int b = 1;
        int c = 0;

        for(int i = 1; i<n; i++){
            c = a+b;
            a = b;
            b = c;
        }

        return c;

    }

    
};

int main() {
    Solution obj;

    cout << obj.climbStairs1(5) << endl; // 8

    return 0;
}