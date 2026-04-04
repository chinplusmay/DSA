#include <bits/stdc++.h>
using namespace std;

// -67 -> 67
// s = a1 a2 a3 a4
// x: selected ele out of 7
// rem ele which are getting negated : s-x
// sum = -(s-x) + x = 2x - s maximize this
// choosing x as maximum ele

int main(){
    int t;
    cin>>t;

    while(t--){
        vector<int> arr(7);
        for(int i = 0; i<7; i++){
            cin>>arr[i];
        }

        int s = 0;
        int mx = INT_MIN;
        for(int i : arr){
            s += i;
            mx = max(mx, i);
        }
        //maximized sum:
        cout << 2*mx - s<<endl;
        
    }
}