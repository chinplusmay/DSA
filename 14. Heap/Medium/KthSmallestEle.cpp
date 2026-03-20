#include <bits/stdc++.h>
using namespace std;

// brute: heapsort array return k-1 ele
// opti approach:
// s1: insert elements from 0 to k in the max heap(pq)
// s2: iterate the remaining eles(k to n)
// check is ele < pq.top() if yes pop out the top from pq and push ele into the pq

int kthSmallest(vector<int> &arr, int k) {
    int n = arr.size();
    //using priority queue
    priority_queue<int> pq;

    for(int i = 0; i<k; i++){
        pq.push(arr[i]);
    }

    for(int i = k; i<n; i++){
        if(arr[i] < pq.top()){
            pq.pop();
            pq.push(arr[i]);
        }
    }
    return pq.top();

}

int main(){
    vector<int> arr = {10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
    cout << kthSmallest(arr, 4);

}

