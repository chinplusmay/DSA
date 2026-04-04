/*
Given an array arr[] of size n, find the sum of the K-th largest sum among all contiguous subarrays.
In other words, identify the K-th largest sum from all possible subarrays and return it.
*/
#include <bits/stdc++.h>
using namespace std;


// brute
int kthLargest1(vector<int> &arr, int k) {// tc: N^2(Log(N))
    vector<int> sums; //contains sum of each subarr
    for(int i = 0; i<arr.size(); i++){
        int sum = 0;
        for(int j = i; j<arr.size(); j++){
            sum += arr[j];
            sums.push_back(sum);
        }
    }
    sort(sums.begin(), sums.end());
    
    int ans = sums[sums.size() - k];
    return ans;

}

int kthLargest2(vector<int> &arr, int k) {// tc: N^2(Log(k))
    priority_queue<int, vector<int>, greater<int>> mini; //minheap

    for(int i = 0; i<arr.size(); i++){
        int sum = 0;
        for(int j = i; j<arr.size(); j++){
            sum += arr[j];
            
            if(mini.size() < k){
                mini.push(sum);
            }
            else{
                if(mini.top() < sum){
                    mini.pop();
                    mini.push(sum);
                }
            }
        }
    }

    return mini.top();

}


int main(){
    vector<int> a = {3, 2, 1};
    int k = 2;
    cout<<kthLargest2(a, k);
}