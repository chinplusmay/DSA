#include <bits/stdc++.h>;
using namespace std;

int longestStreak(vector<int> &arr, int n, int k){
    int l = 0;
    int streak = 0;
    int zeroes = 0;

    for(int r = 0; r<n; r++){
        
        if(arr[r] == 0) zeroes++;

        while(zeroes > k){
            if(arr[l] == 0){
                zeroes--;
            }
            l++;
        }        
        streak = max(streak, r-l+1);

    }
    return streak;
}



int main(){
    int n, k;
    cin>>n;
    cin>>k;

    vector<int> arr(n);

    int temp;
    for(int i = 0; i<n; i++){
        cin>> arr[i];
    }

    cout<<longestStreak(arr, n, k);
}