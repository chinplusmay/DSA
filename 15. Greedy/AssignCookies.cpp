#include <bits/stdc++.h>
using namespace std;

//find how many childrens are contented with or satified with the given cookie size acc to thier greed factor
// sorted both as we want to spend as less cookies as possible to satify the kids given greed[i] <= cookiesize[j]

int findContentChildren(vector<int>& g, vector<int>& s) {// nlogn + mlogm + s.size()
    //pointers
    int child = 0;
    int cookiesize = 0;

    sort(g.begin(), g.end());
    sort(s.begin(), s.end());

    while(child < g.size() && cookiesize < s.size()){
        if(s[cookiesize] >= g[child]){
            child++; //kid satified
        }
        cookiesize++; //cookie assigned or rejected
    }
    return child;
}

int main(){
    vector<int> greedchilds = {1, 5, 3, 3, 4};
    vector<int> cookiesize = {4, 2, 1, 2, 1, 3};
    cout<<findContentChildren(greedchilds, cookiesize);
}